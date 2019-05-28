class PigLatinTranslator {

    private boolean warningQu = false;

    String translate(String string) {
        String[] words = string.split(" ");
        String[] pigWords = new String[words.length];
        int index = 0;
        for (String str : words) {
            StringBuilder initConsonants = new StringBuilder();
            for (int i = 0; i < str.length() - 1; i++) {
                if (isVowel(str.charAt(i), str.charAt(i + 1))) break;
                initConsonants.append(str.charAt(i));
                if (warningQu) {
                    initConsonants.append(str.charAt(++i));
                }
            }
            pigWords[index++] = str.replaceFirst(initConsonants.toString(), "")
                    .concat(initConsonants.toString())
                    .concat("ay");
        }
        return String.join(" ", pigWords);
    }


    private boolean isVowel(char c, char nc) {
        warningQu = false;
        if (isVowel(c)) {
            return true;
        }
        // x and y are vowels if next character is consonant
        if ("xyXY".indexOf(c) > -1) {
            return !isVowel(nc);
        }
        // q is consonant, if next character is u, then u is consonant
        if ("qQ".indexOf(c) > -1) {
            if ("uU".indexOf(nc) > -1) {
                warningQu = true;
                return false;
            }
        }
        return false;
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) > -1;
    }
}
