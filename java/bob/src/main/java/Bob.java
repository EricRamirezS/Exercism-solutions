public class Bob {

    enum MessageType {QUESTION, YELL, QUESTION_YELL, IGNORED, OTHER}

    String hey(String message) {
        switch (analyzeMessage(message)) {
            case QUESTION:
                return "Sure.";
            case YELL:
                return "Whoa, chill out!";
            case QUESTION_YELL:
                return "Calm down, I know what I'm doing!";
            case IGNORED:
                return "Fine. Be that way!";
            default:
                return "Whatever.";
        }
    }

    private MessageType analyzeMessage(String message) {
        // Checking if there's a message
        if (message == null || message.trim().isEmpty()) return MessageType.IGNORED;

        // Removing unneeded whitespaces
        message = message.trim();
        // Checking if the last character is a Question Mark.
        boolean question = message.endsWith("?");

        // Removing all non-letter characters
        message = message.replaceAll("[^a-zA-Z]", "");

        // Checking if the message letters are all Uppercase
        boolean yelling = message.equals(message.toUpperCase()) && !message.isEmpty();

        if (question && yelling) return MessageType.QUESTION_YELL;
        if (question) return MessageType.QUESTION;
        if (yelling) return MessageType.YELL;
        return MessageType.OTHER;
    }
}
