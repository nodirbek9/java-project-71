package hexlet.code;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        var map1 = Parser.parse(filePath1);
        var map2 = Parser.parse(filePath2);

        Diff diff = DiffBuilder.build(map1, map2);

        Formatter formatter = new StylishFormatter();
        return formatter.format(diff);
    }
}
