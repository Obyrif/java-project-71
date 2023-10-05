package hexlet.code.Formatter;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylishResult(List<Map<String, Object>> resultMap) {
        StringBuilder result = new StringBuilder();
        result.append("{");
        for (Map<String, Object> element : resultMap) {
            result.append("\n").append("  ");
            if (element.get("status").equals("deleted")) {
                result.append("- ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("oldValue"));
            } else if (element.get("status").equals("added")) {
                result.append("+ ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("newValue"));
            } else if (element.get("status").equals("unchanged")) {
                result.append("  ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("oldValue"));
            } else if (element.get("status").equals("changed")) {
                result.append("- ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("oldValue"))
                        .append("");
                result.append("  ")
                        .append("+ ")
                        .append(element.get("key"))
                        .append(": ")
                        .append(element.get("newValue"));
            }
        }
        result.append("\n}");
        return result.toString().trim();
    }
}
