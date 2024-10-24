package testing.and.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestClass {

    @Test
    public void testLargestMirror() throws Exception {

	ArrayFunctions arrayFunctions = new ArrayFunctions();

	int[][] inputArray = { { 1, 2, 3, 8, 9, 3, 2, 1 }, { 7, 1, 4, 9, 7, 4, 1 }, { 1, 2, 1, 4 },
		{ 1, 4, 5, 3, 5, 4, 1 } };

	int[] outputArray = { 3, 2, 3, 7 };

	for (int i = 0; i < outputArray.length; i++)
	    assertEquals(outputArray[i], arrayFunctions.largestMirror(inputArray[i]));
    }

    @Test
    public void testCountClumps() throws Exception {

	ArrayFunctions arrayFunctions = new ArrayFunctions();

	int[][] inputArray = { { 1, 2, 2, 3, 4, 4 }, { 1, 1, 2, 1, 1 }, { 1, 1, 1, 1, 1 }, };

	int[] outputArray = { 2, 2, 1 };

	for (int i = 0; i < outputArray.length; i++)
	    assertEquals(outputArray[i], arrayFunctions.countClumps(inputArray[i]));
    }

    @Test
    public void testSplitArray() throws Exception {

	ArrayFunctions arrayFunctions = new ArrayFunctions();

	int[][] inputArray = { { 1, 1, 1, 2, 1 }, { 2, 1, 1, 2, 1 }, { 10, 10 } };

	int[] outputArray = { 3, -1, 1 };

	for (int i = 0; i < outputArray.length; i++)
	    assertEquals(outputArray[i], arrayFunctions.splitArray(inputArray[i]));
    }

    @Test
    public void testFixXY() throws Exception {

	ArrayFunctions arrayFunctions = new ArrayFunctions();

	int[][] inputArray = { { 5, 4, 9, 4, 9, 5 }, { 1, 4, 1, 5 }, { 1, 4, 1, 5, 5, 4, 1 } };

	int[][] outputArray = { { 9, 4, 5, 4, 5, 9 }, { 1, 4, 5, 1 }, { 1, 4, 5, 1, 1, 4, 5 } };

	for (int i = 0; i < outputArray.length; i++)
	    assertEquals(outputArray[i], arrayFunctions.fixXY(inputArray[i]));
    }
}
