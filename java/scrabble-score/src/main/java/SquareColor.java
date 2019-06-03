enum SquareColor {
    WHITE(1, 1),
    LIGHT_BLUE(2, 1),
    BLUE(3, 1),
    PINK(1, 2),
    RED(1, 3);

    private final int letterMultiplier;
    private final int wordMultiplier;

    SquareColor(int letterMultiplier, int wordMultiplier) {
        this.letterMultiplier = letterMultiplier;
        this.wordMultiplier = wordMultiplier;
    }

    int getLetterMultiplier() {
        return letterMultiplier;
    }

    int getWordMultiplier() {
        return wordMultiplier;
    }
}