package invariants;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class TestClass {
    private SparseMatrix sparseMatrix;

    @Test()
    public void testConstructorWithNullMatrix() throws CustomException {
	 assertThrows(CustomException.class, () -> new SparseMatrix(null));
	
    }

    @Test
    public void testTransposeMatrix() throws CustomException {
	int[][] matrix = { { 0, 0, 3 }, { 0, 0, 0 }, { 4, 0, 0 } };
	sparseMatrix = new SparseMatrix(matrix);
	sparseMatrix.transposeMatrix();
	
	int[][] expected = { { 0, 0, 4 }, { 0, 0, 0 }, { 3, 0, 0 } };
	assertArrayEquals(expected, sparseMatrix.sparseMatrix);
    }

    @Test
    public void testIsMatrixSymmetrical() throws CustomException {
	int[][] matrix = { { 0, 0, 3 }, { 0, 0, 0 }, { 4, 0, 0 } };
	sparseMatrix = new SparseMatrix(matrix);
	assertEquals("This Matrix is not Symmetrical", sparseMatrix.isMatrixSymmetrical());

	int[][] symmetricalMatrix = { { 1, 2, 3 }, { 2, 1, 4 }, { 3, 4, 1 } };
	SparseMatrix symMatrix = new SparseMatrix(symmetricalMatrix);
	assertEquals("This Matrix is Symmetrical", symMatrix.isMatrixSymmetrical());
    }

   @Test
   public void testAddTwoMatrices() throws CustomException {
	int[][] matrix = { { 0, 0, 3 }, { 0, 0, 0 }, { 4, 0, 0 } };
	sparseMatrix = new SparseMatrix(matrix);
	int[][] matrixToAdd = { { 1, 0, 0 }, { 0, 0, 0 }, { 0, 0, 2 } };
	
	int[][] expected = { { 1, 0, 3 }, { 0, 0, 0 }, { 4, 0, 2 } };
	assertArrayEquals(expected, sparseMatrix.addTwoMatrices(matrixToAdd));
	
   }

    @Test
    public void testMultiplyTwoMatrices() throws CustomException {
	int[][] matrix = { { 0, 0, 3 }, { 0, 0, 0 }, { 4, 0, 0 } };
	sparseMatrix = new SparseMatrix(matrix);
	int[][] matrixToMultiply = { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } };
	
	int[][] expected = { { 0, 0, 3 }, { 0, 0, 0 }, { 4, 0, 0 } };
	assertArrayEquals(expected, sparseMatrix.multipyTwoMatrices(matrixToMultiply));
    }

}
