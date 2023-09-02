package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;

    @CommandLine.Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]",
            paramLabel = "format")
    private String format = "stylish";

    @Override
    public Integer call() throws Exception {
        String readFilePath1 = "/Users/obyrif/Desktop/Repository/java-project-71/app/src/main/resources/filepath1.json";
        String readFilePath2 = "/Users/obyrif/Desktop/Repository/java-project-71/app/src/main/resources/filepath2.json";

        Path path1 = Paths.get(readFilePath1).toAbsolutePath().normalize();
        Path path2 = Paths.get(readFilePath2).toAbsolutePath().normalize();
        String content1 = Files.readString(path1);
        String content2 = Files.readString(path2);

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> json1 = objectMapper.readValue(content1, Map.class);
        Map<String, Object> json2 = objectMapper.readValue(content2, Map.class);
        String diff = Differ.generate(json1, json2);
        System.out.println(diff);
        return 0;
    }


    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
