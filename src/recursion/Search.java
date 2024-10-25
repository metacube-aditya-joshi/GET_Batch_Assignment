package recursion;

public class Search {

    public int linearSearch(int[] inputArray, int value, int index) throws Exception {
	try {
	    if (inputArray == null)
		throw new NullPointerException("Can't handle null arrays");

	    if (inputArray.length == 0)
		throw new IllegalArgumentException("Can't handle zero-length arrays.");

	    if (inputArray[index] == value)
		return index;

	    if (inputArray.length == index)
		return -1;

	    return linearSearch(inputArray, value, index + 1);

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
    }

    public int binarySearch(int[] inputArray, int value, int high, int low) throws Exception {
	try {
	    if (high >= low) {
		int mid = low + (high - low) / 2;

		if (inputArray[mid] == value)
		    return mid;
		else if (inputArray[mid] > value)
		    return binarySearch(inputArray, value, mid - 1, low);
		else if (inputArray[mid] < value)
		    return binarySearch(inputArray, value, high, mid + 1);

	    }

	    return -1;

	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}

    }

}
