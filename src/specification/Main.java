package specification;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner inputStream = new Scanner(System.in);
	String options = "";
	boolean check = true;

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
		new Area();
		check = false;
		break;
	    }
	    default: {
		check = true;
		System.out.println("Enter Valid Options");
		break;
	    }

	    }

	}

    }

}
