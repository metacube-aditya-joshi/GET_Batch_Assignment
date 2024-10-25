package recursion;

public class Factors {

    public int LCM(int x, int y) throws Exception {
	try {
	    return (x * y) / HCF(x, y);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
    }

    public int HCF(int x, int y) throws Exception {

	try {
	    if (x == 0)
		return y;

	    if (y == 0)
		return x;
	    if (x > y)
		HCF(x % y, y);

	    return HCF(y % x, x);
	} catch (Exception e) {
	    throw new Exception(e.getMessage());
	}
    }

}
