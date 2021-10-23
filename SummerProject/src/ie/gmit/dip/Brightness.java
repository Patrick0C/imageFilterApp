package ie.gmit.dip;

public enum Brightness {
	
	//Application of enum sourced from https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html

	
	//Default image brightness
	DEFAULTBRIGHT(1.0),
	
	//Lower image brightness
	DARK50(0.05), 								//Lower image brightness by 50%
	DARK40(0.04), 								//Lower image brightness by 40%
	DARK30(0.03), 								//Lower image brightness by 30%
	DARK20(0.02), 								//Lower image brightness by 20%
	DARK10(0.01),								//Lower image brightness by 10%
	
	//Increase image brightness 
	BRIGHT10(1.01),								//Increase image brightness by 10%
	BRIGHT20(1.02),								//Increase image brightness by 20%
	BRIGHT30(1.03),								//Increase image brightness by 30%
	BRIGHT40(1.04),								//Increase image brightness by 40%
	BRIGHT50(1.05);								//Increase image brightness by 50%

	private final double bright;

	private Brightness(double bright) {
		this.bright = bright;
	}

	public double getBright() {
		return bright;
	}
}
