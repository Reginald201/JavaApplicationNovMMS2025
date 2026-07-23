// HugeInteger.java
// Stores integers up to 40 digits long as an array of digits, and
// provides parsing, comparison, addition and subtraction.
public class HugeInteger {
    private static final int DIGITS = 40;
    private int[] digits; // digits[0] is the most significant digit

    // no-argument constructor: initializes to 0
    public HugeInteger() {
        digits = new int[DIGITS];
    }

    // constructor: parse a numeric String into the digit array
    public HugeInteger(String number) {
        digits = new int[DIGITS];
        parse(number);
    }

    // parses a String, placing each digit into the digit array,
    // right-justified (least-significant digit at the end)
    public void parse(String number) {
        if (number == null || number.isEmpty() || number.length() > DIGITS) {
            throw new IllegalArgumentException(
                "number must be non-empty and at most " + DIGITS + " digits");
        }

        digits = new int[DIGITS];
        int offset = DIGITS - number.length();

        for (int i = 0; i < number.length(); i++) {
            char c = number.charAt(i);
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException("invalid digit: " + c);
            }
            digits[offset + i] = Character.getNumericValue(c);
        }
    }

    // returns the String representation, with leading zeros suppressed
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        boolean leading = true;

        for (int digit : digits) {
            if (leading && digit == 0) {
                continue;
            }
            leading = false;
            sb.append(digit);
        }

        return leading ? "0" : sb.toString();
    }

    // predicate method: true if the value is zero
    public boolean isZero() {
        for (int digit : digits) {
            if (digit != 0) {
                return false;
            }
        }
        return true;
    }

    // compares this HugeInteger to another; returns negative, 0, or positive
    private int compareMagnitude(HugeInteger other) {
        for (int i = 0; i < DIGITS; i++) {
            if (this.digits[i] != other.digits[i]) {
                return this.digits[i] - other.digits[i];
            }
        }
        return 0;
    }

    public boolean isEqualTo(HugeInteger other) {
        return compareMagnitude(other) == 0;
    }

    public boolean isNotEqualTo(HugeInteger other) {
        return !isEqualTo(other);
    }

    public boolean isGreaterThan(HugeInteger other) {
        return compareMagnitude(other) > 0;
    }

    public boolean isLessThan(HugeInteger other) {
        return compareMagnitude(other) < 0;
    }

    public boolean isGreaterThanOrEqualTo(HugeInteger other) {
        return compareMagnitude(other) >= 0;
    }

    public boolean isLessThanOrEqualTo(HugeInteger other) {
        return compareMagnitude(other) <= 0;
    }

    // adds this HugeInteger and another, returning a new HugeInteger
    public HugeInteger add(HugeInteger other) {
        HugeInteger result = new HugeInteger();
        int carry = 0;

        for (int i = DIGITS - 1; i >= 0; i--) {
            int sum = this.digits[i] + other.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }

        if (carry != 0) {
            throw new ArithmeticException("HugeInteger overflow on add");
        }

        return result;
    }

    // subtracts other from this HugeInteger (assumes this >= other),
    // returning a new HugeInteger
    public HugeInteger subtract(HugeInteger other) {
        if (this.isLessThan(other)) {
            throw new IllegalArgumentException(
                "subtraction would produce a negative HugeInteger");
        }

        HugeInteger result = new HugeInteger();
        int borrow = 0;

        for (int i = DIGITS - 1; i >= 0; i--) {
            int diff = this.digits[i] - other.digits[i] - borrow;
            if (diff < 0) {
                diff += 10;
                borrow = 1;
            } else {
                borrow = 0;
            }
            result.digits[i] = diff;
        }

        return result;
    }
}
