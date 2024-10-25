package testing.and.junit;

import java.util.ArrayList;

import java.util.Scanner;

public class ArrayFunctions {

    /**
     * function takes and integer array and calculates the largest mirror present in
     * the array
     * 
     * @return {int} : largest Mirror length in array
     * @throws Exception
     */
    public int largestMirror(int[] inputArray) throws Exception {
	try {
	    // userInput();
	    int largestMirrorArray = 0;

	    if (inputArray.length == 0)
		throw new ArrayIndexOutOfBoundsException();

	    for (int index = 0; index < inputArray.length; index++) {
		int counter = 0;
		for (int j = inputArray.length - 1; index >= 0; index--) {
		    if (inputArray[index + counter] == inputArray[j]) {
			counter++;
		    } else {
			largestMirrorArray = Math.max(largestMirrorArray, counter);
			counter = 0;
		    }
		}

		largestMirrorArray = Math.max(largestMirrorArray, counter);
	    }

	    return largestMirrorArray;
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}

    }

    /**
     * function return count of clumps present in array given by the user
     * 
     * @return {int} : count of clumps in array
     * @throws Exception
     * 
     */
    public int countClumps(int[] inputArray) throws Exception {
	try {
	    // userInput();
	    if (inputArray.length == 0)
		throw new ArrayIndexOutOfBoundsException();

	    ArrayList<Integer> clupmsCountArrayList = new ArrayList<Integer>();

	    for (int index = 1; index < inputArray.length; index++) {

		if (inputArray[index] == inputArray[index - 1]) {
		    if (!clupmsCountArrayList.contains(inputArray[index]))
			clupmsCountArrayList.add(inputArray[index]);
		}
	    }
	    return clupmsCountArrayList.size();

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
    }

    /**
     * function returns the index at which sum of both halves is equal
     * 
     * @return {int} : return index
     * @throws Exception
     */
    public int splitArray(int[] inputArray) throws Exception {
	try {
	    // userInput();
	    if (inputArray.length == 0)
		throw new ArrayIndexOutOfBoundsException();

	    int sum = 0;
	    for (int index = 0; index < inputArray.length; index++) {
		sum += inputArray[index];
	    }

	    if (sum % 2 != 0)
		return -1;

	    int currentSum = 0;
	    for (int index = 0; index < inputArray.length; index++) {
		if (currentSum == (sum / 2))
		    return index + 1;
	    }
	    return -1;

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
    }

    /**
     * 
     * @throws Exception
     */
    public int[] fixXY(int[] inputArray) throws Exception {
	try {
	    // userInput();
	    Scanner input = new Scanner(System.in);
	    String xString = input.nextLine();
	    String yString = input.nextLine();

	    if (xString == null || yString == null || xString.isBlank() || yString.isBlank()) {
		input.close();
		throw new IllegalArgumentException("Invalid Input!!");
	    }

	    int x = Integer.parseInt(xString);
	    int y = Integer.parseInt(yString);

	    if (x == 0 || y == 0) {
		input.close();
		throw new IllegalArgumentException("Invalid Input!!");
	    }

	    int xcount = 0;
	    int ycount = 0;
	    for (int index = 0; index < inputArray.length; index++) {
		if (inputArray[index] == x) {
		    xcount++;
		} else if (inputArray[index] == y) {
		    ycount++;
		}
	    }

	    if (xcount == 0 || ycount == 0 || xcount != ycount) {
		input.close();
		throw new IllegalArgumentException("Check count of X and Y as these are invalid!!");
	    }

	    input.close();
	    return inputArray;

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
    }

}
