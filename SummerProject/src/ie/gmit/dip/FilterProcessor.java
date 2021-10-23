package ie.gmit.dip;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FilterProcessor {

	/*
	 * bright -> a variable that is multiplied with each ARGB element of a pixel to
	 * edit the overall pixel brightness
	 * 
	 * intense -> a variable that is used to alter the multiplication factor between
	 * the filter kernel and the ARGB of a pixel.
	 * 
	 * filter -> a variable the contains the filter to be applied to an image. If no
	 * filter is selected by the user, the Identity filter selected by default.
	 */

	private double bright = 1;
	private double intense = 0;
	private double[][] filter = new double[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

	public void setFilter(double[][] filterInput) {
		this.filter = filterInput;
	}

	public void setBrightness(double bright) {
		this.bright = bright;
	}

	public void setIntensity(double intense) {
		this.intense = intense;
	}

	public void processImage(BufferedImage out) {

		// Iterate through every pixel of the image
		for (int y = 0; y < out.getHeight(); y++) {
			for (int x = 0; x < out.getWidth(); x++) {

				int pixel = 0;

				// Retrieve the ARGB of the pixel
				pixel = out.getRGB(x, y);

				// Set image colour to red
				out.setRGB(x, y, 0x00FF0000);

				// Assign each ARGB element of the pixel to their respective variables
				int alpha = (pixel & 0xff000000) >>> 24;
				int red = (pixel >>> 16) & 0xff;
				int green = (pixel >>> 8) & 0xff;
				int blue = pixel & 0xff;

				// Recreate the ARGB of the pixel and re-assign it to the pixel
				int argb = 0;
				argb = argb | (alpha << 24);
				argb = argb | (red << 16);
				argb = argb | (green << 8);
				argb = argb | blue;
				out.setRGB(x, y, argb);

				// Apply a method to the pixel which will retrieve the ARGB of the pixel once a
				// filter and extra options has been applied
				int fPixel = applyFilter(out, pixel, x, y);
				out.setRGB(x, y, fPixel);
			}
		}
		
		try {
			// Once every pixel of the image has been processed, save the "new" image to
			// "imageOutput/out.png"
			ImageIO.write(out, "png", new File( "imageOutput/out.png"));

		} catch (IOException e) {

		}
	}

	// A method to apply a filter to a pixel
	public int applyFilter(BufferedImage image, int pixel, int x, int y) {

		// Retrieve the argb of the pixel and assign it to "element", a more appropriate
		// name for this method
		int element = pixel;

		// Initialise each argb
		double alpha = 0, red = 0, green = 0, blue = 0;

		// Iterate through each part of the 2D array (filter)
		for (int row = 0; row < filter.length; row++) {
			for (int col = 0; col < filter.length; col++) {
				try {

					// Algorithm to wrap around the pixel to allow for the filter to be applied to
					// all parts of the image and not ignore the outline
					// Wrapper algorithm sourced from https://pastebin.com/4Bq6UaJL
					int modX = (x - filter.length / 2 + col + image.getWidth()) % image.getWidth();
					int modY = (y - filter.length / 2 + row + image.getWidth()) % image.getWidth();

					// Find the ARGB of the pixel after applying the wrapper algorithm
					element = image.getRGB(modX, modY);
					int A = (element >> 24) & 0xff; // Alpha value
					int R = (element >> 16) & 0xff; // Red value
					int G = (element >> 8) & 0xff; // Green value
					int B = (element) & 0xff; // Blue value

					// Apply the chosen filter to each element of ARGB and set the result to the
					// previously initialised ARGB variables
					// Concept of altering filter intensity sourced from
					// http://tech.abdulfatir.com/2014/05/kernel-image-processing.html?m=1
					alpha += (A * filter[row][col]);
					red += (R * (filter[row][col] + intense));
					green += (G * (filter[row][col] + intense));
					blue += (B * (filter[row][col] + intense));

				} catch (Exception e) {

					continue;
				}
			}
		}

		// Initialise a new ARGB variable
		int newArgb = 0;

		// Initialise each element of the new ARGB
		int outA = 0, outR = 0, outG = 0, outB = 0;

		// Apply the "bright" variable to each ARGB element and ensure that each don't
		// go beyond the range 0 - 255
		// Concept of altering image brightness sourced from
		// http://tech.abdulfatir.com/2014/05/kernel-image-processing.html?m=1

		outA = (int) Math.min(Math.max((alpha * bright), 0), 255);
		outR = (int) Math.min(Math.max((red * bright), 0), 255);
		outG = (int) Math.min(Math.max((green * bright), 0), 255);
		outB = (int) Math.min(Math.max((blue * bright), 0), 255);

		// Create the new ARGB using new values of each element
		newArgb = newArgb | (outA << 24);
		newArgb = newArgb | (outR << 16);
		newArgb = newArgb | (outG << 8);
		newArgb = newArgb | (outB);

		// Return the new ARGB value after applying all parameters to the "processImage"
		// method to allow the "new" image to be created and written
		return newArgb;

	}
}
