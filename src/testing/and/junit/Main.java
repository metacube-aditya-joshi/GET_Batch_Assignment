package testing.and.junit;

import java.util.Scanner;
import testing.and.junit.ArrayFunctions;
class Main {

    public static void main(String[] args) throws Exception {
	System.out.println("hhhh");
	Scanner inputStreamScanner = new Scanner(System.in);
	try {
	    
	    System.out.println("Enter the option from the menu :");

	    boolean repeatMenu = true;

	    while (repeatMenu) {

		System.out.println();
		System.out.println("1. Mirror Array");
		System.out.println("2. Clumps Array");
		System.out.println("3. Find XY");
		System.out.println("4. Split Array");
		System.out.println("5. Exit");

		int optionString = inputStreamScanner.nextInt();

//		if (optionString == null || optionString.isEmpty()) {
//		    inputStreamScanner.close();
//		    throw new ArrayIndexOutOfBoundsException("Enter Valid Option");
//
//		}

		// ArrayList<Integer> tempArrayList = new ArrayList<Integer>();
//		System.out.println("Enter Size of the Array : ");
//		String sizeOfArrString = inputStreamScanner.nextLine();
//
//		if (sizeOfArrString == null || sizeOfArrString.isBlank()) {
//		    inputStreamScanner.close();
//		    throw new IllegalArgumentException("Enter valid size of array!!");
//		}
//
//		int arraySize = Integer.parseInt(sizeOfArrString);
//		System.out.println(arraySize);
//		if (arraySize == 0) {
//
//		    throw new IllegalArgumentException("Enter valid size of array!!");
//		}

//		boolean choice = true;
//		while (choice) {
//		    System.out.println("Enter Data in array : ");
//		    tempArrayList.add(inputStreamScanner.nextInt());
//		    System.out.println("want to add more data : `yes` or `no` :");
//		    {
//			String choiceString = inputStreamScanner.next();
//			choice = choiceString.equals("yes") ? true : false;
//		    }
//		}

		// int[] inputArray = tempArrayList.stream().mapToInt(i -> i).toArray();

		int[] inputArray = { 1, 2, 3, 8, 9, 3, 2, 1 };
		ArrayFunctions arrayFunctions = new ArrayFunctions();

		if (optionString == 1) {

		    System.out.println("Largest Mirror Array :" + arrayFunctions.largestMirror(inputArray));
		    break;

		} else if (optionString == 2) {

		    System.out.println("Clump Array :" + arrayFunctions.countClumps(inputArray));
		    break;

		} else if (optionString == 3) {

		    System.out.println("XY Array :" + arrayFunctions.fixXY(inputArray));
		    break;
		} else if (optionString == 4) {

		    System.out.println("Split Array :" + arrayFunctions.splitArray(inputArray));
		    break;

		} else if (optionString == 5) {

		    break;

		} else {
		    System.out.println("Enter Valid Options!!");
		}

	    }

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	} finally {
	    inputStreamScanner.close();
	}
    }

}
