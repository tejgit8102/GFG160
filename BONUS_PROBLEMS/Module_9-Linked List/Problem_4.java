//Problem - LFU cache

class LFUCache {
    
    private final int capacity;
    private int minFreq;
    private final Map<Integer, Integer> keyToValue;
    private final Map<Integer, Integer> keyToFreq;
    private final Map<Integer, LinkedHashSet<Integer>> freqToKeys;
    
    public LFUCache(int cap) {
        // code here
        capacity = cap;
        minFreq = 0;
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        // code here
        if(!keyToValue.containsKey(key)){
            return -1;
        }
        
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        
        freqToKeys.get(freq).remove(key);
        
        if(freqToKeys.get(freq).isEmpty() && freq == minFreq){
            minFreq++;
        }
        
        freqToKeys.computeIfAbsent(freq + 1, k -> new LinkedHashSet<>()).add(key);
        
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        // code here
        if(capacity == 0){
            return;
        }
        
        if(keyToValue.containsKey(key)){
            keyToValue.put(key, value);
            get(key);
            return;
        }
        
        if(keyToValue.size() == capacity){
            int lfuKey = freqToKeys.get(minFreq).iterator().next();
            freqToKeys.get(minFreq).remove(lfuKey);
            
            keyToValue.remove(lfuKey);
            keyToFreq.remove(lfuKey);
        }
        
        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        
        minFreq = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
