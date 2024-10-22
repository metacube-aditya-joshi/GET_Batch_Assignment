package specification;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner inputStream = new Scanner(System.in);
	String options = "";
	boolean check = true;
	try {
	    while (!"4".equalsIgnoreCase(options)) {
		if (check) {
		    System.out.println("Enter the choice");
		    System.out.println("1. String Functions");
		    System.out.println("2. MarkSheet ");
		    System.out.println("3. Area Calculator");

		}
		
		options = inputStream.nextLine();
		switch (options) {
		case "1": {
		    new StringFunctions().menu(inputStream);
		    
		    check = false;
		    break;
		}

		case "2": {
		    new MarkSheet().menu(inputStream);
		    check = false;
		    break;
		}
		case "3": {
		    new AreaOfShapes().menu(inputStream);
		    check = false;
		    break;
		}
		default: {

		    System.out.println("Enter Valid Options");
		    check = true;
		    break;
		}

		}

	    }
	    inputStream.close();

	} catch (Exception e) {
	    System.out.println(e.getMessage());
	}

    }

}
