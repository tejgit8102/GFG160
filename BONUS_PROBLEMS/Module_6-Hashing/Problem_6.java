//Problem - Group Shifted String

class Solution {
    public ArrayList<ArrayList<String>> groupShiftedString(String[] arr) {
        // code here
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String str : arr){
            String key = getShiftPattern(str);
            
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }
        
        return new ArrayList<>(map.values());
    }
    
    private String getShiftPattern(String str){
        if(str.length() == 1) return "single";
        
        StringBuilder key = new StringBuilder();
        
        for(int i = 1; i < str.length(); i++){
            int diff = str.charAt(i) - str.charAt(i - 1);
            if(diff < 0) diff += 26;
            key.append(diff).append(",");
        }
        
        return key.toString();
    }
}
