package hexlet.code;

import java.util.ArrayList;
import java.util.List;

public class Diff {

    private final List<DiffNode> nodes = new ArrayList<>();

    public void addAdded(String key, Object value) {
        nodes.add(new DiffNode(key, Status.ADDED, null, value));
    }

    public void addRemoved(String key, Object value) {
        nodes.add(new DiffNode(key, Status.REMOVED, value, null));
    }

    public void addUnchanged(String key, Object value) {
        nodes.add(new DiffNode(key, Status.UNCHANGED, value, value));
    }

    public void addChanged(String key, Object oldValue, Object newValue) {
        nodes.add(new DiffNode(key, Status.CHANGED, oldValue, newValue));
    }

    public List<DiffNode> getNodes() {
        return nodes;
    }
}
