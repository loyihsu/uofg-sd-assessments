package multiset;

import java.util.*;

public class Context {
    Map<String, MultiSet> map = new HashMap<>();

    public void add(String key, List<String> context) {
        MultiSet set = map.get(key.toLowerCase());
        if (set == null) {
            set = new MultiSet();
            map.put(key.toLowerCase(), set);
        }
        set.add(context);
    }

    public Set<String> getKeys() {
        return map.keySet();
    }

    public int size() {
        return map.size();
    }

    public MultiSet get(String key) {
        return map.get(key.toLowerCase());
    }

    public void put(String str, MultiSet set) {
        map.put(str, set);
    }
}
