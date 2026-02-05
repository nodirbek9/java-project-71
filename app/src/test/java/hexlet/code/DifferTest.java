package hexlet.code;

import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DifferTest {

    private Path getPath(String resource) throws Exception {
        return Paths.get(
                Objects.requireNonNull(
                        getClass().getClassLoader().getResource(resource)
                ).toURI()
        );
    }

    private String read(String resource) throws Exception {
        return Files.readString(getPath(resource));
    }

    @Test
    void testJsonStylish() throws Exception {
        var expected = read("fixtures/json/expected.txt");

        var result = Differ.generate(
                getPath("fixtures/json/file1.json").toString(),
                getPath("fixtures/json/file2.json").toString()
        );

        assertEquals(expected, result);
    }

    @Test
    void testYamlStylish() throws Exception {
        var expected = read("fixtures/yaml/expected.txt");

        var result = Differ.generate(
                getPath("fixtures/yaml/file1.yaml").toString(),
                getPath("fixtures/yaml/file2.yaml").toString()
        );

        assertEquals(expected, result);
    }

    @Test
    void testNestedJson() throws Exception {
        var expected = read("fixtures/json/nested/expected.txt");

        var result = Differ.generate(
                getPath("fixtures/json/nested/file1.json").toString(),
                getPath("fixtures/json/nested/file2.json").toString()
        );

        assertEquals(expected, result);
    }

    @Test
    void testNestedYaml() throws Exception {
        var expected = read("fixtures/yaml/nested/expected.txt");

        var result = Differ.generate(
                getPath("fixtures/yaml/nested/file1.yaml").toString(),
                getPath("fixtures/yaml/nested/file2.yaml").toString()
        );

        assertEquals(expected, result);
    }

    @Test
    void testPlainJson() throws Exception {
        var expected = read("fixtures/plain/expected.txt");

        var result = Differ.generate(
                getPath("fixtures/plain/file1.json").toString(),
                getPath("fixtures/plain/file2.json").toString(),
                "plain"
        );

        assertEquals(expected, result);
    }

    @Test
    void testPlainYaml() throws Exception {
        var expected = read("fixtures/plain/expected_Yml.txt");

        var result = Differ.generate(
                getPath("fixtures/plain/file1.yaml").toString(),
                getPath("fixtures/plain/file2.yaml").toString(),
                "plain"
        );

        assertEquals(expected, result);
    }

    @Test
    void testJsonFormatJson() throws Exception {
        var expected = read("fixtures/jsonformat/expected.txt");

        var result = Differ.generate(
                getPath("fixtures/jsonformat/file1.json").toString(),
                getPath("fixtures/jsonformat/file2.json").toString(),
                "json"
        );

        assertEquals(expected, result);
    }

    @Test
    void testJsonFormatYaml() throws Exception {
        var expected = read("fixtures/jsonformat/expected_Yml.txt");

        var result = Differ.generate(
                getPath("fixtures/jsonformat/file1.yaml").toString(),
                getPath("fixtures/jsonformat/file2.yaml").toString(),
                "json"
        );

        assertEquals(expected, result);
    }

    @Test
    void testDefaultFormatEqualsStylish() throws Exception {
        var defaultResult = Differ.generate(
                getPath("fixtures/json/file1.json").toString(),
                getPath("fixtures/json/file2.json").toString()
        );

        var stylishResult = Differ.generate(
                getPath("fixtures/json/file1.json").toString(),
                getPath("fixtures/json/file2.json").toString(),
                "stylish"
        );

        assertEquals(stylishResult, defaultResult);
    }
}

