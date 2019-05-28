class ReverseString {

    String reverse(String inputString) {
        StringBuilder reversed = new StringBuilder();
        for (int i = inputString.length(); i > 0; ) {
            reversed.append(inputString.charAt(--i));
        }
        return reversed.toString();
    }

}