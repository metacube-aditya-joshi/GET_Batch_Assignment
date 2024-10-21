package staticc.checking.and.code.review;

import java.util.Scanner;

class HexCalc {
    private static final int HEX_BASE = 16;
    private static final char[] HEX_CHARS = "0123456789ABCDEF".toCharArray();

    void menu(Scanner inputStream) {

	System.out.println("Enter the functionality you want to perform :");
	System.out.println("1. Addition");
	System.out.println("2. Deletion");
	System.out.println("3. Multiplication");
	System.out.println("4. Division");
	System.out.println("5. Equality");
	System.out.println("6. Check for Greater");
	System.out.println("7. Check for Lesser");
	System.out.println("8. Exit");

	String choice = inputStream.nextLine();

	System.out.print("Enter First String: ");
	String hex1 = inputStream.next();

	System.out.print("Enter Second String: ");
	String hex2 = inputStream.next();

	functionSelector(choice, hex1, hex2);

    }

    private void functionSelector(String choice, String hex1, String hex2) {

	switch (choice) {
	case "1": {
	    System.out.println("Addition of Strings: " + add(hex1, hex2));
	    break;
	}

	case "2": {
	    System.out.println("Subtraction of Strings: " + subtract(hex1, hex2));
	    break;
	}

	case "3": {
	    System.out.println("Multiplication of Strings: " + multiply(hex1, hex2));
	    break;
	}

	case "4": {
	    System.out.println("Division of Strings: " + divide(hex1, hex2));
	    break;
	}

	case "5": {
	    System.out.println("Equality of Strings: " + isEqual(hex1, hex2));
	    break;
	}

	case "6": {
	    System.out.println("Greatest of Strings: " + isGreaterThan(hex1, hex2));
	    break;
	}

	case "7": {
	    System.out.println("Least of Strings: " + isLessThan(hex1, hex2));
	    break;
	}

	case "8":
	    break;

	default: {
	    System.out.println("Invalid Choice!!");
	    break;
	}

	}

    }

    public String add(String hex1, String hex2) {

	int decimal1 = manualHexToDecimal(hex1);
	int decimal2 = manualHexToDecimal(hex2);
	int sum = decimal1 + decimal2;

	return manualDecimalToHex(sum);

    }

    public String subtract(String hex1, String hex2) {

	int decimal1 = manualHexToDecimal(hex1);
	int decimal2 = manualHexToDecimal(hex2);

	return manualDecimalToHex(decimal1 - decimal2);
    }

    public String multiply(String hex1, String hex2) {

	int decimal1 = manualHexToDecimal(hex1);
	int decimal2 = manualHexToDecimal(hex2);

	return manualDecimalToHex(decimal1 * decimal2);
    }

    public String divide(String hex1, String hex2) {

	int decimal1 = manualHexToDecimal(hex1);
	int decimal2 = manualHexToDecimal(hex2);
	if (decimal2 == 0)
	    throw new ArithmeticException("Division by zero is not allowed");

	return manualDecimalToHex(decimal1 - decimal2);
    }

    public boolean isEqual(String hex1, String hex2) {
	return hex1.compareToIgnoreCase(hex2) == 0 ? true : false;
    }

    public boolean isGreaterThan(String hex1, String hex2) {
	return hex1.compareToIgnoreCase(hex2) > 0;
    }

    public boolean isLessThan(String hex1, String hex2) {
	return hex1.compareToIgnoreCase(hex2) < 0;
    }

    private String manualDecimalToHex(int decimal) {
	if (decimal == 0)
	    return "0";

	StringBuilder hexString = new StringBuilder();

	while (decimal > 0) {
	    int remainder = decimal % HEX_BASE;
	    hexString.append(HEX_CHARS[remainder]);
	    decimal /= HEX_BASE;
	}
	return hexString.reverse().toString();
    }

    private int manualHexToDecimal(String hex) {
	// TODO Auto-generated method stub
	hex = hex.toUpperCase();
	int length = hex.length();
	int decimalValue = 0;
	int base = 1;
	for (int i = length - 1; i >= 0; i--) {
	    char hexChar = hex.charAt(i);
	    int hexDigit = hexCharToDecimal(hexChar);
	    decimalValue += hexDigit * base;
	    base *= HEX_BASE;

	}

	return decimalValue;
    }

    private int hexCharToDecimal(char hexChar) {
	if (hexChar >= '0' && hexChar <= '9')
	    return hexChar - '0';
	else if (hexChar >= 'A' && hexChar <= 'F')
	    return hexChar - 'A' + 10;
	else
	    throw new IllegalArgumentException("Invalid hexadecimal character :" + hexChar);
    }

}
