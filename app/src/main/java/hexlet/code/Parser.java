package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parse(String filePath) throws Exception {
        String content = Files.readString(Paths.get(filePath));
        if (filePath.endsWith(".json")) {
            return parseJson(content);
        } else if (filePath.endsWith(".yaml") || filePath.endsWith("yml")) {
            return parseYaml(content);
        } else {
            throw new Exception("Unsupported file format");
        }
    }

    private static Map<String, Object> parseJson(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(content, Map.class);
    }

    private static Map<String, Object> parseYaml(String content) throws Exception {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(content, Map.class);
    }
}
