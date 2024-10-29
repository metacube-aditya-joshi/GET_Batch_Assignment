package invariants;

public final class SparseMatrix {
    final int[][] sparseMatrix;


	/**
     * Constructs a SparseMatrix from a given 2D array.
     *
     * @param sparseMatrix a 2D array representing the sparse matrix
     * @throws CustomException if the input matrix is null or if an error occurs during construction
     */
    public SparseMatrix(int[][] sparseMatrix) throws CustomException {

	try {
	    this.sparseMatrix = new int[sparseMatrix.length][sparseMatrix[0].length];
	    for (int row = 0; row < sparseMatrix.length; row++) {
		for (int col = 0; col < sparseMatrix[0].length; col++) {
		    if (sparseMatrix[row][col] != 0)
			this.sparseMatrix[row][col] = sparseMatrix[row][col];
		}
	    }
	    displayMatrix(this.sparseMatrix);
	} catch (NullPointerException e) {
	    e.printStackTrace();
	    throw new CustomException("Error in Constuctor");
	}

    }

	/**
     * Transposes the current sparse matrix.
     */
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

	 /**
     * Displays the given matrix in a formatted manner.
     *
     * @param sparseMatrix the matrix to be displayed
     */
    private void displayMatrix(int[][] sparseMatrix) {
	for (int row = 0; row < sparseMatrix.length; row++) {

	    for (int col = 0; col < sparseMatrix[0].length; col++) {
		System.out.print("| " + sparseMatrix[row][col]);
	    }
	    System.out.println();

	}

    }

	/**
     * Checks if the current sparse matrix is symmetrical.
     *
     * @return a string indicating whether the matrix is symmetrical or not
     */
    public String isMatrixSymmetrical() {

	for (int row = 0; row < sparseMatrix.length; row++) {
	    for (int col = row; col < sparseMatrix[0].length; col++) {
		if (this.sparseMatrix[row][col] != this.sparseMatrix[col][row])
		    return "This Matrix is not Symmetrical";
	    }
	}
	return "This Matrix is Symmetrical";

    }

	 /**
     * Adds another sparse matrix to the current matrix.
     *
     * @param sparseMatrix2 the matrix to be added
     * @throws CustomException if the matrices have different dimensions or if an error occurs during addition
     */
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

	/**
     * Multiplies the current sparse matrix with another matrix.
     *
     * @param sparseMatrix2 the matrix to be multiplied
     * @throws CustomException if the matrices cannot be multiplied or if an error occurs during multiplication
     */
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
