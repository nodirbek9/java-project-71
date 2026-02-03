package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferJsonTest {

    private Path getPath(String resource) throws Exception {
        return Paths.get(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource(resource)
                ).toURI()
        );
    }

    @Test
    void testDifferMethod() throws Exception {
        var expected = Files.readString(getPath("fixtures/json/expected.txt"));
        var result = Differ.generate(getPath("fixtures/json/file1.json").toString(),
                getPath("fixtures/json/file2.json").toString());
        assertEquals(expected, result);
    }

    @Test
    void testAddedKey() throws Exception {
        var expected = Files.readString(getPath("fixtures/json/added/expected.txt"));
        var result = Differ.generate(getPath("fixtures/json/added/file1.json").toString(),
                getPath("fixtures/json/added/file2.json").toString());
        assertEquals(expected, result);
    }

    @Test
    void testRemovedKey() throws Exception {
        var expected = Files.readString(getPath("fixtures/json/removed/expected.txt"));
        var result = Differ.generate(getPath("fixtures/json/removed/file1.json").toString(),
                getPath("fixtures/json/removed/file2.json").toString());
        assertEquals(expected, result);
    }

    @Test
    void testChangedValue() throws Exception {
        var expected = Files.readString(getPath("fixtures/json/changed/expected.txt"));
        var result = Differ.generate(getPath("fixtures/json/changed/file1.json").toString(),
                getPath("fixtures/json/changed/file2.json").toString());
        assertEquals(expected, result);
    }

    @Test
    void testSameFiles() throws Exception {
        var expected = Files.readString(getPath("fixtures/json/same/expected.txt"));
        var result = Differ.generate(getPath("fixtures/json/same/file1.json").toString(),
                getPath("fixtures/json/same/file1.json").toString());
        assertEquals(expected, result);
    }

    @Test
    void testDefaultEqualsStylishJson() throws Exception {
        var resultDefault = Differ.generate(
                getPath("fixtures/json/file1.json").toString(),
                getPath("fixtures/json/file2.json").toString()
        );

        var resultStylish = Differ.generate(
                getPath("fixtures/json/file1.json").toString(),
                getPath("fixtures/json/file2.json").toString(),
                "stylish"
        );

        assertEquals(resultStylish, resultDefault);
    }
}
