package hexlet.code;

import hexlet.code.Formatter.Json;
import hexlet.code.Formatter.Plain;
import hexlet.code.Formatter.Stylish;

public class Format {
    public static String formatComparisonResult(String comparisonResult, String format)
            throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.stylishResult(comparisonResult);
            case "plain" -> Plain.plainResult(comparisonResult);
            case "json" -> Json.jsonResult(comparisonResult);
            default -> throw new Exception("This format is unknown: " + format);
        };
    }
}
