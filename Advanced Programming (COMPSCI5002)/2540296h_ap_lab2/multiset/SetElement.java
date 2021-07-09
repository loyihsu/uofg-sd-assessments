package multiset;

public class SetElement implements Comparable<SetElement> {
    String key;
    int freq = 0;
    SetElement(String key) {
        this.key = key;
    }
    SetElement(String key, int freq) {
        this.key = key;
        this.freq = freq;
    }
    void update() {
        freq++;
    }

    public String toOutputString() {
        return key + "," + freq;
    }

    @Override
    public String toString() {
        return "(" +
                "key='" + key + '\'' +
                ", freq=" + freq +
                ")\n";
    }

    @Override
    public int compareTo(SetElement o) {
        return -1 * Integer.compare(freq, o.freq);
    }
}
