class Twofer {

    String twofer(String name) {
        return String.format("One for %s, one for me.", isNullOrEmpty(name)?"you":name);
    }

    /**
     * Checks if a given string is null, it is empty or if it only has white spaces
     * @param str String to evaluate
     * @return true if Null or Empty
     */
    private static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }
}
