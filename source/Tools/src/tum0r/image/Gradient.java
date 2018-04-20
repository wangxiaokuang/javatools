package tum0r.image;

import java.awt.image.BufferedImage;

import tum0r.misc.ToolsConfig;

public class Gradient {

	public static BufferedImage handle(BufferedImage inImage, int direction, int outType) {
		BufferedImage outImage = null;
		if (inImage != null) {
			int width = inImage.getWidth();
			int height = inImage.getHeight();
			int[] pixels = new int[width * height];
			int[] outPixels = new int[width * height];
			int type = inImage.getType();
			outImage = new BufferedImage(width, height, outType);
			if (type == BufferedImage.TYPE_INT_ARGB || type == BufferedImage.TYPE_INT_RGB) {
				inImage.getRaster().getDataElements(0, 0, width, height, pixels);
			} else {
				inImage.getRGB(0, 0, width, height, pixels, 0, width);
			}
			int index1, index2, index3, index4;
			int newX, newY;
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					newX = x + 1 > 0 ? (x + 1 < width ? x + 1 : 0) : 0;
					newY = y + 1 > 0 ? (y + 1 < height ? y + 1 : 0) : 0;
					index1 = width * y + x;
					index2 = width * y + newX;
					index3 = width * newY + x;
					index4 = width * newY + newX;
					int a = (pixels[index1] >> 24) & 0xff;
					int xred = ((pixels[index1] >> 16) & 0xff) - ((pixels[index4] >> 16) & 0xff);
					int xgreen = ((pixels[index1] >> 8) & 0xff) - ((pixels[index4] >> 8) & 0xff);
					int xblue = (pixels[index1] & 0xff) - (pixels[index4] & 0xff);

					int yred = ((pixels[index2] >> 16) & 0xff) - ((pixels[index3] >> 16) & 0xff);
					int ygreen = ((pixels[index2] >> 8) & 0xff) - ((pixels[index3] >> 8) & 0xff);
					int yblue = (pixels[index2] & 0xff) - (pixels[index3] & 0xff);

					int red = 0;
					int green = 0;
					int blue = 0;
					if (direction == ToolsConfig.XY) {
						red = (int) (Math.sqrt(Math.pow(xred, 2) + Math.pow(yred, 2)) + 0.5);
						green = (int) (Math.sqrt(Math.pow(xgreen, 2) + Math.pow(ygreen, 2)) + 0.5);
						blue = (int) (Math.sqrt(Math.pow(xblue, 2) + Math.pow(yblue, 2)) + 0.5);
					} else if (direction == ToolsConfig.X) {
						red = (int) (xred + 0.5);
						green = (int) (xgreen + 0.5);
						blue = (int) (xblue + 0.5);
					} else if (direction == ToolsConfig.Y) {
						red = (int) (yred + 0.5);
						green = (int) (ygreen + 0.5);
						blue = (int) (yblue + 0.5);
					}

					red = red < 0 ? 0 : red > 255 ? 255 : red;
					green = green < 0 ? 0 : green > 255 ? 255 : green;
					blue = blue < 0 ? 0 : blue > 255 ? 255 : blue;

					outPixels[index1] = a << 24 | (red << 16) | (green << 8) | blue;
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
