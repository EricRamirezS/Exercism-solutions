class Scrabble {

    private final String word;
    private final int score;
    private final SquareColor[] colors;

    Scrabble(String word, SquareColor... colors) throws IllegalArgumentException {
        this.word = word;
        this.colors = colors;
        checkColors();
        score = setScore();
    }

    private int setScore() {
        int score = 0;
        String lowercaseWord = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            score += getLetterScore(lowercaseWord.charAt(i) + "") * getLetterMultiplier(i);
        }
        score *= getWordMultiplier();

        // score += word.length() >= 7 ? 50 : 0;

        return score;
    }

    int getScore() {
        return score;
    }

    private int getLetterScore(String a) {
        if ("aeioulnrst".contains(a)) return 1;
        if ("dg".contains(a)) return 2;
        if ("bcmp".contains(a)) return 3;
        if ("fhvwy".contains(a)) return 4;
        if ("k".contains(a)) return 5;
        if ("jx".contains(a)) return 8;
        if ("qz".contains(a)) return 10;
        return 0;
    }

    private int getLetterMultiplier(int i) {
        if (colors.length > 0) {
            return colors[i].getLetterMultiplier();
        }
        return 1;
    }

    private int getWordMultiplier() {
        int wordMultiplier = 1;
        for (SquareColor color : colors) {
            wordMultiplier *= color.getWordMultiplier();
        }
        return wordMultiplier;
    }

    private void checkColors() throws IllegalArgumentException {
        if (word.length() != colors.length && colors.length > 0) {
            throw new IllegalArgumentException("There must be one color per character.");
        }
    }


}
