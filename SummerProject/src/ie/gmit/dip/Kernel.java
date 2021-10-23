package ie.gmit.dip;

public enum Kernel {

	//Application of enum sourced from https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html
	
	//Filter options
	IDENTITY(new double[][] {					//Return image unmodified
		{ 0, 0, 0 },
		{ 0, 1, 0 },
		{ 0, 0, 0 }
		}
	),

	EDGE_DETECTION(new double[][] {				//Edge detection filter
		{ -1, -1, -1 },
		{ -1, 8, -1 },
		{ -1, -1, -1 }
		}
	),

	LAPLACIAN(new double[][] {					//Laplacian filter
		{ 0, -1, 0 },
		{ -1, 4, -1 },
		{ 0, -1, 0 }
		}
	),

	SHARPEN(new double[][] {					//Image sharpen filter
		{ 0, -1, 0 },
		{ -1, 5, -1 },
		{ 0, -1, 0 }
		}
	),
	
	VERTICAL_LINES(new double[][] {				//Vertical lines filter
		{ -1, 2, -1 },
		{ -1, 2, -1 },
		{ -1, 2, -1 }
		}
	),

	DIAGONAL_45_LINES(new double[][] {			//45° diagonal lines filter
		{ -1, -1, 2 },
		{ -1, 2, -1 },
		{ 2, -1, -1 }
		}
	),
	
	BOX_BLUR(new double[][] {					//Box blur filter
		{ 0.111, 0.111, 0.111 },
		{ 0.111, 0.111, 0.111 },
		{ 0.111, 0.111, 0.111 }
		}
	),
	
	GAUSSIAN_BLUR(new double[][] {				//Gaussian blur filter
		{ 0.0625, 0.125, 0.0625 },
		{ 0.125, 0.25, 0.125 },
		{ 0.0625, 0.125, 0.0625 }
		}
	),
	
	SOBEL_HORIZONTAL(new double[][] {			//Sobel horizontal filter
		{ -1, -2, -1 },
		{ 0, 0, 0 },
		{ 1, 2, 1 }
		}
	),

	SOBEL_VERTICAL(new double[][] {				//Sobel vertical filter
		{ -1, 0, 1 },
		{ -2, 0, 2 },
		{ -1, 0, 1 }
		}
	),
	
	EMBOSS(new double[][] {						//Emboss filter
		{ -1, -1, 0 },
		{ -1, 0, 1 },
		{ 0, 0, 1 }
		}
	);

	private final double[][] kernel;

	
	private Kernel(double[][] kernel) {
		this.kernel = kernel;
	}

	public double[][] getKernel() {
		return kernel;
	}
}
