package ie.gmit.dip;

public class Runner {
	public static void main(String[] args) {

		Menu m = new Menu();

		/*
		 * The method "start" is called in "main" to begin the entire image filter 
		 * application
		 */		
		try {
			m.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
