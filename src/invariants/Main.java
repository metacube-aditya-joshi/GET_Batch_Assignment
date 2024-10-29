package invariants;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CustomException {

	try (Scanner inputScanner = new Scanner(System.in)) {
	    boolean repeatMenu = true;
	    while (repeatMenu) {
		int[][] sparseMatrix = generateSparseMatrix(inputScanner);
		SparseMatrix matrix = new SparseMatrix(sparseMatrix);

		System.out.println("Enter Option :");
		System.out.println("1. Transpose of matrix");
		System.out.println("2. Check Symmeticity of matrix");
		System.out.println("3. Add two matrices");
		System.out.println("4. Multiply two matrices");
		System.out.println("5. Exit");
		int options = inputScanner.nextInt();

		if (options == 0)
		    throw new CustomException("Option zero is not defined!!");

		if (options == 1) {

		    matrix.transposeMatrix();
		    repeatMenu = true;

		} else if (options == 2) {

		    System.out.println(matrix.isMatrixSymmetrical());
		    repeatMenu = true;

		} else if (options == 3) {
		    int[][] sparseMatrix2 = generateSparseMatrix(inputScanner);
		    matrix.addTwoMatrices(sparseMatrix2);
		    repeatMenu = true;

		} else if (options == 4) {
		    int[][] sparseMatrix2 = generateSparseMatrix(inputScanner);
		    matrix.multipyTwoMatrices(sparseMatrix2);
		    repeatMenu = true;

		} else if (options == 5) {

		    System.out.println("Exiting!!");
		    repeatMenu = false;
		    break;

		} else {
		    System.out.println("Enter correct options");
		    repeatMenu = true;
		}
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	    throw new CustomException("Error in main function ");
	}

    }

    static int[][] generateSparseMatrix(Scanner inputScanner) {

	int[][] sparseMatrix = null;
	try {
	    System.out.println("Enter the dimension of sparse matrix :");
	    int row = inputScanner.nextInt();
	    int col = inputScanner.nextInt();

	    sparseMatrix = new int[row][col];

	    System.out.println("Enter the data in matrix :");

	    for (int r = 0; r < row; r++) {
		for (int c = 0; c < col; c++) {
		    sparseMatrix[r][c] = inputScanner.nextInt();
		}
	    }

	} catch (Exception e) {
	    // TODO: handle exception
	}
	return sparseMatrix;

    }

}
