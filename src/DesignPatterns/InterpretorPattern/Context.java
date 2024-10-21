package DesignPatterns.InterpretorPattern;

import java.util.Map;
import java.util.HashMap;

public class Context {
    private static Map<String, Integer> contextMap = new HashMap<>();

    public int get(String val) {
        if (contextMap.containsKey(val)) {
            return contextMap.get(val);
        }
        // default 
        return 0;
    } 

    public void set(String val, Integer actualValue) {
        contextMap.put(val, actualValue);
    }
}
