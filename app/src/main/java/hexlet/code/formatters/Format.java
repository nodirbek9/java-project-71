package hexlet.code.formatters;

import hexlet.code.Diff;

public interface Format {

    String format(Diff diff) throws Exception;
}
