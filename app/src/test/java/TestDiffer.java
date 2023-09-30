import hexlet.code.Differ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;

import static hexlet.code.Differ.generate;

public class TestDiffer {
    public String absolute;
    @BeforeEach
    void beForeEach() {
        String path = "src/test/resources";
        File file = new File(path);
        absolute = file.getAbsolutePath();
    }
    @Test
    public void testBasisJson() throws Exception {
        String json1 = absolute + "/testKeyBasisJson1.json";
        String json2 = absolute + "/testKeyBasisJson2.json";
        String actual = Differ.generate(json1, json2);
        String expend = """
                    {\s
                       - follow: false
                         host: hexlet.io
                       - proxy: 123.234.53.22
                       - timeout: 50
                       + timeout: 20
                       + verbose: true
                    }""";
        assertThat(actual).isEqualToNormalizingWhitespace(expend);
    }
    @Test
    public void testAlterationJson() throws Exception {
        String json1 = absolute + "/testAlterationJson1.json";
        String json2 = absolute + "/testAlterationJson2.json";
        String actual = generate(json1, json2);
        String expend = """
                {
                      proxy: 123.234.53.22
                    - timeout: 50
                    + timeout: 30
                }""";

        assertThat(actual).isEqualToIgnoringWhitespace(expend);
    }
    @Test
    public void testDeleteJson() throws Exception {
        String json1 = absolute + "/testDeleteJson1.json";
        String json2 = absolute + "/testDeleteJson2.json";
        String actual = generate(json1, json2);
        String expend = """
                {\s
                   + follow: false
                    host: hexlet.io
                  - proxy: 123.234.53.22
                    timeout: 50
                }""";
        assertThat(actual).isEqualToIgnoringWhitespace(expend);
    }
    @Test
    public void testNesting() throws Exception {
        String json1 = absolute + "/testNestingfile1.json";
        String json2 = absolute + "/testNestingfile2.json";
        String actual = generate(json1, json2);
        String expend = """
                {
                      chars1: [a, b, c]
                    - chars2: [d, e, f]
                    + chars2: false
                    - checked: false
                    + checked: true
                    + default: [value1, value2]
                    - id: 45
                    - key1: value1
                    + key2: value2
                      numbers1: [1, 2, 3, 4]
                    - numbers2: [2, 3, 4, 5]
                    + numbers2: [22, 33, 44, 55]
                    - numbers3: [3, 4, 5]
                    + numbers4: [4, 5, 6]
                    + obj1: {nestedKey=value, isNested=true}
                    - setting1: Some value
                    + setting1: Another value
                    - setting2: 200
                    + setting2: 300
                    - setting3: true
                    + setting3: none
                  }
                """;
        assertThat(actual).isEqualToIgnoringWhitespace(expend);
    }
}
