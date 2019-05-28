class IsogramChecker {

    boolean isIsogram(String phrase) {
        // Since hypens and spaces are allowed, they'll be ignored by deleting them.
        phrase = phrase.replace("-","").replace(" ", "");
        phrase = phrase.toLowerCase(); // case insensitive
        long sizeDistinct = phrase.chars().distinct().count();
        long size = phrase.chars().count();
        return size == sizeDistinct;
    }

}
