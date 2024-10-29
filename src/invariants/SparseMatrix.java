package invariants;

public final class SparseMatrix {
    final int[][] sparseMatrix;

    public SparseMatrix(int[][] sparseMatrix) throws CustomException {

	try {
	    this.sparseMatrix = new int[sparseMatrix.length][sparseMatrix[0].length];
	    for (int row = 0; row < sparseMatrix.length; row++) {
		for (int col = 0; col < sparseMatrix[0].length; col++) {
		    this.sparseMatrix[row][col] = sparseMatrix[row][col];
		}
	    }
	} catch (NullPointerException e) {
	    e.printStackTrace();
	    throw new CustomException("Error in Constuctor");
	}

    }

    public void transposeMatrix() {

	for (int row = 0; row < sparseMatrix.length; row++) {
	    for (int col = row; col < sparseMatrix[0].length; col++) {
		int swapElement = this.sparseMatrix[row][col];
		this.sparseMatrix[row][col] = this.sparseMatrix[col][row];
		this.sparseMatrix[col][row] = swapElement;
	    }
	}
	displayMatrix(sparseMatrix);

    }

    private void displayMatrix(int[][] sparseMatrix) {
	for (int row = 0; row < sparseMatrix.length; row++) {
	   
	    for (int col = 0; col < sparseMatrix[0].length; col++) {
		System.out.print("| " + this.sparseMatrix[row][col]);
	    }
	    System.out.println();
	    
	}

    }

    public String isMatrixSymmetrical() {

	for (int row = 0; row < sparseMatrix.length; row++) {
	    for (int col = row; col < sparseMatrix[0].length; col++) {
		if (this.sparseMatrix[row][col] != this.sparseMatrix[col][row])
		    return "This Matrix is not Symmetrical";
	    }
	}
	return "This Matrix is Symmetrical";

    }

    public void addTwoMatrices(int[][] sparseMatrix2) throws CustomException {

	try {
	    if (this.sparseMatrix.length != sparseMatrix2.length
		    || this.sparseMatrix[0].length != sparseMatrix2[0].length) {
		throw new CustomException("Either matrix is not initialised or passed null");
	    }

	    int[][] tempMatrix = new int[this.sparseMatrix.length][this.sparseMatrix[0].length];

	    for (int row = 0; row < sparseMatrix.length; row++) {
		for (int col = 0; col < sparseMatrix[0].length; col++) {
		    tempMatrix[row][col] = (this.sparseMatrix[row][col] + sparseMatrix2[row][col]);
		}
	    }

	    displayMatrix(tempMatrix);

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new CustomException("Error in add two matrix funciton ");

	}
    }

    public void multipyTwoMatrices(int[][] sparseMatrix2) throws CustomException {
	try {
	    int firstCol = this.sparseMatrix[0].length;
	    int secondRow = sparseMatrix2.length;

	    if (firstCol != secondRow)
		throw new Exception();

	    int[][] multMatrix = new int[this.sparseMatrix.length][sparseMatrix2[0].length];
	    for (int rowOuter = 0; rowOuter < this.sparseMatrix.length; rowOuter++) {
		for (int colInner = 0; colInner < sparseMatrix2[0].length; colInner++) {
		    int sum = 0;
		    for (int mult = 0; mult < firstCol; mult++) { // Use firstCol for the inner loop
			sum += this.sparseMatrix[rowOuter][mult] * sparseMatrix2[mult][colInner];
		    }
		    multMatrix[rowOuter][colInner] = sum; // Store the result in the result matrix
		}
	    }
	    displayMatrix(multMatrix);

	} catch (Exception e) {
	    e.printStackTrace();
	    throw new CustomException("Error in Multiply two matrix funciton ");
	}
    }

}
