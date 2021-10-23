package ie.gmit.dip;

import java.io.File;

import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class ImageWriter {

	// Variable that is assigned to the image file path
	public static BufferedImage image;

	public static BufferedImage loadImage(String fileName) throws IOException {

		// Read in an image and convert it into a BufferedImage
		BufferedImage image = ImageIO.read(new File(fileName));

		return image;
	}
}
