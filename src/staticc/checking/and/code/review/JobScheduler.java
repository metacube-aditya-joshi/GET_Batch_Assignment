package staticc.checking.and.code.review;

import java.util.ArrayList;

import java.util.Scanner;

class JobScheduler {
    ArrayList<Job> inputTime;

    JobScheduler() {
	inputTime = new ArrayList<>();
    }

    void menu(Scanner inputStream) {

	System.out.println("Enter the functionality you want to perform :");
	System.out.println("1. calculate Completion Time");
	System.out.println("2. calculate Waiting Time");
	System.out.println("3. calculate Turn Around Time");
	System.out.println("4. calculate Average Waiting Time");
	System.out.println("5. calculate Max Waiting Time");
	System.out.println("6. exit");

	String choice = inputStream.nextLine();
	functionSelector(choice);

    }

    private void functionSelector(String choice) {
	FirstComeFirstServe scheduler = new FirstComeFirstServe();
	switch (choice) {
	case "1":
	    scheduler.completionTime(inputTime);
	case "2":
	    scheduler.waitingTime(inputTime);
	case "3":
	    scheduler.turnAroundTime(inputTime);
	case "4":
	    scheduler.avgWaitingTime(inputTime);
	case "5":
	    scheduler.maxWaitingTime(inputTime);
	case "6":
	    break;
	default:
	    System.out.println("Invalid Choice!!");
	}

    }

}
