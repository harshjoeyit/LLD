package Examples.Cache.Eviction;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> { 
    // first element is the Least Recently used 
    private Set<K> keys = new LinkedHashSet<>();;

    @Override
    public void keyAccessed(K key) {
        keys.remove(key);
        // Add the key to the last (most recently used).
        keys.add(key);
    }

    @Override
    public K evictKey() {
        Iterator<K> iterator = keys.iterator();
        K keyToEvict = iterator.next();     // Get the least recently used key (first key)
        iterator.remove();                  // or alternatively - deleteKey(keyToEvict)
        
        System.out.println("key to remove: " + keyToEvict);
        
        return keyToEvict;
    }

    @Override
    public void deleteKey(K key) {
        keys.remove(key);
    }
}
