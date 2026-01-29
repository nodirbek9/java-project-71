package hexlet.code;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        var map1 = getData(readJsonToString(filePath1));
        var map2 = getData(readJsonToString(filePath2));
        var resultMap = new ArrayList<String>();
        String result = "{"+"\n";
        var entries1 = map1.keySet();
        var entries2 = map2.keySet();
        for (var entry1 : entries1) {
            if (!resultMap.contains(entry1) && entry1.length()>1) {
                resultMap.add(entry1);
            }
        }
        for (var entry2 : entries2) {
            if (!resultMap.contains(entry2) && entry2.length()>1) {
                resultMap.add(entry2);
            }
        }
        Collections.sort(resultMap);
        for (var key : resultMap) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    result += "   "+key + ": " + map1.get(key)+"\n";
                } else {
                    result += " - " + key + ": " + map1.get(key) + "\n" +
                              " + " + key + ": " + map2.get(key)+"\n";
                }

            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                result += " - " + key + ": " + map1.get(key) + "\n";

            } else if (map2.containsKey(key) && !map1.containsKey(key)) {
                result += " + " + key + ": " + map2.get(key) + "\n";
            }
        }
        return result + "}";
    }

    public static Map<String, Object> getData(String content) throws Exception {
        return parse(content);
    }

    public static String readJsonToString(String filePath) throws Exception {

        return Files.readString(Paths.get(filePath));
    }
    public static Map<String, Object> parse(String json) throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(json, Map.class);
    }
}
