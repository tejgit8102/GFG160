//Problem - Subsets

class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int arr[]) {
        // code here
        Arrays.sort(arr);
        
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i = 0; i < (1 << n); i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                subset.add(arr[j]);
            }
            
        }
        
        res.add(subset);
        
        
    }
    
    res.sort((a, b) -> {
        int len = Math.min(a.size(), b.size());
        for(int i = 0; i < len; i++) {
            int cmp = Integer.compare(a.get(i), b.get(i));
            if(cmp != 0) return cmp;
        }
        return Integer.compare(a.size(), b.size());
    });
    
    return res;
  }
}
