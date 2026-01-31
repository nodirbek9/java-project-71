package hexlet.code;

public class StylishFormatter implements Formatter{
    @Override
    public String format(Diff diff) {
        StringBuilder result = new StringBuilder("{\n");
        for (var node : diff.getNodes()) {
            switch (node.getStatus()) {
                case UNCHANGED ->
                        result.append("   ")
                                .append(node.getKey())
                                .append(": ")
                                .append(node.getOldValue())
                                .append("\n");

                case ADDED ->
                        result.append(" + ")
                                .append(node.getKey())
                                .append(": ")
                                .append(node.getNewValue())
                                .append("\n");

                case REMOVED ->
                        result.append(" - ")
                                .append(node.getKey())
                                .append(": ")
                                .append(node.getOldValue())
                                .append("\n");

                case CHANGED -> {
                    result.append(" - ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getOldValue())
                            .append("\n");

                    result.append(" + ")
                            .append(node.getKey())
                            .append(": ")
                            .append(node.getNewValue())
                            .append("\n");
                }
            }
        }

        result.append("}");
        return result.toString();
    }
}
