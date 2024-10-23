package specification;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner inputStream = new Scanner(System.in);
	String options = "";
	boolean check = true;
	try {
	    // An Option Menu to take dynamic input from user.
	    while (!"4".equalsIgnoreCase(options)) {
		if (check) {
		    System.out.println("Enter the choice");
		    System.out.println("1. String Functions");
		    System.out.println("2. MarkSheet ");
		    System.out.println("3. Area Calculator");
		    System.out.println("4.  Exit");
		}

		options = inputStream.nextLine();

		if (options.equalsIgnoreCase("1")) {

		    new StringFunctions().menu(inputStream);
		    check = false;
		    break;

		} else if (options.equalsIgnoreCase("2")) {

		    new MarkSheet().menu(inputStream);
		    check = false;
		    break;

		} else if (options.equalsIgnoreCase("3")) {

		    new AreaOfShapes().menu(inputStream);
		    check = false;
		    break;

		} else if (options.equalsIgnoreCase("4")) {

		    check = true;
		    break;

		} else {

		    System.out.println("Enter Valid Options");
		    check = true;
		    break;

		}

	    }
	    inputStream.close();

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}

    }

}
