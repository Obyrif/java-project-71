package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Differ {
    public static String generate(Map<String, Object> json1, Map<String, Object> json2) throws Exception {
        Set<String> diffLine = new TreeSet<>();

        for (String key : json1.keySet()) {
            if(!json2.containsKey(key)) {
                diffLine.add("- " + key + ": " + json1.get(key));
            } else {
                if(!json1.get(key).equals(json2.get(key))) {
                    diffLine.add("- " + key + ": " + json1.get(key));
                    diffLine.add("+ " + key + ": " + json2.get(key));
                }
            }
        }

        for (String key: json2.keySet()) {
            if(!json1.containsKey(key)) {
                diffLine.add("+ " + key + ": " + json2.get(key));
            }
        }

        return String.join("\n", diffLine);
    }
}
