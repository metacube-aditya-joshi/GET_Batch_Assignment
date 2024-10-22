package staticc.checking.and.code.review;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// TODO Auto-generated method stub
	Scanner inputStream = new Scanner(System.in);
	String options = "";
	boolean check = true;

	while (!"3".equalsIgnoreCase(options)) {
	    if (check) {
		System.out.println("Enter the choice");
		System.out.println("1. HexCalc");
		System.out.println("2. JobScheduler ");
		System.out.println("3. exit");

	    }
	    options = inputStream.nextLine();

	    if(options.equals("1"))
	    {
		new HexCalc().menu(inputStream);
		check = false;

	    }else if(options.equals("2")) {
		new JobScheduler().menu(inputStream);
		check = false;
	    }
	    else if(options.equals("3")) {
		break;
		
	    }else {
		check = true;
		System.out.println("Enter Valid Options (menu)");
	    }

	}

    }

}
