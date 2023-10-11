package hexlet.code.Formatter;

import hexlet.code.KeyDifference;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String plainResult(List<KeyDifference> keyDifferences) {
        StringBuilder formattedResult = new StringBuilder();

        for (KeyDifference difference : keyDifferences) {
            String property = difference.getKey();
            String value1 = checkValue(difference.getValue1());
            String value2 = checkValue(difference.getValue2());
            String status = difference.getStatus();

            if ("removed".equals(status)) {
                formattedResult.append("Property '").append(property).append("' was removed\n");
            } else if ("added".equals(status)) {
                formattedResult.append("Property '").append(property).append("' was added with value: ")
                        .append(value2).append("\n");
            } else if ("changed".equals(status)) {
                formattedResult.append("Property '").append(property).append("' was updated. From ")
                        .append(value1).append(" to ").append(value2).append("\n");
            }
        }

        return formattedResult.toString().trim();
    }

    public static String checkValue(Object value) {
        if (value instanceof Map || value instanceof List<?>) {
            return "[complex value]";
        } else if (value instanceof String) {
            return "'" + value + "'";
        } else if (value == null) {
            return "null";
        }
        return value.toString();
    }
}
