package hexlet.code;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class DifferMapList {
    public static List<KeyDifference> diffList(Map<String, Object> json1, Map<String, Object> json2) {
        List<KeyDifference> differences = new ArrayList<>();

        TreeSet<String> allKeys = new TreeSet<>(json1.keySet());
        allKeys.addAll(json2.keySet());

        for (String key : allKeys) {
            Object value1 = json1.get(key);
            Object value2 = json2.get(key);

            KeyDifference difference = new KeyDifference(key);

            if (value1 == null && value2 == null) {
                // Если оба значения равны null, считаем их неизмененными
                difference.setStatus("unchanged");
                difference.setOldValue(null);
                difference.setNewValue(null);
            } else if (value1 == null) {
                difference.setStatus("added");
                difference.setNewValue(value2);
                difference.setOldValue(null); // Значение в первом файле равно null
            } else if (value2 == null) {
                difference.setStatus("removed");
                difference.setOldValue(value1);
                difference.setNewValue(null); // Значение во втором файле равно null
            } else if (!value1.getClass().equals(value2.getClass())) {
                difference.setStatus("changed");
                difference.setOldValue(value1);
                difference.setNewValue(value2);
            } else if (!value1.equals(value2)) {
                difference.setStatus("changed");
                difference.setOldValue(value1);
                difference.setNewValue(value2);
            } else {
                difference.setStatus("unchanged");
                difference.setOldValue(value1);
                difference.setNewValue(value2);
            }
            differences.add(difference);
        }
        return differences;
    }
}

