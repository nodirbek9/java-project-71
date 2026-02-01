package hexlet.code.formatters;

import hexlet.code.Diff;

public final class Formatter {
    private Formatter() {
    }

    public static String format(Diff diff, String formatName) throws Exception {
        Format formatter = switch (formatName) {
            case "plain" -> new PlainFormat();
            case "json" -> new JsonFormat();
            case "stylish" -> new StylishFormat();
            default -> throw new IllegalArgumentException(
                    "Unknown format: " + formatName);
        };

        return formatter.format(diff);
    }
}
