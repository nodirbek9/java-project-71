package hexlet.code;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class DiffBuilder {

    public static Diff build(Map<String, Object> map1, Map<String, Object> map2) {
        Diff diff = new Diff();
        var entries1 = map1.keySet();
        var entries2 = map2.keySet();
        Set<String> allKeys = new TreeSet<>(map1.keySet());
        allKeys.addAll(map2.keySet());

        for (String key : allKeys) {
            boolean has1 = map1.containsKey(key) && !key.isEmpty();
            boolean has2 = map2.containsKey(key) && !key.isEmpty();

            Object value1 = map1.get(key);
            Object value2 = map2.get(key);

            if (has1 && has2) {
                if (Objects.equals(value1, value2)) {
                    diff.addUnchanged(key, value1);
                } else {
                    diff.addChanged(key, value1, value2);
                }
            } else if (has1) {
                diff.addRemoved(key, value1);
            } else {
                diff.addAdded(key, value2);
            }
        }
        return diff;
    }
}
