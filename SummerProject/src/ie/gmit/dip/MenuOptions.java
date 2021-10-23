package ie.gmit.dip;

public class MenuOptions {

	// Method to display the main menu options to the console
	public static void mainOptions() {
		System.out.println(ConsoleColour.BLUE_BRIGHT);
		System.out.println("***************************************************");
		System.out.println("* GMIT - Dept. Computer Science & Applied Physics *");
		System.out.println("*                                                 *");
		System.out.println("*           Image Filtering System V0.1           *");
		System.out.println("*     H.Dip in Science (Software Development)     *");
		System.out.println("*                                                 *");
		System.out.println("***************************************************");
		System.out.println(ConsoleColour.RESET);

		System.out.println("1) Enter an image filepath");
		System.out.println("2) Adjust brightness and filter intensity");
		System.out.println("3) Select a filter");
		System.out.println("4) Create filtered image");
		System.out.println("5) Exit application");

		System.out.println(ConsoleColour.GREEN_BOLD);

		System.out.println("Select Option [1-5]");
		System.out.println(ConsoleColour.RESET);

	}

	// Method to display the additional options menu to the console
	public static void additionalOptions() {
		System.out.println(ConsoleColour.GREEN_BOLD);

		System.out.println("[INFO] Please choose a type of additional parameter to add to the new image");
		System.out.println(ConsoleColour.RESET);

		System.out.println("1) Change brightness");
		System.out.println("2) Change filter intensity");
		System.out.println("3) Return to main menu");

		System.out.println(ConsoleColour.GREEN_BOLD);

		System.out.println("Select Option [1-3]");
		System.out.println(ConsoleColour.RESET);

	}

	// Method to display the brightness options menu to the console
	public static void brightnessOptions() {
		System.out.println(ConsoleColour.GREEN_BOLD);

		System.out.println("[INFO] Please choose a brightness option");
		System.out.println(ConsoleColour.RESET);

		System.out.println("1) Default image brightness");
		System.out.println("2) Adjust brightness by -50%");
		System.out.println("3) Adjust brightness by -40%");
		System.out.println("4) Adjust brightness by -30%");
		System.out.println("5) Adjust brightness by -20%");
		System.out.println("6) Adjust brightness by -10%");
		System.out.println("7) Adjust brightness by +10%");
		System.out.println("8) Adjust brightness by +20%");
		System.out.println("9) Adjust brightness by +30%");
		System.out.println("10) Adjust brightness by +40%");
		System.out.println("11) Adjust brightness by +50%");
		System.out.println("12) Return to additional options menu");

		System.out.println(ConsoleColour.GREEN_BOLD);

		System.out.println("Select option [1-12]");
		System.out.println(ConsoleColour.RESET);
	}

	// Method to display the intensity options menu to the console
	public static void intensityOptions() {
		System.out.println(ConsoleColour.GREEN_BOLD);

		System.out.println("[INFO] Please choose a filter intensity option");
		System.out.println(ConsoleColour.RESET);

		System.out.println("1) Default filter intensity");
		System.out.println("2) Adjust filter intensity by -50%");
		System.out.println("3) Adjust filter intensity by -40%");
		System.out.println("4) Adjust filter intensity by -30%");
		System.out.println("5) Adjust filter intensity by -20%");
		System.out.println("6) Adjust filter intensity by -10%");
		System.out.println("7) Adjust filter intensity by +10%");
		System.out.println("8) Adjust filter intensity by +20%");
		System.out.println("9) Adjust filter intensity by +30%");
		System.out.println("10) Adjust filter intensity by +40%");
		System.out.println("11) Adjust filter intensity by +50%");
		System.out.println("12) Return to additional options menu");

		System.out.println(ConsoleColour.GREEN_BOLD);

		System.out.println("Select option [1-12]");
		System.out.println(ConsoleColour.RESET);
	}

	// Method to display the filter menu options to the console
	public static void filterOptions() {
		System.out.println(ConsoleColour.GREEN_BOLD);

		System.out.println("[INFO] Please choose a filter option");
		System.out.println(ConsoleColour.RESET);

		System.out.println("1) Identity");
		System.out.println("2) Edge Detection");
		System.out.println("3) Emboss");
		System.out.println("4) Laplacian");
		System.out.println("5) Sharpen");
		System.out.println("6) Vertical Lines");
		System.out.println("7) Diagonal Lines");
		System.out.println("8) Box Blur");
		System.out.println("9) Gaussian Blur");
		System.out.println("10) Sobel Vertical");
		System.out.println("11) Sobel Horizontal");
		System.out.println("12) Return to main menu");

		System.out.println(ConsoleColour.GREEN_BOLD);

		System.out.println("Select Option [1-13]");
		System.out.println(ConsoleColour.RESET);
	}
}
