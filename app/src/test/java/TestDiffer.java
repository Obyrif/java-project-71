import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TestDiffer {
    private static String resultStylish;
    private static String resultPlain;
    private static String resultJson;

    public static final String FILE1_JSON =
            "src/test/resources/fixtures/testfile1.json";
    public static final String FILE2_JSON =
            "src/test/resources/fixtures/testfile2.json";
    public static final String FILE1_YAML =
            "src/test/resources/fixtures/test1Y.yml";
    public static final String FILE2_YAML =
            "src/test/resources/fixtures/test2Y.yml";

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();

    }

    @BeforeAll
    public static void beforeAll() throws Exception {
        resultStylish = readFixture("resultSlylish.txt");
        resultPlain = readFixture("resultPlain.txt");
        resultJson = readFixture("resultJson.json");
    }

    @Test
    public void testRightComparison() throws Exception {
        String result = Differ.generate(FILE1_JSON, FILE2_JSON);
        assertThat(result).isEqualToIgnoringWhitespace(resultStylish);
        String result2 = Differ.generate(FILE1_YAML, FILE2_YAML);
        assertThat(result2).isEqualToIgnoringWhitespace(resultStylish);
        String result3 = Differ.generate(FILE1_JSON, FILE2_JSON, "stylish");
        assertThat(result3).isEqualToIgnoringWhitespace(resultStylish);
        String result4 = Differ.generate(FILE1_YAML, FILE2_YAML, "stylish");
        assertThat(result4).isEqualToIgnoringWhitespace(resultStylish);
        String result5 = Differ.generate(FILE1_JSON, FILE2_JSON, "plain");
        assertThat(result5).isEqualToIgnoringWhitespace(resultPlain);
        String result6 = Differ.generate(FILE1_YAML, FILE2_YAML, "plain");
        assertThat(result6).isEqualToIgnoringWhitespace(resultPlain);
    }

    @Test
    public void testRightComparisonFormatJSONJ() throws Exception {
        String result = Differ.generate(FILE1_JSON, FILE2_JSON, "json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expectedJson = objectMapper.readTree(resultJson);
        JsonNode actualJson = objectMapper.readTree(result);
        assertThat(actualJson).isEqualTo(expectedJson);
    }

    @Test
    public void testRightComparisonFormatJSONY() throws Exception {
        String result = Differ.generate(FILE1_YAML, FILE2_YAML, "json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode expendJson = objectMapper.readTree(resultJson);
        JsonNode actualJson = objectMapper.readTree(result);
        assertThat(actualJson).isEqualTo(expendJson);
    }
}
