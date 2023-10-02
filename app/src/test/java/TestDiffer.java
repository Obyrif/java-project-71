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
            "src/test/resources/testfile1.json";
    public static final String FILE2_JSON =
            "src/test/resources/testfile2.json";

    public static final String FILE1_YAML =
            "src/test/resources/test1Y.yml";
    public static final String FILE2_YAML =
            "src/test/resources/test2Y.yml";

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
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
    public void testRightComparisonJSON() throws Exception {
        String result = Differ.generate(FILE1_JSON, FILE2_JSON);
        assertThat(result).isEqualToIgnoringWhitespace(resultStylish);
    }
    @Test
    public void testRightComparisonYaml() throws Exception {
        String result = Differ.generate(FILE1_YAML, FILE2_YAML);
        assertThat(result).isEqualToIgnoringWhitespace(resultStylish);
    }
    @Test
    public void testRightComparisonStylishJSON() throws Exception {
        String result = Differ.generate(FILE1_JSON, FILE2_JSON, "stylish");
        assertThat(result).isEqualToIgnoringWhitespace(resultStylish);
    }
    @Test
    public void testRightComparisonStylishYAML() throws Exception {
        String result = Differ.generate(FILE1_YAML, FILE2_YAML, "stylish");
        assertThat(result).isEqualToIgnoringWhitespace(resultStylish);
    }


    @Test
    public void testRightComparisonPlainJSON() throws Exception {
        String result = Differ.generate(FILE1_JSON, FILE2_JSON, "plain");
        assertThat(result).isEqualToIgnoringWhitespace(resultPlain);
    }

    @Test
    public void testRightComparisonPlainYAML() throws Exception {
        String result = Differ.generate(FILE1_YAML, FILE2_YAML, "plain");
        assertThat(result).isEqualToIgnoringWhitespace(resultPlain);
    }

    @Test
    public void testRightComparisonFormatJSONJ() throws Exception {
        String result = Differ.generate(FILE1_JSON, FILE2_JSON, "json");
        assertThat(result).isEqualTo(resultJson);
    }

    @Test
    public void testRightComparisonFormatJSONY() throws Exception {
        String result = Differ.generate(FILE1_YAML, FILE2_YAML, "json");
        assertThat(result).isEqualTo(resultJson);
    }
}
