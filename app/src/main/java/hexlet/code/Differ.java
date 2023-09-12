package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Differ {
    public static String generate(String js1, String js2, String format) throws Exception {
        String p1 = read(js1);
        String p2 = read(js2);

        String p1Format = format(js1);
        String p2Format = format(js2);

        var json1 = Parser.parserFiletToMap(p1, p1Format);
        var json2 = Parser.parserFiletToMap(p2, p2Format);

        return DifferMapList.diffList(json1,json2);
    }

    public static String generate(String js1,String js2) throws Exception{
        return generate(js1,js2, "stylish");
    }

    public static String read(String pathFile) throws IOException {
        Path path = Paths.get(pathFile).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    public static String format(String pathFile) {
        String extension = pathFile.toLowerCase();
        if (extension.contains("json")) {
            return "json";
        } else if (extension.contains("yml") || extension.contains("yaml")) {
            return "yml";
        } else {
            throw new RuntimeException("error");
        }
    }
}

