import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagram {

    private final String word;

    public Anagram(String word) {
        this.word = word.toLowerCase();
    }

    public List<String> match(List<String> candidates) {
        List<String> anagrams = new ArrayList<>();

        char[] wordArray = word.toCharArray();
        Arrays.sort(wordArray);

        for (String candidate : candidates) {
            char[] candidateArray = candidate.toLowerCase().toCharArray();
            Arrays.sort(candidateArray);

            boolean sameCharacters = Arrays.equals(wordArray, candidateArray);
            boolean sameWord = word.equalsIgnoreCase(candidate);

            if (sameCharacters && !sameWord) {
                anagrams.add(candidate);
            }
        }
        return anagrams;
    }
}
