package hexlet.code;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    private Path getPath(String resource) throws Exception {
        return Paths.get(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource(resource)
                ).toURI()
        );
    }

    @Test
    public void testDifferMethod() throws Exception {
        var expected = Files.readString(getPath("fixtures/expected.txt"));
        var result = Differ.generate(getPath("fixtures/file1.json").toString(),
                getPath("fixtures/file2.json").toString());
        System.out.println("EXPECTED:");
        System.out.println(expected);
        System.out.println("ACTUAL:");
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    public void testAddedKey() throws Exception {
        var expected = Files.readString(getPath("fixtures/added/expected.txt"));
        var result = Differ.generate(getPath("fixtures/added/file1.json").toString(),
                getPath("fixtures/added/file2.json").toString());
        assertEquals(expected, result);
    }

    @Test
    public void testRemovedKey() throws Exception {
        var expected = Files.readString(getPath("fixtures/removed/expected.txt"));
        var result = Differ.generate(getPath("fixtures/removed/file1.json").toString(),
                getPath("fixtures/removed/file2.json").toString());
        assertEquals(expected, result);
    }

    @Test
    public void testChangedValue() throws Exception {
        var expected = Files.readString(getPath("fixtures/changed/expected.txt"));
        var result = Differ.generate(getPath("fixtures/changed/file1.json").toString(),
                getPath("fixtures/changed/file2.json").toString());
        assertEquals(expected, result);
    }

    @Test
    public void testSameFiles() throws Exception {
        var expected = Files.readString(getPath("fixtures/same/expected.txt"));
        var result = Differ.generate(getPath("fixtures/same/file1.json").toString(),
                getPath("fixtures/same/file1.json").toString());
        assertEquals(expected, result);
    }
}
