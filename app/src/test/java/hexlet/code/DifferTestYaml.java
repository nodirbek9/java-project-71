package hexlet.code;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTestYaml {

    private Path getPath(String resource) throws Exception {
        return Paths.get(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource(resource)
                ).toURI()
        );
    }

    @Test
    public void testDifferMethod() throws Exception {
        var expected = Files.readString(getPath("fixtures/yaml/expected.txt"));
        var result = Differ.generate(getPath("fixtures/yaml/file1.yaml").toString(),
                getPath("fixtures/yaml/file2.yaml").toString());
        assertEquals(expected, result);
    }

    @Test
    public void testAddedKey() throws Exception {
        var expected = Files.readString(getPath("fixtures/yaml/added/expected.txt"));
        var result = Differ.generate(getPath("fixtures/yaml/added/file1.yaml").toString(),
                getPath("fixtures/yaml/added/file2.yaml").toString());
        assertEquals(expected, result);
    }

    @Test
    public void testRemovedKey() throws Exception {
        var expected = Files.readString(getPath("fixtures/yaml/removed/expected.txt"));
        var result = Differ.generate(getPath("fixtures/yaml/removed/file1.yaml").toString(),
                getPath("fixtures/yaml/removed/file2.yaml").toString());
        assertEquals(expected, result);
    }

    @Test
    public void testChangedValue() throws Exception {
        var expected = Files.readString(getPath("fixtures/yaml/changed/expected.txt"));
        var result = Differ.generate(getPath("fixtures/yaml/changed/file1.yaml").toString(),
                getPath("fixtures/yaml/changed/file2.yaml").toString());
        assertEquals(expected, result);
    }

    @Test
    public void testSameFiles() throws Exception {
        var expected = Files.readString(getPath("fixtures/yaml/same/expected.txt"));
        var result = Differ.generate(getPath("fixtures/yaml/same/file1.yaml").toString(),
                getPath("fixtures/yaml/same/file1.yaml").toString());
        assertEquals(expected, result);
    }
}
