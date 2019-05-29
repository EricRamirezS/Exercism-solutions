import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Hamming {

    private final String leftStrand;
    private final String rightStrand;
    private final int hammingDistance;

    Hamming(String leftStrand, String rightStrand) throws IllegalArgumentException {
        validateInputs(leftStrand, rightStrand);
        this.leftStrand = leftStrand;
        this.rightStrand = rightStrand;
        this.hammingDistance = calculateHammingDistance();
    }

    String getLeftStrand() {
        return leftStrand;
    }

    String getRightStrand() {
        return rightStrand;
    }

    int getHammingDistance() {
        return hammingDistance;
    }

    private int calculateHammingDistance() {
        int hammingDistance = 0;
        for (int i = 0; i < leftStrand.length(); i++) {
            hammingDistance += leftStrand.charAt(i) == rightStrand.charAt(i) ? 0 : 1;
        }
        return hammingDistance;
    }

    private boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    private void validateInputs(String left, String right) throws IllegalArgumentException {
        if (isNullOrEmpty(left) ^ isNullOrEmpty(right)) {
            if (isNullOrEmpty(left)) {
                throw new IllegalArgumentException("left strand must not be empty.");
            }
            if (isNullOrEmpty(right)) {
                throw new IllegalArgumentException("right strand must not be empty.");
            }
        }
        if (left.length() != right.length()) {
            throw new IllegalArgumentException("leftStrand and rightStrand must be of equal length.");
        }
    }


}
