package ie.gmit.dip;

import java.util.Scanner;

public class Menu {

	private Scanner s;
	FilterProcessor fp = new FilterProcessor();

	// While true, this application will continue to run. When false the application
	// will shutdown
	private boolean keepRunning = true;

	public Menu() {
		s = new Scanner(System.in);
	}

	// The primary method which allows for the entire application to function
	public void start() throws Exception {

		while (keepRunning) {

			// Display all main menu options to the user
			MenuOptions.mainOptions();
			System.out.print("-> ");

			// If the user enters a character other than a number, display an error message
			if (!s.hasNextInt()) {
				System.out.println(ConsoleColour.RED_UNDERLINED);

				System.out.println("[ERROR] Please only enter a number to choose an option");
				System.out.println(ConsoleColour.RESET);

			}

			// Parse the user input into an int
			int mainChoice = Integer.parseInt(s.next());

			switch (mainChoice) {

			case 1 -> {
				// If the number 1 is input, the user is prompted to enter an image file path,
				// this will be the image to be filtered

				System.out.println(ConsoleColour.GREEN_BOLD);

				System.out.println("[INFO] Please enter an image file path");
				System.out.println(ConsoleColour.RESET);
				System.out.print("-> ");

				ImageWriter.image = ImageWriter.loadImage(s.next());

				System.out.println(ConsoleColour.GREEN_UNDERLINED);

				System.out.println("[INFO] Image successfully loaded.");
				System.out.println(ConsoleColour.RESET);

			}
			case 2 -> {
				// If the number 2 is input, the user is prompted to select which additional
				// option they would like to add

				MenuOptions.additionalOptions();
				System.out.print("-> ");
				oSwitch();

			}
			case 3 -> {
				// If the number 3 is input, the user is prompted to select which filter they
				// would like to apply

				MenuOptions.filterOptions();
				System.out.print("-> ");
				fSwitch();

			}
			case 4 -> {
				// If the number 4 is input, the application processes all user choices and
				// writes the filtered image

				System.out.println(ConsoleColour.GREEN_UNDERLINED);

				System.out.println("[INFO] Applying filter, additional options and saving image. Please wait.");
				System.out.println(ConsoleColour.RESET);
				fp.processImage(ImageWriter.image);
				System.out.println("[INFO] Filter succesfully applied and image saved.");

			}
			case 5 -> {
				// If the number 5 is input, the application is shutdown

				System.out.println(ConsoleColour.GREEN_UNDERLINED);

				System.out.println("[INFO] System shutting down. Please wait.");
				System.out.println(ConsoleColour.RESET);

				keepRunning = false;

			}
			default -> {
				/*
				 * If the user inputs a number that is not recognised, the application will
				 * alert the user to what unexpected value they input and which options are
				 * valid.
				 */

				System.out.println(ConsoleColour.RED_UNDERLINED);

				System.out.println("[ERROR] Unexpected input: " + mainChoice
						+ ". Please enter a valid input in the range [1 - 5]");
				System.out.println(ConsoleColour.RESET);

			}
			}
		}
	}

	private void oSwitch() {
		// Parse the user input into an int

		int additionalChoice = Integer.parseInt(s.next());

		switch (additionalChoice) {
		case 1 -> {

			// If the user inputs 1, the options to change the image brightness are
			// displayed
			MenuOptions.brightnessOptions();
			System.out.print("-> ");
			bSwitch();

		}
		case 2 -> {

			// If the user inputs 2, the options to change the filter intensity are
			// displayed
			MenuOptions.intensityOptions();
			System.out.print("-> ");
			iSwitch();

		}
		case 3 -> {

			// If the user inputs 3, the main menu options are displayed
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Returning to main menu");
			System.out.println(ConsoleColour.RESET);

		}
		default -> {
			System.out.println(ConsoleColour.RED_UNDERLINED);
			/*
			 * If the user inputs a number that is not recognised, the application will
			 * alert the user to what unexpected value they input and which options are
			 * valid.
			 */
			System.out.println("[ERROR] Unexpected input: " + additionalChoice
					+ ". Please enter a valid input in the range [1 - 3]");
		}
		}
	}

	private void bSwitch() {

		// Method to display brightness options
		MenuOptions.brightnessOptions();
		System.out.print("-> ");

		// Parse the user input into an int
		int brightChoice = Integer.parseInt(s.next());

		// Initialise the input variable for the next selection
		double brightInput;

		switch (brightChoice) {

		// Based off the user input, alter the image brightness in a range from -50% to
		// +50%
		case 1 -> {
			brightInput = Brightness.DEFAULTBRIGHT.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Returning default image brightness");
			System.out.println(ConsoleColour.RESET);

		}
		case 2 -> {
			brightInput = Brightness.DARK50.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness lowered by 50%");
			System.out.println(ConsoleColour.RESET);

		}
		case 3 -> {
			brightInput = Brightness.DARK40.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness lowered by 40%");
			System.out.println(ConsoleColour.RESET);

		}
		case 4 -> {
			brightInput = Brightness.DARK30.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness lowered by 30%");
			System.out.println(ConsoleColour.RESET);

		}
		case 5 -> {
			brightInput = Brightness.DARK20.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness lowered by 20%");
			System.out.println(ConsoleColour.RESET);

		}
		case 6 -> {
			brightInput = Brightness.DARK10.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness lowered by 10%");
			System.out.println(ConsoleColour.RESET);

		}
		case 7 -> {
			brightInput = Brightness.BRIGHT10.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness increased by 10%");
			System.out.println(ConsoleColour.RESET);

		}
		case 8 -> {
			brightInput = Brightness.BRIGHT20.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness increased by 20%");
			System.out.println(ConsoleColour.RESET);

		}
		case 9 -> {
			brightInput = Brightness.BRIGHT30.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness increased by 30%");
			System.out.println(ConsoleColour.RESET);

		}
		case 10 -> {
			brightInput = Brightness.BRIGHT40.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness increased by 40%");
			System.out.println(ConsoleColour.RESET);

		}
		case 11 -> {
			brightInput = Brightness.BRIGHT50.getBright();
			fp.setBrightness(brightInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Brightness increased by 50%");
			System.out.println(ConsoleColour.RESET);

		}
		case 12 -> {
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Returning to additional options menu");
			System.out.println(ConsoleColour.RESET);

		}
		default -> {
			/*
			 * If the user inputs a number that is not recognised, the application will
			 * alert the user to what unexpected value they input and which options are
			 * valid.
			 */
			System.out.println(ConsoleColour.RED_UNDERLINED);

			System.out.println("[ERROR] Unexpected input: " + brightChoice
					+ ". Please enter a valid input int the range [1 - 12]");
			System.out.println(ConsoleColour.RESET);
		}
		}
	}

	private void iSwitch() {
		// Method to display filter intensity options

		int intenseChoice = Integer.parseInt(s.next());

		// Initialise the input variable for the next selection
		double intenseInput;

		switch (intenseChoice) {

		// Based off the user input, alter the filter intensity in a range from -50% to
		// +50%
		case 1 -> {
			intenseInput = Intensity.DEFAULTINTENSITY.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Returning default filter intensity");
			System.out.println(ConsoleColour.RESET);

		}
		case 2 -> {
			intenseInput = Intensity.LESS50.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity lowered by 50%");
			System.out.println(ConsoleColour.RESET);

		}
		case 3 -> {
			intenseInput = Intensity.LESS40.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity lowered by 40%");
			System.out.println(ConsoleColour.RESET);

		}
		case 4 -> {
			intenseInput = Intensity.LESS30.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity lowered by 30%");
			System.out.println(ConsoleColour.RESET);

		}
		case 5 -> {
			intenseInput = Intensity.LESS20.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity lowered by 20%");
			System.out.println(ConsoleColour.RESET);

		}
		case 6 -> {
			intenseInput = Intensity.LESS10.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity lowered by 10%");
			System.out.println(ConsoleColour.RESET);

		}
		case 7 -> {
			intenseInput = Intensity.MORE10.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity increased by 10%");
			System.out.println(ConsoleColour.RESET);

		}
		case 8 -> {
			intenseInput = Intensity.MORE20.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity increased by 20%");
			System.out.println(ConsoleColour.RESET);

		}
		case 9 -> {
			intenseInput = Intensity.MORE30.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity increased by 30%");
			System.out.println(ConsoleColour.RESET);

		}
		case 10 -> {
			intenseInput = Intensity.MORE40.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity increased by 40%");
			System.out.println(ConsoleColour.RESET);

		}
		case 11 -> {
			intenseInput = Intensity.MORE50.getntense();
			fp.setIntensity(intenseInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Filter intensity increased by 50%");
			System.out.println(ConsoleColour.RESET);

		}
		case 12 -> {
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Returning to additional options menu");
			System.out.println(ConsoleColour.RESET);

		}
		default -> {
			/*
			 * If the user inputs a number that is not recognised, the application will
			 * alert the user to what unexpected value they input and which options are
			 * valid.
			 */
			System.out.println(ConsoleColour.RED_UNDERLINED);

			System.out.println("[ERROR] Unexpected input: " + intenseChoice
					+ ". Please enter a valid input int the range [1 - 12]");
			System.out.println(ConsoleColour.RESET);

		}
		}
	}

	private void fSwitch() {

		// Method to display filter intensity options
		int filterChoice = Integer.parseInt(s.next());

		// Initialise the input variable for the next selection
		double[][] filterInput;

		// Based off the user input, select a filter to apply to an image
		switch (filterChoice) {
		case 1 -> {
			filterInput = Kernel.IDENTITY.getKernel();
			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Identity filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 2 -> {
			filterInput = Kernel.EDGE_DETECTION.getKernel();
			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Edge Detection filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 3 -> {
			filterInput = Kernel.EMBOSS.getKernel();

			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Emboss filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 4 -> {
			filterInput = Kernel.LAPLACIAN.getKernel();

			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Laplacian filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 5 -> {
			filterInput = Kernel.SHARPEN.getKernel();

			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Sharpen filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 6 -> {
			filterInput = Kernel.VERTICAL_LINES.getKernel();
			fp.setFilter(filterInput);

			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Vertical Lines filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 7 -> {
			filterInput = Kernel.DIAGONAL_45_LINES.getKernel();

			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Diagonal Lines filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 8 -> {
			filterInput = Kernel.BOX_BLUR.getKernel();

			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Box Blur filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 9 -> {
			filterInput = Kernel.GAUSSIAN_BLUR.getKernel();

			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Gaussian Blur filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 10 -> {
			filterInput = Kernel.SOBEL_VERTICAL.getKernel();

			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Sobel Vertical filter selected");
			System.out.println(ConsoleColour.RESET);

		}
		case 11 -> {
			filterInput = Kernel.SOBEL_HORIZONTAL.getKernel();

			fp.setFilter(filterInput);
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Sobel Horizontal filter selected");
			System.out.println(ConsoleColour.RESET);

		}

		case 12 -> {
			System.out.println(ConsoleColour.GREEN_UNDERLINED);

			System.out.println("[INFO] Returning to main menu");
			System.out.println(ConsoleColour.RESET);

		}
		default -> {
			/*
			 * If the user inputs a number that is not recognised, the application will
			 * alert the user to what unexpected value they input and which options are
			 * valid.
			 */
			System.out.println(ConsoleColour.RED_UNDERLINED);
			System.out.println("[ERROR] Unexpected input: " + filterChoice
					+ ". Please enter a valid input int the range [1 - 12]");
			System.out.println(ConsoleColour.RESET);

		}
		}
	}
}
