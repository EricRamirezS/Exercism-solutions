import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Markdown {

    String parse(String markdown) {

        String[] lines = markdown.split("\n");

        StringBuilder result = new StringBuilder();

        boolean activeList = false;

        for (String line : lines) {

            String theLine = parseHeader(line);

            if (theLine == null) {
                theLine = parseListItem(line);
            }

            if (theLine == null) {
                theLine = parseParagraph(line);
            }

            boolean isList = theLine.matches("(<li>).*");
            boolean isHeader = theLine.matches("(<h).*");
            boolean isParagraph = theLine.matches("(<p>).*");

            if (isList && !(isHeader || isParagraph || activeList)) {
                activeList = true;
                result.append("<ul>");
            } else if (!isList && activeList) {
                activeList = false;
                result.append("</ul>");
            }
            result.append(theLine);
        }

        if (activeList) {
            result.append("</ul>");
        }

        return result.toString();
    }

    private String parseHeader(String markdown) {
        int count = 0;

        Matcher matcher = Pattern.compile("[^#+]").matcher(markdown);
        count = matcher.find() ? matcher.start() : 0;

        if (count == 0) {
            return null;
        }

        return String.format("<h%s>%s</h%s>", count, markdown.substring(count + 1), count);
    }

    private String parseListItem(String markdown) {
        if (markdown.startsWith("*")) {
            String skipAsterisk = markdown.substring(2);
            String listItemString = parseSomeSymbols(skipAsterisk);
            return String.format("<li>%s</li>", listItemString);
        }

        return null;
    }

    private String parseParagraph(String markdown) {
        return String.format("<p>%s</p>", parseSomeSymbols(markdown));
    }

    private String parseSomeSymbols(String markdown) {

        String lookingFor = "__(.+)__";
        String update = "<strong>$1</strong>";
        String workingOn = markdown.replaceAll(lookingFor, update);

        lookingFor = "_(.+)_";
        update = "<em>$1</em>";
        return workingOn.replaceAll(lookingFor, update);
    }
}