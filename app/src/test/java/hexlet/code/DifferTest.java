package hexlet.code;

import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DifferTest {

    @Test
    public void testDifferMethod() throws Exception {
        var expected = Files.readString(Paths.get("fixtures/expected.txt"));
        var result = Differ.generate("fixtures/file1.json", "fixtures/file2.json");
        assertEquals(expected, result);
    }

    @Test
    public void testAddedKey() throws Exception {
        var expected2 = Files.readString(Paths.get("fixtures/added/expected.txt"));
        var result2 = Differ.generate("fixtures/added/file1.json", "fixtures/added/file2.json");
        assertEquals(expected2, result2);
    }

    @Test
    public void testRemovedKey() throws Exception {
        var expected3 = Files.readString(Paths.get("fixtures/removed/expected.txt"));
        var result3 = Differ.generate("fixtures/removed/file1.json", "fixtures/removed/file2.json");
        assertEquals(expected3, result3);
    }

    @Test
    public void testChangedValue() throws Exception {
        var expected4 = Files.readString(Paths.get("fixtures/changed/expected.txt"));
        var result4 = Differ.generate("fixtures/changed/file1.json", "fixtures/changed/file2.json");
        assertEquals(expected4, result4);
    }
    @Test
    public void testSameFiles() throws Exception {
        var expected5 = Files.readString(Paths.get("fixtures/same/expected.txt"));
        var result5 = Differ.generate("fixtures/same/file1.json", "fixtures/same/file1.json");
        assertEquals(expected5, result5);
    }
}
