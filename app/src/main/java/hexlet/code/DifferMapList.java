package hexlet.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class DifferMapList {
    public static List<KeyDifference> diffList(Map<String, Object> json1, Map<String, Object> json2) {
        Map<String, Object> combined = new TreeMap<>();
        combined.putAll(json1);
        combined.putAll(json2);

        List<KeyDifference> diffs = new ArrayList<>();

        for (String key : combined.keySet()) {
            KeyDifference diff = new KeyDifference(key);

            Object value1 = json1.get(key);
            Object value2 = json2.get(key);

            if (!json2.containsKey(key)) {
                diff.setStatus("removed");
                diff.setOldValue(value1);
                diff.setNewValue(null);
            } else if (!json1.containsKey(key)) {
                diff.setStatus("added");
                diff.setOldValue(null);
                diff.setNewValue(value2);
            } else {
                if (Objects.equals(value1, value2)) {
                    diff.setStatus("unchanged");
                    diff.setOldValue(value1);
                    diff.setNewValue(value2);
                } else {
                    diff.setStatus("changed");
                    diff.setOldValue(value1);
                    diff.setNewValue(value2);
                }
            }

            diffs.add(diff);
        }

        return diffs;
    }
}

