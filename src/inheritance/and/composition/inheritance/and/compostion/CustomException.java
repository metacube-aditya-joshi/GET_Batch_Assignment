package inheritance.and.compostion;


@SuppressWarnings("serial")
class CustomException extends Exception {
    public CustomException(String s) {
	// Call constructor of parent Exception
	super(s);
    }
}

