package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferNestedTest {

    private Path getPath(String resource) throws Exception {
        return Paths.get(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource(resource)
                ).toURI()
        );
    }

    @Test
    public void testDifferMethodJson() throws Exception {
        var expected = Files.readString(getPath("fixtures/json/nested/expected.txt"));
        var result = Differ.generate(getPath("fixtures/json/nested/file1.json").toString(),
                getPath("fixtures/json/nested/file2.json").toString());
        assertEquals(expected, result);
    }
    @Test
    public void testDifferMethodYaml() throws Exception {
        var expected = Files.readString(getPath("fixtures/yaml/nested/expected.txt"));
        var result = Differ.generate(getPath("fixtures/yaml/nested/file1.yaml").toString(),
                getPath("fixtures/yaml/nested/file2.yaml").toString());
        assertEquals(expected, result);
    }
}
