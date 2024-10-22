package specification;

import java.util.Scanner;

class StringFunctions {

    /**
     * a function to check whether two string are equal or not
     * 
     * @param inputStream
     * @return boolean : comparison of two strings ,true :equals ,false : not equal
     */
    boolean strCompare(Scanner inputStream) {
	try {
	    inputStream.nextLine();
	    System.out.println("Enter the String 1 : ");
	    String str1 = inputStream.next();

	    System.out.println("Enter the String 2 : ");
	    String str2 = inputStream.next();

	    if (str1 == null || str2 == null || str1.isBlank() || str2.isBlank()) {
		throw new IllegalArgumentException("Empty String is not allowed");
	    }
	    if (str1.length() != str2.length())
		return false;

	    for (int index = 0; index < str1.length(); index++) {

		if (str1.charAt(index) != str2.charAt(index))
		    return false;
	    }

	    return true;

	} catch (Error e) {
	    throw new Error(e.getMessage());
	}
    }

    /**
     * a function to reverse a given string
     * 
     * @param inputStream
     * @return String : reverse of a string
     */
    String reverseString(Scanner inputStream) {
	try {
	    inputStream.nextLine();

	    System.out.println("Enter the String  : ");
	    String str = inputStream.nextLine();
	    if (str == null || str.isBlank()) {
		throw new IllegalArgumentException("Empty String is not allowed");
	    }
	    StringBuilder reverseStr = new StringBuilder();

	    for (int index = 0; index < str.length(); index++) {

		// reverseStr.append(str.charAt(index));
		reverseStr.insert(0, str.charAt(index));
	    }
	    return reverseStr.toString();

	} catch (Error e) {
	    throw new Error(e.getMessage());
	}
    }

    /**
     * a function to alter the casing of a character in a string
     * 
     * @return String : a reversed casing String
     */
    String reverseCase(Scanner inputStream) {

	try {
	    inputStream.nextLine();

	    System.out.print("Enter the String  : ");
	    String str = inputStream.nextLine();

	    if (str == null || str.isBlank()) {
		inputStream.close();
		throw new IllegalArgumentException("Empty String is not allowed");

	    }

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
	    inputStream.close();
	    return reverseCaseStr.toString();

	} catch (Exception error) {
	    throw new Error(error.getMessage());
	}
    }

    /**
     * a function to find the longest word in the String
     * 
     * @param inputStream
     * @return String : return longest word
     */
    String longestSubstring(Scanner inputStream) {

	try {
	    System.out.println("Enter the String  : ");
	    String str = inputStream.nextLine();

	    int longest = 0;
	    int lastSpace = 0;
	    int idx;
	    StringBuffer longestString = new StringBuffer();
	    int maxLength = 0;

	    for (idx = 0; idx < str.length(); idx++) {

		char character = str.charAt(idx);
		char blankSpace = ' ';
		if (blankSpace == character) {
		    if (idx + lastSpace >= longest) {
			longest = idx - lastSpace;
			maxLength = lastSpace;

		    }
		    lastSpace = idx;
		}

	    }
	    if (lastSpace != idx) {
		if (idx + lastSpace >= longest) {
		    longest = idx - lastSpace;
		    maxLength = lastSpace;

		}
	    }
	    for (int len = maxLength; len <= maxLength + longest; len++) {
		longestString.append(str.charAt(len));
	    }
	    System.out.println(longestString);
	    return longestString.toString();
	} catch (Error e) {
	    throw new Error(e.getMessage());
	}
    }

    /**
     * a function to take dynamic input from displaying certain options
     * 
     * @param inputStream
     */
    void menu(Scanner inputStream) {

	try {
	    System.out.println("Enter the choice : ");
	    System.out.println("1. Compare String ");
	    System.out.println("2. Reverse String ");
	    System.out.println("3. Reverse Casing of String");
	    System.out.println("4. Longest Substring ");
	    System.out.println("5. Exit");
	    int option = inputStream.nextInt();

	    functionSelector(option, inputStream);
	} catch (Error e) {
	    throw new Error(e.getMessage());
	}
    }

    /**
     * function to select the options given by user from menu
     * 
     * @param choice
     * @param inputStream
     */
    private void functionSelector(int choice, Scanner inputStream) {

	try {
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
	} catch (Error e) {
	    throw new Error(e.getMessage());
	}

    }

}
