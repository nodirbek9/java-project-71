package hexlet.code;

import java.util.ArrayList;
import java.util.Collections;

public class Differ {
    public static String generate(String filePath1, String filePath2) throws Exception {
        var map1 = Parser.parse(filePath1);
        var map2 = Parser.parse(filePath2);
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
}
