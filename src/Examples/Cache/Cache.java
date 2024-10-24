package Examples.Cache;

import Examples.Cache.Eviction.EvictionPolicy;

import java.util.Map;
import java.util.HashMap;

public class Cache<K, V> {
    private final int capacity;
    private final Map<K, V> map;
    private final EvictionPolicy<K> evictionPolicy;

    public Cache(int capacity, EvictionPolicy<K> evictionPolicy) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.evictionPolicy = evictionPolicy;
    }

    public V get(K key) {
        if (!map.containsKey(key)) {
            // Key not found
            return null;
        }

        // Notify policy that key was accessed.
        evictionPolicy.keyAccessed(key);
        
        return map.get(key);
    }

    public void set(K key, V value) {
        if (this.isFull()) {
            K keyToEvict = evictionPolicy.evictKey();
            map.remove(keyToEvict);
        }

        // put in map
        map.put(key, value);

        // Notify policy that key was accessed.
        evictionPolicy.keyAccessed(key);
    }

    public void delete(K key) {
        if (!map.containsKey(key)) {
            // Key not found
            return;
        }

        this.map.remove(key);
        evictionPolicy.deleteKey(key);
    }

    // private method 
    private boolean isFull() {
        return this.map.size() == this.capacity;
    }
}
