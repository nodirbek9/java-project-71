package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        var map_1 = getData(readJsonToString(filePath1));
        var map_2 = getData(readJsonToString(filePath2));
        var result_sort = new ArrayList<String>();
        String result = "{"+"\n";
        var entries1 = map_1.keySet();
        var entries2 = map_2.keySet();
        for (var entry1 : entries1) {
            if (!result_sort.contains(entry1)) {
                result_sort.add(entry1);
            }
        }
        for (var entry2 : entries2) {
            if (!result_sort.contains(entry2)) {
                result_sort.add(entry2);
            }
        }
        Collections.sort(result_sort);
        for (var key : result_sort) {
            if (map_1.containsKey(key) && map_2.containsKey(key)) {
                if (map_1.get(key).equals(map_2.get(key))) {
                    result += "   "+key + ": " + map_1.get(key)+"\n";
                } else {
                    result += " - " + key + ": " + map_1.get(key) + "\n" +
                              " + " + key + ": " + map_2.get(key)+"\n";
                }

            } else if (map_1.containsKey(key) && !map_2.containsKey(key)) {
                result += " - " + key + ": " + map_1.get(key) + "\n";

            } else if (map_2.containsKey(key) && !map_1.containsKey(key)) {
                result += " + " + key + ": " + map_2.get(key) + "\n";
            }
        }
        return result + "}";
    }

    public static Map<String, Object> getData(String content) throws Exception {
        return parse(content);
    }

    public static String readJsonToString(String filePath) throws Exception {

        String content = Files.readString(Paths.get(filePath));
        return content;
    }
    public static Map<String, Object> parse(String json) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Map.class);
    }
}
