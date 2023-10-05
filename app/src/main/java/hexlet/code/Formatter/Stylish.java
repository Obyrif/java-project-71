package hexlet.code.Formatter;
import hexlet.code.KeyDifference;

import java.util.List;

public class Stylish {
    public static String stylishResult(List<KeyDifference> differences) {
        StringBuilder result = new StringBuilder("{\n");
        for (KeyDifference difference : differences) {
            String status = difference.getStatus();
            Object oldValue = difference.getOldValue();
            Object newValue = difference.getNewValue();

            switch (status) {
                case "added":
                    result.append("  + ").append(difference.getKey()).append(": ").append(newValue).append("\n");
                    break;
                case "removed":
                    result.append("  - ").append(difference.getKey()).append(": ").append(oldValue).append("\n");
                    break;
                case "changed":
                    result.append("  - ").append(difference.getKey()).append(": ").append(oldValue).append("\n")
                            .append("  + ").append(difference.getKey()).append(": ").append(newValue).append("\n");
                    break;
                case "unchanged":
                    result.append("    ").append(difference.getKey()).append(": ").append(newValue).append("\n");
                    break;
                default:
                    throw new RuntimeException("Unknown status of element: '" + status + "'");
            }
        }
        result.append("}");
        return result.toString();
    }
}

