package hexlet.code;

public class Formatter {
    public static String formatComparisonResult(String comparisonResult, String format)
            throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.stylishResult(comparisonResult);
            default -> throw new Exception("This format is unknown: " + format);
        };
    }
}
