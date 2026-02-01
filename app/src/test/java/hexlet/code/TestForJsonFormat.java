package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestForJsonFormat {
    private Path getPath(String resource) throws Exception {
        return Paths.get(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource(resource)
                ).toURI()
        );
    }

    @Test
    public void testForJsonForm() throws Exception {
        var expected = Files.readString(getPath("fixtures/jsonformat/expected.txt"));
        var result = Differ.generate(getPath("fixtures/jsonformat/file1.json").toString(),
                getPath("fixtures/jsonformat/file2.json").toString(), "json");
        assertEquals(expected, result);
    }
}
