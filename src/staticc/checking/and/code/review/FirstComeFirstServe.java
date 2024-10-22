package staticc.checking.and.code.review;

import java.util.ArrayList;

class FirstComeFirstServe {

    void completionTime(ArrayList<Job> inputTime) {
	for (int index = 0; index < inputTime.size(); index++) {
	    int completionTime = inputTime.get(index).getCompletionTime();
	    if ( index==0 ||inputTime.get(index).arrivalTime == 0)
		inputTime.get(index).completionTime = inputTime.get(index).getBurstTime();
	    else {

		    int burstTime = inputTime.get(index).getBurstTime();
		    completionTime = inputTime.get(index - 1).getCompletionTime() + burstTime;
		    inputTime.get(index).setCompletionTime(completionTime);
	    }
	}
	for (Job job : inputTime) {
	    System.out.println("Job Completion time :" + job.completionTime);
	}

    }

    void waitingTime(ArrayList<Job> inputTime) {
	for (int index = 0; index < inputTime.size(); index++) {
	    int waitingTime = inputTime.get(index).getWaitingTime();
	    int burstTime = inputTime.get(index).getBurstTime();
	    int prevWaitingTime=0;
	    if (index == 0)
		inputTime.get(index).setWaitingTime(0);
	    else {
		prevWaitingTime = inputTime.get(index - 1).getWaitingTime();
		waitingTime = Math.abs(prevWaitingTime - burstTime);
	    }

	    
	    inputTime.get(index).setWaitingTime(waitingTime);
	}
	for (Job job : inputTime) {
	    System.out.println("Job Waiting time :" + job.waitingTime);
	}

    }

    void turnAroundTime(ArrayList<Job> inputTime) {
	 completionTime(inputTime);
	for (int index = 0; index < inputTime.size(); index++) {
	    int turnAroundTime = inputTime.get(index).getTurnAroundTime();
	    int completionTime = inputTime.get(index).getCompletionTime();
	    int arrivalTime = inputTime.get(index).getArrivalTime();
	    turnAroundTime = completionTime - arrivalTime;
	    inputTime.get(index).setTurnAroundTime(turnAroundTime);
	}
	for (Job job : inputTime) {
	    System.out.println("Job Turn Around Time :" + job.turnAroundTime);
	}
    }

    void avgWaitingTime(ArrayList<Job> inputTime) {
	int totalNumberOfProcess = inputTime.size();
	int totalWaitingTime = 0;
	for (int index = 0; index < inputTime.size(); index++) {
	    int waitingTime = inputTime.get(index).getWaitingTime();
	    totalWaitingTime += waitingTime;
	}

	System.out.println(
		"Average Waiting Time for the processes : " + (double) totalWaitingTime / totalNumberOfProcess);

    }

    void maxWaitingTime(ArrayList<Job> inputTime) {
	int maxWaitingTime = 0;
	for (int index = 0; index < inputTime.size(); index++) {
	    int waitingTime = inputTime.get(index).getWaitingTime();
	    maxWaitingTime = Math.max(maxWaitingTime, waitingTime);
	}

	System.out.println("Maximum Waiting Time  : " + maxWaitingTime);
    }

}
