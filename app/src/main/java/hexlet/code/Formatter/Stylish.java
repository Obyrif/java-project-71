package hexlet.code.Formatter;
import java.util.List;
import java.util.Map;

public class Stylish {
    public static String stylishResult(List<Map<String, Object>> resultMap) {
        StringBuilder result = new StringBuilder("{\n");
        for (Map<String, Object> elem : resultMap) {
            String status = elem.get("status").toString();
            Object oldValue = elem.get("oldValue");
            Object newValue = elem.get("newValue");

            if (oldValue == null) {
                oldValue = "null";
            }

            if (newValue == null) {
                newValue = "null";
            }

            switch (status) {
                case "added":
                    result.append("  + ").append(elem.get("key")).append(": ").append(newValue).append("\n");
                    break;
                case "removed":
                    result.append("  - ").append(elem.get("key")).append(": ").append(oldValue).append("\n");
                    break;
                case "changed":
                    result.append("  - ").append(elem.get("key")).append(": ").append(oldValue).append("\n")
                            .append("  + ").append(elem.get("key")).append(": ").append(newValue).append("\n");
                    break;
                case "unchanged":
                    result.append("    ").append(elem.get("key")).append(": ").append(newValue).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown status of element: '" + status + "'");
            }
        }
        result.append("}");
        return result.toString();
    }
}

