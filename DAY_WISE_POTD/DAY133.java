//Module 16 - Greedy
//Problem 1 - Day133 - Minimum Platforms

class pair {
    int first;
    char second;
    
    pair(int key1, char key2) {
        this.first = key1;
        this.second = key2;
    }
}

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    public static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n = arr.length;
        
        ArrayList<pair> order = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            order.add(new pair(arr[i], 'a'));
            order.add(new pair(dep[i], 'd'));
        }
        
        Collections.sort(order,
                         new Comparator<pair>() {
                             @Override
                             public int compare(pair p1, pair p2) {
                                 if(p1.first == p2.first)
                                    return new Character(p1.second).compareTo(
                                        new Character(p2.second));
                                 return p1.first - p2.first;
                             }
                         }
        );
        
        int result = 1;
        int plat_needed = 0;
        for(int i = 0; i < order.size(); i++) {
            pair p = order.get(i);
            
            if(p.second == 'a')
                plat_needed++;
            else
                plat_needed--;
            
            if(plat_needed > result) result = plat_needed;
        }
        
        return result;
    }
}
