package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.fasterxml.jackson.core.type.TypeReference;


import java.io.IOException;
import java.util.Map;

public class Parser {
    public static Map<String, Object> parserFiletToMap(String file, String input) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectMapper yamlMapper = new YAMLMapper();
        return switch (input) {
            case "json" -> objectMapper.readValue(file, new TypeReference<>() {
            });
            case "yml" -> yamlMapper.readValue(file, new TypeReference<>() {
            });
            default -> throw new IllegalArgumentException("Unsupported input format: " + input);
        };
    }
}
