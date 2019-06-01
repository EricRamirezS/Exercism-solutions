public class PhoneNumber {

    private final String number;

    public PhoneNumber(String s) throws IllegalArgumentException {
        validateInput(s);
        number = formatNumber(s);
    }

    private String formatNumber(String number) {
        number = number.replaceAll("[^0-9]", "");
        number = number.substring(number.length() - 10);
        return number;
    }

    private void validateInput(String number) throws IllegalArgumentException {
        if (!number.replaceAll("[^a-zA-Z]", "").isEmpty()) {
            throw new IllegalArgumentException("letters not permitted");
        }
        String punct = number.replaceAll("[a-zA-Z0-9.\\- ()]","");
        if (punct.length()>0){
            if (punct.charAt(0) == '+'){
                punct = punct.replaceFirst("[+]","");
            }
            if (punct.length()>0){
                throw new IllegalArgumentException("punctuations not permitted");
            }
        }
        number = number.replaceAll("[^0-9]", "");
        if (number.length() < 10) {
            throw new IllegalArgumentException("incorrect number of digits");
        }
        if (number.length() > 11) {
            throw new IllegalArgumentException("more than 11 digits");
        }
        if (number.length() == 11) {
            if (number.charAt(0) != '1') {
                throw new IllegalArgumentException("11 digits must start with 1");
            }
        }
        number = number.substring(number.length() - 10);
        if (number.charAt(0) == '0') {
            throw new IllegalArgumentException("area code cannot start with zero");
        }
        if (number.charAt(0) == '1') {
            throw new IllegalArgumentException("area code cannot start with one");
        }
        if (number.charAt(3) == '0') {
            throw new IllegalArgumentException("exchange code cannot start with zero");
        }
        if (number.charAt(3) == '1') {
            throw new IllegalArgumentException("exchange code cannot start with one");
        }
    }

    public String getNumber() {
        return number;
    }
}
