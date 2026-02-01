package hexlet.code.formatters;

import hexlet.code.Diff;

public class Formatter {
    public static String format(Diff diff, String formatName) {
        Format formatter = switch (formatName) {
            case "plain" -> new PlainFormat();
            case "stylish" -> new StylishFormat();
            default -> throw new IllegalArgumentException(
                    "Unknown format: " + formatName
            );
        };

        return formatter.format(diff);
    }
}
