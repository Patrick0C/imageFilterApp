package ie.gmit.dip;

public enum Intensity {

	//Application of enum sourced from https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html

	
	//Default filter intensity
	DEFAULTINTENSITY(0),
	
	//Lower filter intensity
	LESS50(-0.5),								//Lower filter intensity by 50%
	LESS40(-0.4),								//Lower filter intensity by 40%
	LESS30(-0.3),								//Lower filter intensity by 30%
	LESS20(-0.2),								//Lower filter intensity by 20%
	LESS10(-0.1),								//Lower filter intensity by 10%
	
	//Increase filter intensity
	MORE10(0.1),								//Increase filter intensity by 10%
	MORE20(0.2),								//Increase filter intensity by 20%
	MORE30(0.3),								//Increase filter intensity by 30%
	MORE40(0.4),								//Increase filter intensity by 40%
	MORE50(0.5);								//Increase filter intensity by 50%
	
	private final double intense;

	private Intensity(double intense) {
		this.intense = intense;
	}

	public double getntense() {
		return intense;
	}
}
