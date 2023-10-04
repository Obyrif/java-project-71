package hexlet.code;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DifferMapList {
    public static List<Map<String, Object>> diffList(Map<String, Object> json1, Map<String, Object> json2) {
        List<Map<String, Object>> differences = new ArrayList<>();

        TreeSet<String> allKeys = new TreeSet<>(json1.keySet());
        allKeys.addAll(json2.keySet());

        for (String key : allKeys) {
            Object value1 = json1.get(key);
            Object value2 = json2.get(key);

            Map<String, Object> difference = new LinkedHashMap<>();
            difference.put("key", key);

            if (value1 == null && value2 == null) {
                difference.put("status", "unchanged");
            } else if (value1 == null) {
                difference.put("status", "added");
                difference.put("newValue", value2);
            } else if (value2 == null) {
                difference.put("status", "removed");
                difference.put("oldValue", value1);
            } else if (!value1.getClass().equals(value2.getClass())) {
                difference.put("status", "changed");
                difference.put("oldValue", value1);
                difference.put("newValue", value2);
            } else if (!value1.equals(value2)) {
                difference.put("status", "changed");
                difference.put("oldValue", value1);
                difference.put("newValue", value2);
            } else {
                difference.put("status", "unchanged");
            }
            differences.add(difference);
        }
        return differences;
    }
}

