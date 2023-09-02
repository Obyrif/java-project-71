import hexlet.code.Differ;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collections;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class TestDiffer {
    @Test
    public void testEmptyJson() throws Exception {
        Map<String, Object> json1 = Collections.emptyMap();
        Map<String, Object> json2 = Collections.emptyMap();

        String expectedDiff = "{}";
        String actualDiff = Differ.generate(json1, json2);
        expectedDiff = expectedDiff.replaceAll("\\s", "");
        actualDiff = actualDiff.replaceAll("\\s", "");

        assertEquals(expectedDiff, actualDiff);
    }
    @Test
    public void testPath() {
        String path1 = "/Users/obyrif/Desktop/Repository/java-project-71/app/src/main/resources/filepath1.json";
        String path2 = "/Users/obyrif/Desktop/Repository/java-project-71/app/src/main/resources/filepath2.json";

        File file = new File(path1);
        File file2 = new File(path2);
        String absolutePath = file.getAbsolutePath();
        String absolutePath2 = file2.getAbsolutePath();
        System.out.println(absolutePath);
        System.out.println(absolutePath2);

        assertTrue(absolutePath.endsWith("/Users/obyrif/Desktop/Repository/java-project-71/app"
                + "/src/main/resources/filepath1.json"));
        assertTrue(absolutePath2.endsWith("/Users/obyrif/Desktop/Repository/java-project-71/"
                + "app/src/main/resources/filepath2.json"));
    }
}
