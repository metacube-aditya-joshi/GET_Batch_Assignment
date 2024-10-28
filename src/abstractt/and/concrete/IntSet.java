package abstractt.and.concrete;

import java.util.Arrays;

public final class IntSet {
    private final boolean[] set;

    // Constructor to initialize the set with given elements
    public IntSet(int[] elements) {
	set = new boolean[1001]; // Index 0 is unused
	for (int element : elements) {
	    if (element >= 1 && element <= 1000) {
		set[element] = true;
	    }
	}
    }
 
    // Method to check if x is a member of the set
    public boolean isMember(int x) {
	return (x >= 1 && x <= 1000) && set[x];
    }

    // Method to return the size of the set
    public int size() {
	int count = 0;
	for (boolean b : set) {
	    if (b)
		count++;
	}
	return count;
    }

    // Method to check if s is a subset of the set
    public boolean isSubSet(IntSet s) {
	for (int i = 1; i <= 1000; i++) {
	    if (s.isMember(i) && !this.isMember(i)) {
		return false;
	    }
	}
	return true;
    }

    // Method to return the complement set
    public IntSet getComplement() {
	int[] complementElements = new int[1000 - this.size()];
	int index = 0;
	for (int i = 1; i <= 1000; i++) {
	    if (!this.isMember(i)) {
		complementElements[index++] = i;
	    }
	}
	return new IntSet(complementElements);
    }

    // Method to return the union of this set and another set
    public IntSet union(IntSet s) {
	int[] unionElements = new int[this.size() + s.size()];
	int index = 0;
	for (int i = 1; i <= 1000; i++) {
	    if (this.isMember(i) || s.isMember(i)) {
		unionElements[index++] = i;
	    }
	}
	return new IntSet(Arrays.copyOf(unionElements, index));
    }

    // Method to return the intersection of this set and another set
    public IntSet intersection(IntSet s) {
	int[] intersectionElements = new int[Math.min(this.size(), s.size())];
	int index = 0;
	for (int i = 1; i <= 1000; i++) {
	    if (this.isMember(i) && s.isMember(i)) {
		intersectionElements[index++] = i;
	    }
	}
	return new IntSet(Arrays.copyOf(intersectionElements, index));
    }

    // Method to return the difference of this set and another set
    public IntSet difference(IntSet s) {
	int[] differenceElements = new int[this.size()];
	int index = 0;
	for (int i = 1; i <= 1000; i++) {
	    if (this.isMember(i) && !s.isMember(i)) {
		differenceElements[index++] = i;
	    }
	}
	return new IntSet(Arrays.copyOf(differenceElements, index));
    }

    // Method to return a string representation of the set
    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("{");
	for (int i = 1; i <= 1000; i++) {
	    if (isMember(i)) {
		sb.append(i).append(", ");
	    }
	}
	if (sb.length() > 1) {
	    sb.setLength(sb.length() - 2); // Remove last comma and space
	}
	sb.append("}");
	return sb.toString();
    }

}