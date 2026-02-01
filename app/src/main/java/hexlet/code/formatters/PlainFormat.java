package hexlet.code.formatters;

import hexlet.code.Diff;

import java.util.List;
import java.util.Map;

public class PlainFormat implements Format {
    public String format(Diff diff) {
        StringBuilder result = new StringBuilder();
        for (var node : diff.getNodes()) {
            switch (node.getStatus()) {
                case ADDED -> result.append("Property '")
                        .append(node.getKey())
                        .append("' was added with value: ")
                        .append(stringPrint(node.getNewValue()))
                        .append("\n");

                case REMOVED -> result.append("Property '")
                        .append(node.getKey())
                        .append("' was removed")
                        .append("\n");

                case CHANGED -> {
                    result.append("Property '")
                            .append(node.getKey())
                            .append("' was updated. From ")
                            .append(stringPrint(node.getOldValue()))
                            .append(" to ")
                            .append(stringPrint(node.getNewValue()))
                            .append("\n");
                }
            }
        }
        return result.toString();
    }

    private static String stringPrint(Object value) {
        if (value == null) {
            return "null";
        }
        if (isComplex(value)) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }

    private static boolean isComplex(Object value) {
        return value instanceof Map || value instanceof List;
    }
}
