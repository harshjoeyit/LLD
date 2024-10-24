package Examples.Cache;

import Examples.Cache.Eviction.EvictionPolicy;
import Examples.Cache.Eviction.FIFOEvictionPolicy;
import Examples.Cache.Eviction.LRUEvictionPolicy;


public class Main {
    public static void main() {
        EvictionPolicy<String> lruPolicy = new LRUEvictionPolicy<>();
        EvictionPolicy<String> fifoPolicy = new FIFOEvictionPolicy<>();

        // Cache<String, Integer> cache = new Cache<>(3, lruPolicy);
        Cache<String, Integer> cache = new Cache<>(3, fifoPolicy);

        cache.set("Doe", 20);
        cache.set("John", 15);
        cache.set("Harshit", 10);
        
        System.out.println(cache.get("John"));

        cache.set("Marty", 25);
    }
}
