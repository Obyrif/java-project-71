package hexlet.code.Formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.KeyDifference;

import java.util.List;

public class Json {
    public static String jsonResult(List<KeyDifference> result) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(result);
    }
}
