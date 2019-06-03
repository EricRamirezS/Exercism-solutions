import org.junit.Ignore;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class ScrabbleScoreTest {

    @Ignore("Remove to run test")
    @Test
    public void testALowerCaseLetter() {
        Scrabble scrabble = new Scrabble("a");
        assertEquals(1, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAUpperCaseLetter() {
        Scrabble scrabble = new Scrabble("A");
        assertEquals(1, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAValuableLetter() {
        Scrabble scrabble = new Scrabble("f");
        assertEquals(4, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAShortWord() {
        Scrabble scrabble = new Scrabble("at");
        assertEquals(2, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAShortValuableWord() {
        Scrabble scrabble = new Scrabble("zoo");
        assertEquals(12, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAMediumWord() {
        Scrabble scrabble = new Scrabble("street");
        assertEquals(6, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAMediumValuableWord() {
        Scrabble scrabble = new Scrabble("quirky");
        assertEquals(22, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testALongMixCaseWord() {
        Scrabble scrabble = new Scrabble("OxyphenButazone");
        assertEquals(41, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAEnglishLikeWord() {
        Scrabble scrabble = new Scrabble("pinata");
        assertEquals(8, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testAnEmptyInput() {
        Scrabble scrabble = new Scrabble("");
        assertEquals(0, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testEntireAlphabetAvailable() {
        Scrabble scrabble = new Scrabble("abcdefghijklmnopqrstuvwxyz");
        assertEquals(87, scrabble.getScore());
    }


    // <editor-fold defaultstate="collapsed" desc="Extension tests">

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Ignore("Remove to run test")
    @Test
    public void whiteSpaceLetterMultiplier() {
        Scrabble scrabble = new Scrabble("crazy cat",
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.BLUE,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE
        );
        assertEquals(24, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDoubleLetterMultiplier() {
        Scrabble scrabble = new Scrabble("score",
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.LIGHT_BLUE
        );
        assertEquals(8, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testTripleLetterMultiplier() {
        Scrabble scrabble = new Scrabble("soccer",
                SquareColor.WHITE,
                SquareColor.BLUE,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE
        );
        assertEquals(12, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testMultiplesLettersMultipliers() {
        Scrabble scrabble = new Scrabble("puzzle",
                SquareColor.LIGHT_BLUE,
                SquareColor.WHITE,
                SquareColor.BLUE,
                SquareColor.LIGHT_BLUE,
                SquareColor.WHITE,
                SquareColor.BLUE
        );
        assertEquals(61, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testDoubleWordScore() {
        Scrabble scrabble = new Scrabble("dog",
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.PINK
        );
        assertEquals(10, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testTripleWordScore() {
        Scrabble scrabble = new Scrabble("kitty",
                SquareColor.WHITE,
                SquareColor.RED,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE
        );
        assertEquals(36, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testTwoDoubleWordScore() {
        Scrabble scrabble = new Scrabble("monkey",
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.PINK,
                SquareColor.WHITE,
                SquareColor.PINK,
                SquareColor.WHITE
        );
        assertEquals(60, scrabble.getScore());
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberOfColorsLessThanTextLength() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("There must be one color per character.");

        new Scrabble("puppy",
                SquareColor.WHITE,
                SquareColor.WHITE);
    }

    @Ignore("Remove to run test")
    @Test
    public void testNumberOfColorsGreaterThanTextLength() {
        expectedException.expect(IllegalArgumentException.class);
        expectedException.expectMessage("There must be one color per character.");

        new Scrabble("fan",
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.WHITE,
                SquareColor.PINK,
                SquareColor.RED,
                SquareColor.BLUE,
                SquareColor.LIGHT_BLUE);
    }

    // </editor-fold>
}
