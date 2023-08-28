package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "path to first file", paramLabel = "filepath1")
    private String filepath1;

    @CommandLine.Parameters(index = "1", description = "path to second file", paramLabel = "filepath2")
    private String filepath2;

    @CommandLine.Option(names = {"-f", "--format"}, description = "output format [default: stylish]", paramLabel = "format")
    private String format = "stylish";

    @Override
    public Integer call() throws Exception {
        String fileContent1 = Files.readString(Path.of(filepath1));
        String fileContent2 = Files.readString(Path.of(filepath2));

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> json1 = objectMapper.readValue(fileContent1, Map.class);
        Map<String, Object> json2 = objectMapper.readValue(fileContent2, Map.class);

        String diff = Differ.generate(json1, json2);
        System.out.println(diff);
        return 0;
    }
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}