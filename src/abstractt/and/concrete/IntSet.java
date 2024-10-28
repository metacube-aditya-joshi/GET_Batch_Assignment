package abstractt.and.concrete;

import java.util.Arrays;

public final class IntSet {
    private final boolean[] set;

    /**
     * Constructs an IntSet from an array of integers.
     * 
     * @param elements an array of integers to initialize the set. Only integers
     *                 in the range [1, 1000] will be included in the set.
     * @throws IllegalArgumentException if the elements array is null or contains
     *                                  integers outside the range [1, 1000].
     */
    public IntSet(int[] elements) {
        set = new boolean[1001]; // Index 0 is unused
        for (int element : elements) {
            if (element >= 1 && element <= 1000) {
                set[element] = true;
            }
        }
    }

    /**
     * Checks if a given integer is a member of the set.
     * 
     * @param x the integer to check for membership.
     * @return true if x is a member of the set; false otherwise.
     */
    public boolean isMember(int x) {
        return (x >= 1 && x <= 1000) && set[x];
    }

    /**
     * Returns the number of elements in the set.
     * 
     * @return the size of the set.
     */
    public int size() {
        int count = 0;
        for (boolean b : set) {
            if (b)
                count++;
        }
        return count;
    }

    /**
     * Checks if the specified IntSet is a subset of this set.
     * 
     * @param s the IntSet to check if it is a subset.
     * @return true if s is a subset of this set; false otherwise.
     */
    public boolean isSubSet(IntSet s) {
        for (int i = 1; i <= 1000; i++) {
            if (s.isMember(i) && !this.isMember(i)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns the complement of this set.
     * 
     * @return a new IntSet representing the complement of this set,
     *         containing all integers in the range [1, 1000] that are not
     *         in this set.
     */
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

    /**
     * Returns the union of this set and another set.
     * 
     * @param s the IntSet to perform the union with.
     * @return a new IntSet containing the union of this set and the specified set.
     */
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

    /**
     * Returns the intersection of this set and another set.
     * 
     * @param s the IntSet to perform the intersection with.
     * @return a new IntSet containing the intersection of this set and the
     *         specified set.
     */
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

    /**
     * Returns the difference of this set and another set.
     * 
     * @param s the IntSet to perform the difference with.
     * @return a new IntSet containing the elements that are in this set but not in
     *         the specified set.
     */
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

    /**
     * Returns a string representation of the set.
     * 
     * @return a string in the format "{element1, element2, ...}" representing the
     *         contents of the set.
     */
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