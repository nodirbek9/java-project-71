package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public final class Parser {
    static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    static final ObjectMapper YAML_MAPPER = new ObjectMapper(new YAMLFactory());

    private Parser() {
    }
    public static Map<String, Object> parse(String content, String format) throws Exception {
        return switch (format) {
            case "json" -> JSON_MAPPER.readValue(content, Map.class);
            case "yaml", "yml" -> YAML_MAPPER.readValue(content, Map.class);
            default -> throw new IllegalArgumentException("Unsupported format: " + format);
        };
    }
}
