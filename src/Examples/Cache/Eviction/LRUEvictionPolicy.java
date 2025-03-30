package Examples.Cache.Eviction;

import java.util.Set;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class LRUEvictionPolicy<K> implements EvictionPolicy<K> { 
    // first element is the Least Recently used 
    // last element id the Most Recently used
    private Set<K> keys = new LinkedHashSet<>();;

    @Override
    public void keyAccessed(K key) {
        // Remove the key from current position and add to the last 
        // (most recently used).
        keys.remove(key);
        keys.add(key);
    }

    @Override
    public K evictKey() {
        Iterator<K> iterator = keys.iterator();
        // Get the least recently used key (first key)
        // 
        // Iterator is conceptually positioned before the first element in the
        // collection. Calling next() advances the iterator to the first 
        // element and returns that element.
        K keyToEvict = iterator.next();
        
        // Remove the key
        iterator.remove();

        // Alternatively we could call deleteKey(keyToEvict)
        
        System.out.println("key to remove: " + keyToEvict);
        
        return keyToEvict;
    }

    @Override
    public void deleteKey(K key) {
        keys.remove(key);
    }
}
