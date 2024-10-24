package Examples.Cache.Eviction;

public interface EvictionPolicy<K> {
    // updates the underlying data structures to maintain order and efficient eviction
    void keyAccessed(K key);    
    
    // evicts the key based on policy when cache is full
    // return type is K so that caller can remove the key from it's data structure
    K evictKey();               

    // to notify eviction policy to delete a key
    void deleteKey(K key);
}
