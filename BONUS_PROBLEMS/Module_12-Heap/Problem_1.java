//Problem - Top K Frequent in Array

class Solution {
    
    static class Compare implements Comparator<int[]> {
        public int compare(int[] p1, int[] p2) {
            
            if(p1[1] == p2[1]) return Integer.compare(p2[0], p1[0]);
            
            return Integer.compare(p2[1], p1[1]);
        }
    }
    static ArrayList<Integer> topKFrequent(int[] arr, int k) {
        // Your code here
        int n = arr.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++) mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        
        ArrayList<int[]> freq = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : mp.entrySet())
            freq.add(new int[] {entry.getKey(), entry.getValue()});
        
        freq.sort(new Compare());
        
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(freq.get(i)[0]);
        }
        
        return res;
    }
}
