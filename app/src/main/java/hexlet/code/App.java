package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

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
        // логика обработки файлов
        return 0;
    }
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}