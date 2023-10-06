package hexlet.code.Formatter;
import hexlet.code.KeyDifference;

import java.util.List;
import java.util.StringJoiner;

public class Stylish {
    public static String stylishResult(List<KeyDifference> differences) {
        StringJoiner joiner = new StringJoiner("\n", "{\n", "\n}");

        for (KeyDifference difference : differences) {
            String status = difference.getStatus();
            Object oldValue = difference.getOldValue();
            Object newValue = difference.getNewValue();

            switch (status) {
                case "added":
                    joiner.add("  + " + difference.getKey() + ": " + stringifyValue(newValue));
                    break;
                case "removed":
                    joiner.add("  - " + difference.getKey() + ": " + stringifyValue(oldValue));
                    break;
                case "changed":
                    joiner.add("  - " + difference.getKey() + ": " + stringifyValue(oldValue));
                    joiner.add("  + " + difference.getKey() + ": " + stringifyValue(newValue));
                    break;
                case "unchanged":
                    joiner.add("    " + difference.getKey() + ": " + stringifyValue(newValue));
                    break;
                default:
                    throw new RuntimeException("Unknown status of element: '" + status + "'");
            }
        }
        return joiner.toString();
    }

    private static String stringifyValue(Object value) {
        if (value instanceof String) {
            return value.toString();
        } else if (value == null) {
            return "null";
        } else {
            return value.toString();
        }
    }
}

