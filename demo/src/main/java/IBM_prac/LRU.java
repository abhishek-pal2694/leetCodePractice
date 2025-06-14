package IBM_prac;

import java.util.LinkedHashMap;
import java.util.Map;

class runLRU{

    public static void main(String[] args) {
        LRU<Integer,Integer> cache = new LRU<>(2);
        cache.put(1,20);
        cache.put(2,90);
        cache.put(3,49);

        System.out.println(cache);
    }
}
public class LRU<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    public LRU(int capacity){
        super(capacity,0.8f,true);
        this.capacity = capacity;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<K,V> entry){
        return capacity < size();
    }
}
