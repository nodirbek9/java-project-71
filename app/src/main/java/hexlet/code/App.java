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

        @Override
        public String call() throws Exception {
            String result = Differ.generate(filePath1, filePath2, format);
            System.out.println(result);
            return null;
        }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }

}
