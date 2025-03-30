package Examples.Cache.Eviction;

public interface EvictionPolicy<K> {
    // keyAccessed updates the underlying data structures to maintain order and
    // efficient eviction (Should be called with GET/SET ops)
    // It's required to implement LRU and LFU strategies
    void keyAccessed(K key);

    // deleteKey notifies eviction policy to delete a key from data structures
    // maintained for eviction (Should be called with DELETE ops)
    void deleteKey(K key);
    
    // evictKey evicts the key based on policy when cache is full
    // return type is K so that caller can remove the key from it's data structure
    K evictKey();
}
