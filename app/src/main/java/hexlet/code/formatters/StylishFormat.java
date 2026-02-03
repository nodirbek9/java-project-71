package hexlet.code.formatters;

import hexlet.code.Diff;

public final class StylishFormat implements Format {
    @Override
    public String format(Diff diff) {
        StringBuilder result = new StringBuilder("{\n");
        for (var node : diff.getNodes()) {
            switch (node.getStatus()) {
                case UNCHANGED -> result.append("    ")
                        .append(node.getKey())
                        .append(": ")
                        .append(node.getOldValue())
                        .append("\n");

                case ADDED -> result.append("  + ")
                        .append(node.getKey())
                        .append(": ")
                        .append(node.getNewValue())
                        .append("\n");

                case REMOVED -> result.append("  - ")
                        .append(node.getKey())
                        .append(": ")
                        .append(node.getOldValue())
                        .append("\n");

                case CHANGED -> {
                    result.append("  - ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getOldValue())
                            .append("\n");

                    result.append("  + ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getNewValue())
                            .append("\n");
                }
                default -> throw new RuntimeException(
                        "Unknown status: " + node.getStatus() + " for key: " + node.getKey()
                );
            }
        }

        result.append("}");
        return result.toString();
    }
}
