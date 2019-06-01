enum SquareColor {

    WHITE, LIGHT_BLUE, BLUE, PINK, RED;

    static int getMultiplier(SquareColor color, boolean isWord) {
        switch (color) {
            case RED:
                return isWord ? 3 : 1;
            case PINK:
                return isWord ? 2 : 1;
            case BLUE:
                return isWord ? 1: 3;
            case LIGHT_BLUE:
                return isWord ? 1: 2;
            default:
                return 1;
        }
    }
}
