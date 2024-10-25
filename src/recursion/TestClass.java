package recursion;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    void testLCM() throws Exception {
	int[] xArray = { 2, 3, 4, 5, 6, 7, 8 };
	int[] yArray = { 2, 3, 4, 12, 5, 14, 10 };
	int[] lcmOutput = { 2, 3, 4, 60, 30, 14, 40 };

	Factors factors = new Factors();

	for (int i = 0; i < xArray.length; i++) {
	    assertEquals(lcmOutput[i], factors.LCM(xArray[i], yArray[i]));
	}
    }

    @Test
    void testHCF() throws Exception {
	int[] xArray = { 2, 3, 4, 5, 6, 7, 8 };
	int[] yArray = { 2, 3, 4, 12, 5, 14, 10 };

	int[] hcfOutput = { 2, 3, 4, 1, 1, 7, 2 };

	Factors factors = new Factors();

	for (int i = 0; i < xArray.length; i++) {
	    assertEquals(hcfOutput[i], factors.HCF(xArray[i], yArray[i]));
	}
    }

    @Test
    void testLinearSearch() throws Exception {
	int[][] inputArray = { { 1, 4, 2, 3, 8, 9, 10 }, { 1, 2, 5, 6, 8, 45 }, { 8, 1, 10, 15, 16, 18 }, };
	int[] value = { 3, 2, 1 };
	int[] outputArray = { 3, 2, 1 };

	Search search = new Search();

	for (int i = 0; i < outputArray.length; i++) {
	    assertEquals(outputArray[i], search.linearSearch(inputArray[i], value[i], 0));
	}
    }

    @Test
    void testBinarySearch() throws Exception {
	int[] inputArray = { 34, 7, 23, 32, 5, 62, 32, 1, 78, 45 };
	int[] value = { 32, 5, 100, 1, 45 };
	int[] outputArray = { 3, 4, 7, 9 };

	Search search = new Search();

	for (int i = 0; i < outputArray.length; i++) {
	    assertEquals(outputArray[i], search.binarySearch(inputArray, value[i], 0, inputArray.length - 1));
	}
    }

    @Test
    public void nQueensTest() {
	final int BOARD_SIZE = 4;

	ChessBoard board = new ChessBoard(BOARD_SIZE);
	board.solveNQueens();

	assertArrayEquals(new int[][] { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 1 }, { 0, 1, 0, 0 } },
		board.getBoard());

	assertEquals(false, new ChessBoard(2).solveNQueens());

    }
}
