package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.source.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

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

        return formatDiffSet(diffLine);
    }

    private static String formatDiffSet(Set<String> diffSet) {
        if (diffSet.isEmpty()) {
            return "{}";
        }

        StringBuilder diff = new StringBuilder("{\n");
        for (String line : diffSet) {
            diff.append("  ").append(line).append("\n");
        }
        diff.append("}");

        return diff.toString();
    }
}
