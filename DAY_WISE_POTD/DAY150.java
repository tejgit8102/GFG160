//Module 17 - Graph
//Problem 13 - Day150 - Account Merge

class DisjointSet {
    ArrayList<Integer> parent, size;
    
    DisjointSet(int n){
        parent = new ArrayList<>(Collections.nCopies(n, 0));
        size = new ArrayList<>(Collections.nCopies(n, 1));
        
        for(int i = 0; i < n; i++) {
            parent.set(i, i);
        }
    }
    
    int findParent(int node) {
        if(node == parent.get(node)) {
            return node;
        }
        
        parent.set(node, findParent(parent.get(node)));
        return parent.get(node);
    }
    
    void unionBySize(int u, int v) {
        
        int par_u = findParent(u);
        int par_v = findParent(v);
        
        if(par_u == par_v) {
            return;
        }
        if(size.get(par_u) < size.get(par_v)) {
            parent.set(par_u, par_v);
            size.set(par_v, size.get(par_v) + size.get(par_u));
        } else {
            parent.set(par_v, par_u);
            size.set(par_u, size.get(par_u) + size.get(par_v));
        }
    }
}
class Solution {
    static ArrayList<ArrayList<String>> accountsMerge(
        ArrayList<ArrayList<String>> arr) {
        HashMap<String, Integer> mails = new HashMap<>();
        int n = arr.size();
        DisjointSet ds = new DisjointSet(n);
        
        for(int i = 0; i < n; i++) {
            for(int j = 1; j < arr.get(i).size(); j++) {
                String mail = arr.get(i).get(j);
                if(!mails.containsKey(mail)) {
                    mails.put(mail, i);
                } else {
                    ds.unionBySize(i, mails.get(mail));
                }
            }
        }
        
        ArrayList<ArrayList<String>> mergedMails = 
            new ArrayList<>(Collections.nCopies(n, null));
        for(int i = 0; i < n; i++) {
            mergedMails.set(i, new ArrayList<>());
        }
        for(Map.Entry<String, Integer> it : mails.entrySet()) {
            int node = ds.findParent(it.getValue());
            String mail = it.getKey();
            mergedMails.get(node).add(mail);
        }
        
        ArrayList<ArrayList<String>> accounts = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(mergedMails.get(i).isEmpty()) {
                continue;
            }
            ArrayList<String> temp = new ArrayList<>();
            temp.add(arr.get(i).get(0));
            temp.addAll(mergedMails.get(i));
            accounts.add(temp);
        }
        
        return accounts;
       
    }
}
