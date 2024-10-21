package staticc.checking.and.code.review;

import java.util.ArrayList;

import java.util.Scanner;

class JobScheduler {
    ArrayList<Job> inputTime;

    JobScheduler() {
	inputTime = new ArrayList<>();
    }

    void menu(Scanner inputStream) {

	processCreation(inputStream);
	for (Job j : inputTime)
	    System.out.println(j.arrivalTime + " " + j.burstTime);

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
	case "1": {
	    scheduler.completionTime(inputTime);
	    break;
	}
	case "2": {
	    scheduler.waitingTime(inputTime);
	    break;
	}
	case "3": {
	    scheduler.turnAroundTime(inputTime);
	    break;
	}
	case "4": {
	    scheduler.avgWaitingTime(inputTime);
	    break;
	}
	case "5": {
	    scheduler.maxWaitingTime(inputTime);
	    break;
	}
	case "6":
	    break;
	default: {
	    System.out.println("Invalid Choice!!");
	    break;
	}
	}

    }

    private void processCreation(Scanner inputStream) {

	System.out.println("Enter the arrival time and burst time for process :");
	boolean isDone = false;

	while (!isDone) {
	    int arrivalTime = inputStream.nextInt();
	    int burstTime = inputStream.nextInt();
	    Job newJob = new Job(arrivalTime, burstTime);
	    inputTime.add(newJob);

	    System.out.print("want to add more jobs => yes or no : ");
	    String opt = inputStream.next();
	    if (!opt.equals("yes"))
		return;

	}
    }

}
