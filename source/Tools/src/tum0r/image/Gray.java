package tum0r.image;

import java.awt.image.BufferedImage;

public class Gray {
	public static BufferedImage handle(BufferedImage inImage) {
		BufferedImage outImage = null;
		if (inImage != null) {
			int width = inImage.getWidth();
			int height = inImage.getHeight();
			int[] Pixels = new int[width * height];
			int type = inImage.getType();
			outImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);
			if (type == BufferedImage.TYPE_INT_ARGB || type == BufferedImage.TYPE_INT_RGB) {
				inImage.getRaster().getDataElements(0, 0, width, height, Pixels);
				outImage.getRaster().setDataElements(0, 0, width, height, Pixels);
			} else {
				inImage.getRGB(0, 0, width, height, Pixels, 0, width);
				outImage.setRGB(0, 0, width, height, Pixels, 0, width);
			}
		}
		return outImage;
	}
}
