package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTestPlain {
    private Path getPath(String resource) throws Exception {
        return Paths.get(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource(resource)
                ).toURI()
        );
    }

    @Test
    public void testDifferMethodPlain() throws Exception {
        var expected = Files.readString(getPath("fixtures/plain/expected.txt"));
        var result = Differ.generate(getPath("fixtures/plain/file1.json").toString(),
                getPath("fixtures/plain/file2.json").toString(), "plain");
        assertEquals(expected, result);
    }

}
