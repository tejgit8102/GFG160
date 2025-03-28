//Problem - Buy Stock with Transaction Fee

class Solution {
    public int maxProfit(int arr[], int k) {
        // Code here
        int n = arr.length;
        
        int noStock = 0, inHand = 0;
        
        if(n == 0) return 0;
        
        for(int ind = n - 1; ind >= 0; ind--) {
            int newNoStock, newInHand;
            
            newNoStock = Math.max(noStock, inHand - arr[ind]);
            
            newInHand = Math.max(inHand, arr[ind] - k + noStock);
            
            noStock = newNoStock;
            inHand = newInHand;
        }
        
        return noStock;
        
    }
}
