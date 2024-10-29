package abstractt.and.concrete;

import java.util.Scanner;

class Main {
	public static void main(String[] args) throws Exception {

	try (Scanner inputScanner = new Scanner(System.in)) {
	    String optionString = inputScanner.next();
	    if (optionString == null || optionString.isEmpty())
		throw new Exception();

	    boolean repeatMenu = true;
	    while (repeatMenu) {
		menu();
		int userInput = inputScanner.nextInt();
		if (userInput == 1) {

		} else if (userInput == 2) {

		} else if (userInput == 3) {
		    System.out.println("Exiting!!");
		    break;
		} else {
		    repeatMenu = true;
		    System.out.println("Enter Correct Option!!");
		}
	    }

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
    }

    static void intSetInput() {

    }

    static void intSetMenu() {
	System.out.println("Choose an option:");
	System.out.println("1. Check Membership");
	System.out.println("2. Get Size of Set");
	System.out.println("3. Display Set");
	System.out.println("4. Check Subset");
	System.out.println("5. Union with another set");
	System.out.println("6. Intersection with another set");
	System.out.println("7. Exit");
    }

    static void polyMenu() {
	System.out.println("Operations ");
	System.out.println("1. Evaluate");
	System.out.println("2. Get Degree");
	System.out.println("3. Add Polynomials");
	System.out.println("4. Multiply Polynomials");
	System.out.println("3. Exit");
	System.out.println("Enter the operation you want to perform :");
    }

    void intSetInput(Scanner inputScanner) throws Exception {
	try {
	    IntSet intSet = createIntSet(inputScanner); // Create the initial IntSet

	    while (true) {

		intSetMenu();

		int choice = inputScanner.nextInt();

		if (choice == 1) {
		    System.out.println("Enter number to check membership:");
		    int number = inputScanner.nextInt();
		    System.out.println("Is " + number + " a member? " + intSet.isMember(number));

		} else if (choice == 2) {
		    System.out.println("Size of the set: " + intSet.size());

		} else if (choice == 3) {
		    System.out.println("Current Set: " + intSet);

		} else if (choice == 4) {
		    System.out.println("Enter another set:");
		    IntSet otherSet = createIntSet(inputScanner);
		    System.out.println("Is the other set a subset? " + intSet.isSubSet(otherSet));

		} else if (choice == 5) {
		    System.out.println("Enter another set for union:");
		    IntSet otherSet = createIntSet(inputScanner);
		    IntSet unionSet = intSet.union(otherSet);
		    System.out.println("Union Set: " + unionSet);

		} else if (choice == 6) {
		    System.out.println("Enter another set for intersection:");
		    IntSet otherSet = createIntSet(inputScanner);
		    IntSet intersectionSet = intSet.intersection(otherSet);
		    System.out.println("Intersection Set: " + intersectionSet);

		} else if (choice == 7) {
		    System.out.println("Exiting");
		    break;

		} else {
		    System.out.println("Choose a correct choice!!");
		}
	    }
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
    }

    public static IntSet createIntSet(Scanner inputScanner) throws Exception {
	int[] elements = null;
	try {
	    System.out.println("Enter the number of elements in the set:");
	    int n = inputScanner.nextInt();
	    elements = new int[n];

	    System.out.println("Enter the elements (between 1 and 1000):");
	    for (int i = 0; i < n; i++) {
		elements[i] = inputScanner.nextInt();
	    }
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}

	return new IntSet(elements);
    }

    static void polyInput(Scanner inputScanner) throws Exception {

	Poly newPoly = createPoly(inputScanner);

	polyMenu();
	int polyChoice = inputScanner.nextInt();

	if (polyChoice == 1) {

	    System.out.println("Enter Number to evaluate :");
	    float numberForEval = inputScanner.nextFloat();
	    System.out.println("Evaluated solution : " + newPoly.evalautePloy(numberForEval));

	} else if (polyChoice == 2) {

	    System.out.println("Degree of Polynomail : " + newPoly.degreePoly());

	} else if (polyChoice == 3) {

	    Poly poly = createPoly(inputScanner);
	    newPoly.addPoly(poly);

	} else if (polyChoice == 4) {
	    Poly poly = createPoly(inputScanner);
	    newPoly.multiplyPoly(poly);
	} else if (polyChoice == 5) {
	    System.out.println("Exiting");

	} else {
	    System.out.println("choose correct choice!!");

	}

    }

    private static Poly createPoly(Scanner inputScanner) throws Exception {
	int[] polyTerms = null;
	try {
	    System.out.println("Enter the number of terms :");
	    int noOfTerms = inputScanner.nextInt();

	    System.out.println("Enter the Maximum Degree of polynomial :");
	    int maxDegree = inputScanner.nextInt();
	    polyTerms = new int[maxDegree + 1];

	    for (int terms = 0; terms < noOfTerms; terms++) {
		System.out.println("Enter the degree of term :");
		int userDegree = inputScanner.nextInt();
		if (userDegree < 0 || userDegree > maxDegree) {
		    System.out.println("Degree out of bounds. Please enter a degree between 0 and " + maxDegree);
		    terms--;
		    continue;
		}
		System.out.println("Enter the coefficient of the term :");
		int coefficient = inputScanner.nextInt();
		int currentCoefficient = polyTerms[userDegree] + coefficient;

	    }

	    if (polyTerms == null)
		throw new Exception();

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
	return new Poly(polyTerms);

    }

    static void menu() {
	System.out.println("Enter Choice :");
	System.out.println("1. Int Set Operations");
	System.out.println("2. PolyNomial Operations");
	System.out.println("3. Exit");
    }
}
