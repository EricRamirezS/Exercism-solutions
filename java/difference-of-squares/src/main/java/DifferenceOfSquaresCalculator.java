class DifferenceOfSquaresCalculator {

    int computeSquareOfSumTo(int n) {
        return (int) Math.pow(n * (n + 1) / 2, 2);
    }

    int computeSumOfSquaresTo(int n) {
        return n * (n + 1) * (2 * n + 1) / 6;
    }

    int computeDifferenceOfSquares(int input) {
        return Math.abs(computeSquareOfSumTo(input) - computeSumOfSquaresTo(input));
    }

}
