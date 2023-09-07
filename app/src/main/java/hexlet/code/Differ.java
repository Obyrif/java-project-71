package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.beans.PropertyEditorSupport;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class Differ {
    public static String generate(String js1, String js2) throws IOException {
        TypeReference<HashMap<String, Object>> type = new TypeReference<>() { };
        Path p1 = Path.of(js1).toAbsolutePath();
        Path p2 = Path.of(js2).toAbsolutePath();

        ObjectMapper mapper = new ObjectMapper();
        final Map<String, Object> json1 = mapper.readValue(Files.readString(p1), type);
        final Map<String, Object> json2 = mapper.readValue(Files.readString(p2), type);

        StringBuilder diff = new StringBuilder("{\n");
        TreeSet<String> allKeys = new TreeSet<>(json1.keySet());
        allKeys.addAll(json2.keySet());

        for (String key : allKeys) {
            Object value1 = json1.get(key);
            Object value2 = json2.get(key);

            if (json1.containsKey(key) && !json2.containsKey(key)) {
                appendDiffLine(diff, "-", key, value1);
            } else if (!json1.containsKey(key) && json2.containsKey(key)) {
                appendDiffLine(diff, "+", key, value2);
            } else if (!value1.equals(value2)) {
                appendDiffLine(diff, "-", key, value1);
                appendDiffLine(diff, "+", key, value2);
            } else if (value1.equals(value2)) {
                appendDiffLine(diff, " ", key, value1);
            }
        }
        diff.append("}");
        return diff.toString();
    }

    private static void appendDiffLine(StringBuilder diff, String symbol, String key, Object value) {
        diff.append("  ").append(symbol).append(" ").append(key).append(": ");
        if (value instanceof String) {
            diff.append(value);
        } else {
            diff.append(value);
        }
        diff.append("\n");
    }
}
