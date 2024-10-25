package recursion;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
	Scanner inpScanner = new Scanner(System.in);
	try {

	    System.out.println("Enter Options :");
	    System.out.println("1. LCM Of a number ");
	    System.out.println("2. HCF Of a number ");
	    System.out.println("3. Linear Search ");
	    System.out.println("4. Binary Search ");
	    System.out.println("5. N Queen");
	    System.out.println("6. Knight's Tour");
	    System.out.println("7. Exit");

	    String inputString = inpScanner.nextLine();

	    if (inputString == null || inputString.isBlank())
		throw new IllegalArgumentException("Can't handle zero-length arrays.");

	    int option = Integer.parseInt(inputString);
	    boolean repeatMenu = true;

	    while (repeatMenu) {
		if (option == 1) { // option for taking input for LCM

		    String xString = inpScanner.nextLine();
		    if (xString == null || xString.isBlank())
			throw new IllegalArgumentException("Can't handle zero-length arrays.");

		    String yString = inpScanner.nextLine();
		    if (yString == null || yString.isBlank())
			throw new IllegalArgumentException("Can't handle zero-length arrays.");

		    int x = Integer.parseInt(xString);
		    int y = Integer.parseInt(yString);

		    if (x == 0 || y == 0)
			throw new ArithmeticException("Enter Non Zero Numbers !!");

		    System.out.println("LCM :" + new Factors().LCM(x, y));
		    repeatMenu = true;

		} else if (option == 2) { // option for taking input for HCF

		    String xString = inpScanner.nextLine();
		    if (xString == null || xString.isBlank())
			throw new IllegalArgumentException("Can't handle zero-length arrays.");

		    String yString = inpScanner.nextLine();
		    if (yString == null || yString.isBlank())
			throw new IllegalArgumentException("Can't handle zero-length arrays.");

		    int x = Integer.parseInt(xString);
		    int y = Integer.parseInt(yString);

		    if (x == 0 || y == 0)
			throw new ArithmeticException("Enter Non Zero Numbers !!");

		    System.out.println("HCF :" + new Factors().HCF(x, y));
		    repeatMenu = true;
		} else if (option == 3) { // option for taking input for linear search

		    System.out.println("Enter the size of array :");
		    int arrSize = inpScanner.nextInt();
		    if (arrSize == 0)
			throw new IllegalArgumentException("Can't handle zero-length arrays.");

		    int[] inputArrays = new int[arrSize];
		    System.out.println("Enter the Data of array :");
		    for (int idx = 0; idx < arrSize; idx++) {
			inputArrays[idx] = inpScanner.nextInt();
		    }

		    System.out.println("Enter value want to search :");
		    int value = inpScanner.nextInt();
		    if (value < 0)
			throw new IllegalArgumentException("Can't handle negative values.");

		    Search search = new Search();
		    int index = search.linearSearch(inputArrays, value, 0);
		    if (index < 0)
			System.out.println("item not found!!");
		    else
			System.out.println("The index at item is found : " + index);
		    repeatMenu = true;
		} else if (option == 4) { // option for taking input for binary search

		    System.out.println("Enter the size of array :");
		    int arrSize = inpScanner.nextInt();
		    if (arrSize == 0)
			throw new IllegalArgumentException("Can't handle zero-length arrays.");

		    int[] inputArrays = new int[arrSize];
		    System.out.println("Enter the Data of array :");
		    for (int idx = 0; idx < arrSize; idx++) {
			inputArrays[idx] = inpScanner.nextInt();
		    }

		    Arrays.sort(inputArrays);

		    System.out.println("Enter value want to search :");
		    int value = inpScanner.nextInt();
		    if (value < 0)
			throw new IllegalArgumentException("Can't handle negative values.");

		    Search search = new Search();
		    int index = search.binarySearch(inputArrays, value, 0, inputArrays.length - 1);
		    if (index < 0)
			System.out.println("item not found!!");
		    else
			System.out.println("The index at item is found : " + index);
		    repeatMenu = true;
		} else if (option == 5) {
		    String numberOfQueenString = inpScanner.nextLine();
		    if (numberOfQueenString == null || numberOfQueenString.isBlank())
			throw new IllegalArgumentException("Can't handle zero-length arrays.");
		    
		    int numberOfQueen = Integer.parseInt(numberOfQueenString);
		    
		    ChessBoard cb = new ChessBoard(numberOfQueen);
		    cb.solveNQueens();

		} else if (option == 6) {

		} else if (option == 7) {

		} else {

		}
	    }

	} catch (Exception e) {

	    throw new Exception(e.getMessage());

	} finally {
	    inpScanner.close();
	}

    }

}
