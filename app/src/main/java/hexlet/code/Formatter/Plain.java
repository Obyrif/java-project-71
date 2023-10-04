package hexlet.code.Formatter;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String plainResult(List<Map<String, Object>> resultMap) {
        StringBuilder formattedResult = new StringBuilder();

        for (Map<String, Object> records : resultMap) {
            String property = records.containsKey("key") ? records.get("key").toString() : null;
            String oldValue = checkValue(records.get("oldValue"));
            String newValue = checkValue(records.get("newValue"));
            String status = records.containsKey("status") ? records.get("status").toString() : null;

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









