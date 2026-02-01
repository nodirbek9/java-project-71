package hexlet.code;

import hexlet.code.formatters.Formatter;

public final class Differ {
    private Differ() {
    }

    public static String generate(String filePath1, String filePath2, String formatName) throws Exception {
        var map1 = Parser.parse(filePath1);
        var map2 = Parser.parse(filePath2);

        Diff diff = DiffBuilder.build(map1, map2);
        return Formatter.format(diff, formatName);
    }

    public static String generate(String filePath1, String filePath2) throws Exception {
        return generate(filePath1, filePath2, "stylish");
    }
}
