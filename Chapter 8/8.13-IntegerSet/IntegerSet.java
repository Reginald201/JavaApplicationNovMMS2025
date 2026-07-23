// IntegerSet.java
// Represents a set of integers in the range 0-100, backed by a boolean array.
public class IntegerSet {
    private static final int SET_SIZE = 101; // 0 - 100 inclusive
    private boolean[] set;

    // no-argument constructor: initializes the set to "empty"
    public IntegerSet() {
        set = new boolean[SET_SIZE];
    }

    // static method: set-theoretic union of two sets
    public static IntegerSet union(IntegerSet setA, IntegerSet setB) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i < SET_SIZE; i++) {
            result.set[i] = setA.set[i] || setB.set[i];
        }
        return result;
    }

    // static method: set-theoretic intersection of two sets
    public static IntegerSet intersection(IntegerSet setA, IntegerSet setB) {
        IntegerSet result = new IntegerSet();
        for (int i = 0; i < SET_SIZE; i++) {
            result.set[i] = setA.set[i] && setB.set[i];
        }
        return result;
    }

    // inserts integer k into the set
    public void insertElement(int k) {
        validate(k);
        set[k] = true;
    }

    // deletes integer m from the set
    public void deleteElement(int m) {
        validate(m);
        set[m] = false;
    }

    // returns whether "this" set equals another set
    public boolean isEqualTo(IntegerSet other) {
        for (int i = 0; i < SET_SIZE; i++) {
            if (this.set[i] != other.set[i]) {
                return false;
            }
        }
        return true;
    }

    private void validate(int value) {
        if (value < 0 || value > 100) {
            throw new IllegalArgumentException(
                "value must be in the range 0-100");
        }
    }

    // returns a String containing the set as a list of numbers,
    // or "---" if the set is empty
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean isEmpty = true;

        for (int i = 0; i < SET_SIZE; i++) {
            if (set[i]) {
                sb.append(i).append(" ");
                isEmpty = false;
            }
        }

        return isEmpty ? "---" : sb.toString().trim();
    }
}
