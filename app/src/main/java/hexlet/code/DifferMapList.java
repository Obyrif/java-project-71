package hexlet.code;


import java.util.Map;
import java.util.TreeSet;

public class DifferMapList {
    public static String diffList(Map<String, Object> json1, Map<String, Object> json2) {
        StringBuilder diff = new StringBuilder("{\n");
        TreeSet<String> allKeys = new TreeSet<>(json1.keySet());
        allKeys.addAll(json2.keySet());
        for (String key : allKeys) {
            Object value1 = json1.get(key);
            Object value2 = json2.get(key);

            if (value1 == null && value2 == null) {
                return null;
            } else if (value1 == null) {
                appendDiffLine(diff, "+", key, value2);
            } else if (value2 == null) {
                appendDiffLine(diff, "-", key, value1);
            } else if (!value1.equals(value2)) {
                appendDiffLine(diff, "-", key, value1);
                appendDiffLine(diff, "+", key, value2);
            } else {
                appendDiffLine(diff, " ", key, value1);
            }
        }
        diff.append("}");
        return diff.toString();
    }
    private static void appendDiffLine(StringBuilder diff, String symbol, String key, Object value) {
        diff.append("  ").append(symbol).append(" ").append(key).append(": ").append(value).append("\n");
    }
}
