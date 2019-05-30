import java.util.ArrayList;
import java.util.List;

class DiamondPrinter {

    private static final int A_CODE = 65;
    private String whiteSpaces = "";

    List<String> printToList(char maxChar) {
        final int maxWidth = (maxChar - A_CODE) * 2 + 1;
        whiteSpaces = generateWhiteSpacesString(maxWidth);
        return drawDiamond(maxChar, maxWidth);
    }

    private String generateWhiteSpacesString(int length) {
        StringBuilder whiteSpaces = new StringBuilder();
        while (whiteSpaces.length() < length) {
            whiteSpaces.append(" ");
        }
        return whiteSpaces.toString();
    }

    private List<String> drawDiamond(char maxChar, int maxWidth) {
        return drawBottom(drawTop(maxChar, maxWidth));
    }

    private List<String> drawTop(char maxChar, int maxWidth) {
        List<String> diamond = new ArrayList<>();
        for (int i = 0; A_CODE + i <= maxChar; i++) {
            diamond.add(placeCharacter(i, maxWidth));
        }
        return diamond;
    }

    private List<String> drawBottom(List<String> diamond) {
        for (int i = diamond.size() - 2; i > -1; i--) {
            diamond.add(diamond.get(i));
        }
        return diamond;
    }

    private String placeCharacter(int row, int maxWidth) {
        StringBuilder sb = new StringBuilder(whiteSpaces);

        int leftIndex = (maxWidth - 1) / 2 - row;
        int rightIndex = (maxWidth - 1) / 2 + row;
        char currentChar = (char) (A_CODE + row);

        sb.setCharAt(leftIndex, currentChar);
        sb.setCharAt(rightIndex, currentChar);

        return sb.toString();
    }

}
