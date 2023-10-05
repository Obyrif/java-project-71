package hexlet.code.Formatter;

import hexlet.code.KeyDifference;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String plainResult(List<KeyDifference> keyDifferences) {
        StringBuilder formattedResult = new StringBuilder();

        for (KeyDifference difference : keyDifferences) {
            String property = difference.getKey();
            String oldValue = checkValue(difference.getOldValue());
            String newValue = checkValue(difference.getNewValue());
            String status = difference.getStatus();

            if ("removed".equals(status)) {
                formattedResult.append("Property '").append(property).append("' was removed");
            } else if ("added".equals(status)) {
                formattedResult.append("Property '").append(property).append("' was added with value: ")
                        .append(newValue);
            } else if ("changed".equals(status)) {
                formattedResult.append("Property '").append(property).append("' was updated. From ")
                        .append(oldValue).append(" to ").append(newValue);
            }

            formattedResult.append("\n");
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








