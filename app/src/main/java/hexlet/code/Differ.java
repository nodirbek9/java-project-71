package hexlet.code;

import hexlet.code.formatters.Formatter;

import java.nio.file.Files;
import java.nio.file.Paths;

public final class Differ {
    private Differ() {
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        String content1 = Files.readString(Paths.get(filePath1));
        String content2 = Files.readString(Paths.get(filePath2));
        var map1 = Parser.parse(filePath1, content1);
        var map2 = Parser.parse(filePath2, content2);

        Diff diff = DiffBuilder.build(map1, map2);
        return Formatter.format(diff, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
