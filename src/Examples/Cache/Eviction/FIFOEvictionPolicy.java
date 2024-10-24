package Examples.Cache.Eviction;

import java.util.Queue;
import java.util.LinkedList;

public class FIFOEvictionPolicy<K> implements EvictionPolicy<K> {
    // using linked list as a queue
    private Queue<K> queue = new LinkedList<>();

    @Override
    public void keyAccessed(K key) {
        queue.add(key);
    }

    @Override
    public K evictKey() {
        K keyToEvict = queue.poll();
        
        System.out.println("key to evict: " + keyToEvict);

        return keyToEvict;
    }

    @Override
    public void deleteKey(K key) {
        queue.remove(key);
    }
}
