package specification;

import java.util.Scanner;

class StringFunctions {

    boolean strCompare(Scanner inputStream) {

	System.out.println("Enter the String 1 : ");
	String str1 = inputStream.next();

	System.out.println("Enter the String 2 : ");
	String str2 = inputStream.next();

	if (str1.length() != str2.length())
	    return false;

	for (int index = 0; index < str1.length(); index++) {

	    if (str1.charAt(index) != str2.charAt(index))
		return false;
	}

	return true;
    }

    String reverseString(Scanner inputStream) {

	System.out.println("Enter the String  : ");
	String str = inputStream.next();
	StringBuilder reverseStr = new StringBuilder();

	for (int index = 0; index < str.length(); index++) {

	    //reverseStr.append(str.charAt(index));
	    reverseStr.insert(0, str.charAt(index));
	}
	return reverseStr.toString();
    }

    String reverseCase(Scanner inputStream) {

	System.out.println("Enter the String  : ");
	String str = inputStream.next();

	StringBuilder reverseCaseStr = new StringBuilder();
	for (int idx = 0; idx < str.length(); idx++) {

	    char character = str.charAt(idx);
	    if (character >= 'a' && character <= 'z') {

		int asciiCode = character - 'a' + 65;
		char newCharacter = (char) asciiCode;
		reverseCaseStr.append(newCharacter);

	    } else if (character >= 'A' && character <= 'Z') {

		int asciiCode = character - 'A' + 97;
		char newCharacter = (char) asciiCode;
		reverseCaseStr.append(newCharacter);

	    } else {

		reverseCaseStr.append(character);
	    }
	}

	return reverseCaseStr.toString();
    }

    String longestSubstring(Scanner inputStream) {

	System.out.println("Enter the String  : ");
	String str = inputStream.next();

	int longest = 0;
	int lastSpace = 0;
	String longestString = "";

	for (int idx = 0; idx < str.length(); idx++) {
	    char character = str.charAt(idx);
	    char blankSpace = ' ';
	    if (blankSpace == character) {
		int lengthOfSubstring = idx - lastSpace;
		lastSpace = idx;

	    }
	}
	return longestString;
    }

    void menu(Scanner inputStream) {

	System.out.println("Enter the choice : ");
	System.out.println("1. Compare String ");
	System.out.println("2. Reverse String ");
	System.out.println("3. Reverse Casing of String");
	System.out.println("4. Longest Substring ");
	System.out.println("5. Exit");
	int option = inputStream.nextInt();

	functionSelector(option, inputStream);
    }

    private void functionSelector(int choice, Scanner inputStream) {

	switch (choice) {
	case 1: {
	    System.out.println(strCompare(inputStream));
	    break;
	}
	case 2: {
	    System.out.println(reverseString(inputStream));
	    break;
	}
	case 3: {
	    System.out.println(reverseCase(inputStream));
	    break;
	}
	case 4: {
	    System.out.println(longestSubstring(inputStream));
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

    }

}
