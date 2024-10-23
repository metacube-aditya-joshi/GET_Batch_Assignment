package specification;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

class MarkSheet {

    ArrayList<Student> students; // To store all students' data

    /**
     * {@summary : takes all the grade of student , sum it up and returns average}
     * 
     * @param : Take ArrayList of Students
     * @return : the average grades of students
     */
    double averageGrades(ArrayList<Student> students) {
	try {

	    if (students.size() == 0)
		throw new ArithmeticException("No Students are there to calculate average grades !!");

	    double average = 0;
	    long totalMarks = 0;
	    for (Student s : students) {
		totalMarks += s.getGrades();
	    }
	    average = totalMarks / students.size();

	    return average;
	} catch (Error e) {
	    throw new Error(e.getMessage());
	}
    }

    /**
     * {@summary : takes all the grade of student , returns maximum grade}
     * 
     * @param {List}: Take ArrayList of Students
     * @return {int} : the Maximum grade among students
     */
    int maximumGrades(ArrayList<Student> students) {
	try {
	    if (students.size() == 0)
		throw new ArithmeticException("No Students are there to calculate maximum grades !!");

	    int maxGrade = 0;
	    for (Student s : students) {
		maxGrade = Math.max(maxGrade, s.getGrades());
	    }
	    return maxGrade;
	} catch (Error e) {
	    throw new Error(e.getMessage());
	}

    }

    /**
     * {@summary : takes all the grade of student , returns minimum grade}
     * 
     * @param : Take ArrayList of Students
     * @return : the minimum grade among students
     */
    int minimumGrades(ArrayList<Student> students) {
	try {
	    if (students.size() == 0)
		throw new ArithmeticException("No Students are there to calculate minimum grades !!");

	    int minGrade = 101;
	    for (Student s : students) {
		minGrade = Math.min(minGrade, s.getGrades());
	    }
	    return minGrade;
	} catch (Error e) {
	    throw new Error(e.getMessage());
	}

    }

    /**
     * {@summary : takes all the grade of student , returns the percentage of
     * students passed}
     * 
     * @param : Take ArrayList of Students
     * @return : double the percentage of students passed
     */
    // have to do some modifitcations
    double percentStudents(ArrayList<Student> students) {
	try {
	    if (students.size() == 0)
		throw new ArithmeticException("No Students are there to calculate precentage of Students passed !!");

	    double percentage = 0;
	    int passedStudents = 0;
	    for (Student s : students) {
		if (s.getGrades() >= 40)
		    passedStudents++;
	    }

	    percentage = (passedStudents * 100) / students.size();
	    ;

	    return percentage;
	} catch (Error e) {
	    throw new Error(e.getMessage());
	}

    }

    /**
     * a function to take dynamic input from displaying certain options
     * 
     * @param inputStream
     * @return
     */
    void menu(Scanner inputStream) {
	try {
	    System.out.println("Enter the number of Students : ");
	    String inputStudents = inputStream.nextLine();
	    if (inputStudents == null) {
		throw new IllegalArgumentException("Enter valid number !!");
	    }
	    int numberOfStudents = Integer.parseInt(inputStudents);
	    if (numberOfStudents == 0) {
		throw new IllegalArgumentException("Enter valid number !!");
	    }

	    students = new ArrayList<>(numberOfStudents);

	    System.out.println("Enter the marks of Students : ");

	    for (int number = 0; number < numberOfStudents; number++) {

		int grade = inputStream.nextInt();
		Student newStudent = new Student();
		newStudent.setGrades(grade);
		students.add(newStudent);

	    }

	    System.out.println("Enter the choice : ");
	    System.out.println("1. Average of Grades ");
	    System.out.println("2. Maximum of Grades ");
	    System.out.println("3. Minimum of Grades ");
	    System.out.println("4. Percentage of Students Passed ");
	    System.out.println("5. Exit");
	    int option = inputStream.nextInt();

	    functionSelector(option);

	} catch (Error e) {
	    throw new Error(e.getMessage());
	}

    }

    /**
     * function to select the options given by user from menu
     * 
     * @param choice
     */
    private void functionSelector(int choice) {
	try {
	    Formatter fm = new Formatter();

	    switch (choice) {
	    case 1: {
		// Format 4 decimal places
		fm.format("%.2f", averageGrades(students));
		System.out.println("Average Grade : " + fm);
		break;
	    }
	    case 2: {
		System.out.println("Maximum Grade: " + maximumGrades(students));
		break;
	    }
	    case 3: {
		System.out.println("Minimum Grade: " + minimumGrades(students));
		break;
	    }
	    case 4: {
		fm.format("%.2f", percentStudents(students));
		System.out.println("Percentage of Student Passed : " + fm);
		break;
	    }
	    case 5: {
		break;
	    }

	    default: {
		System.out.println("Invalid Choice!!");
		break;
	    }
	    }
	    fm.close();

	} catch (Error e) {
	    throw new Error(e.getMessage());
	}

    }
}
