package hexlet.code.Formatter;

public class Stylish {

    public static String stylishResult(String result) {
        StringBuilder formattedResult = new StringBuilder();

        String[] lines = result.split("\n");

        for (String line : lines) {
            formattedResult.append("  ");
            formattedResult.append(line);
            formattedResult.append("\n");
        }

        formattedResult.append("");

        return formattedResult.toString();
    }
}
