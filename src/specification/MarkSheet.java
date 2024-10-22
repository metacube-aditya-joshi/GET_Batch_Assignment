package specification;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

class MarkSheet {

    ArrayList<Student> students;

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

    int minimumGrades(ArrayList<Student> students) {
	try {

	} catch (Error e) {
	    throw new Error(e.getMessage());
	}
	if (students.size() == 0)
	    throw new ArithmeticException("No Students are there to calculate minimum grades !!");

	int minGrade = 0;
	for (Student s : students) {
	    minGrade = Math.min(minGrade, s.getGrades());
	}
	return minGrade;
    }

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
	    percentage = passedStudents / students.size();

	    return percentage;
	} catch (Error e) {
	    throw new Error(e.getMessage());
	}

    }

    void menu(Scanner inputStream) {
	try {
	    System.out.println("Enter the number of Students : ");
	    int numberOfStudents = inputStream.nextInt();

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
	    System.out.println("2. Maimum of Grades ");
	    System.out.println("3. Minmum of Grades ");
	    System.out.println("4. Percentage of Students Passed ");
	    System.out.println("5. Exit");
	    int option = inputStream.nextInt();

	    functionSelector(option);

	} catch (Error e) {
	    throw new Error(e.getMessage());
	}

    }

    private void functionSelector(int choice) {
	try {
	    Formatter fm = new Formatter();

	    switch (choice) {
	    case 1: {
		// Format 4 decimal places
		fm.format("%.2f", averageGrades(students));
		System.out.print("Average Grafe : " + fm);
		break;
	    }
	    case 2: {
		System.out.print(maximumGrades(students));
		break;
	    }
	    case 3: {
		System.out.print(minimumGrades(students));
		break;
	    }
	    case 4: {
		fm.format("%.2f", percentStudents(students));
		System.out.print("Average Grafe : " + fm);
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
