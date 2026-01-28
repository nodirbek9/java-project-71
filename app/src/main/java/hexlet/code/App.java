package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;

@Command(
        name = "gendiff",
        mixinStandardHelpOptions = true,  // ⬅️ ЭТО ВАЖНО!
        version = "1.0",
        description = "Compares two configuration files and shows a difference."
)
public class App implements Callable<String> {

        @Option(
                names = { "-f", "--format" },
                paramLabel = "format",
                description = "output format [default: ${DEFAULT-VALUE}]",
                defaultValue = "stylish"

        )
        private String format;

        @CommandLine.Parameters(
                index = "0",
                paramLabel = "filepath1",
                description = "path to first file"
        )
        private String filePath1;

        @CommandLine.Parameters(
                index = "1",
                paramLabel = "filepath2",
                description = "path to second file"
        )
        private String filePath2;

        @Option(
                names = { "-h", "--help" },
                usageHelp = true,
                description = "Show this help message and exit."
        )
        private boolean helpRequested = false;

        @Option(
                names = { "-V", "--version" },
                versionHelp = true,
                description = "Print version information and exit."
        )
        private boolean versionRequested = false;
        @Override
        public String call() throws Exception {
            // Основная логика будет здесь
            System.out.println(Differ.generate("file1.json", "file2.json"));
            return Differ.generate("file1.json", "file2.json");
        }

    public static void main(String[] args) throws Exception {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
