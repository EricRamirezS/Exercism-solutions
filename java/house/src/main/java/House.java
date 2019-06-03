import java.util.ArrayList;
import java.util.List;

public class House {

    public String verse(int verse) {
        StringBuilder sb = new StringBuilder("This is ");
        for (int i = verse - 1; i > -1; i--) {
            String the = theThatList.get(i).getThe();
            String that = theThatList.get(i).getThat();
            int billion = 1_000_000_000;
            String theThat = String.format("the %s that %s ", the, that);
            sb.append(theThat);
        }
        return sb.toString().trim();
    }

    public String verses(int startVerse, int endVerse) {
        StringBuilder sb = new StringBuilder();
        for (int i = startVerse; i <= endVerse; i++) {
            sb.append(verse(i));
            sb.append("\n");
        }
        return sb.toString().trim();
    }

    public String sing() {
        return verses(1, 12);
    }


    private static final List<TheThat> theThatList = new ArrayList<TheThat>() {{
        add(new TheThat("house", "Jack built."));
        add(new TheThat("malt", "lay in"));
        add(new TheThat("rat", "ate"));
        add(new TheThat("cat", "killed"));
        add(new TheThat("dog", "worried"));
        add(new TheThat("cow with the crumpled horn", "tossed"));
        add(new TheThat("maiden all forlorn", "milked"));
        add(new TheThat("man all tattered and torn", "kissed"));
        add(new TheThat("priest all shaven and shorn", "married"));
        add(new TheThat("rooster that crowed in the morn", "woke"));
        add(new TheThat("farmer sowing his corn", "kept"));
        add(new TheThat("horse and the hound and the horn", "belonged to"));
    }};

    private static final class TheThat {
        private final String the;
        private final String that;

        private TheThat(String the, String that) {
            this.the = the;
            this.that = that;
        }

        String getThe() {
            return the;
        }

        String getThat() {
            return that;
        }
    }
}

