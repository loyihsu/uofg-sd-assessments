package multiset;

import java.util.*;

public class MultiSet {
    Map<String, SetElement> map;
    public MultiSet() {
        map = new HashMap<>();
    }

    public void put(String key, int freq) {
        map.put(key, new SetElement(key, freq));
    }

    public void add(List<String> strings) {
        for (String string: strings) {
            SetElement element = map.get(string);
            if (element == null) {
                element = new SetElement(string);
                map.put(string, element);
            }
            element.update();
        }
    }

    public List<SetElement> top(int count) {
        List<SetElement> values = new ArrayList<>(map.values());
        Collections.sort(values);
        return values.subList(0, count);
    }

    public float norm() {
        float norm = 0;
        for (SetElement x: map.values()) {
            norm += x.freq*x.freq;
        }
        return (float)Math.sqrt(norm);
    }

    public float sim(MultiSet that) {
        float sim = 0;
        for (String w: this.map.keySet()) {
            // check if w matches with the other sparsevec
            SetElement that_w = that.map.get(w);
            if (that_w == null)
                continue;
            sim += this.map.get(w).freq * that_w.freq;
        }
        return sim/(this.norm() * that.norm());
    }

    @Override
    public String toString() {
        String output = "";
        for (String key: map.keySet()) {
            output += "" + map.get(key).toOutputString() + "; ";
        }
        return output;
    }
}