package tum0r.image;

import java.awt.image.BufferedImage;

import tum0r.misc.ToolsConfig;

public class Gamma {
	private int[] lut;
	private double gamma;

	public Gamma() {
		gamma = ToolsConfig.GAMMA;
	}
	public Gamma(double gamma) {
		this.gamma=gamma;
		lut = new int[256];
		for (int count = 0; count < 256; count++) {
			lut[count] = (int) (255 * Math.exp(Math.log(count / 255.0) * gamma));
		}
	}

	public BufferedImage handle(BufferedImage inImage,int outType) {
		BufferedImage outImage = null;
		if (inImage != null) {
			int width = inImage.getWidth();
			int height = inImage.getHeight();
			int[] inPixels = new int[width * height];
			int[] outPixels = new int[width * height];
			int type = inImage.getType();
			outImage=new BufferedImage(width, height, outType);
			if (type == BufferedImage.TYPE_INT_ARGB || type == BufferedImage.TYPE_INT_RGB) {
				inPixels=(int[]) inImage.getRaster().getDataElements(0, 0, width, height, inPixels);
			} else {
				inPixels=inImage.getRGB(0, 0, width, height, inPixels, 0, width);
			}
			int a, r, g, b;
			int index;
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					index = y * width + x;
					a = (inPixels[index] >> 24) & 0xff;
					r = (inPixels[index] >> 16) & 0xff;
					g = (inPixels[index] >> 8) & 0xff;
					b = inPixels[index] & 0xff;
					outPixels[index] = (a << 24 | (lut[r] << 16) | (lut[g] << 8) | lut[b]);
				}
			}
			if (outType == BufferedImage.TYPE_INT_ARGB || outType == BufferedImage.TYPE_INT_RGB) {
				outImage.getRaster().setDataElements(0, 0, width, height, outPixels);
			} else {
				outImage.setRGB(0, 0, width, height, outPixels, 0, width);
			}

		}
		return outImage;
	}
}
