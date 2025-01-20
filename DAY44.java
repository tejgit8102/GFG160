//Module 6 - Hashing
//Problem 3 - Day44 - Find All Triplets with Zero Sum

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Set to handle duplicates
        Set<List<Integer>> resSet = new HashSet<>();
        int n = arr.length;
        Map<Integer, List<int[]>> mp = new HashMap<>();

        // Store sum of all the pairs with their indices
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                if (!mp.containsKey(sum)) {
                    mp.put(sum, new ArrayList<>());
                }
                mp.get(sum).add(new int[] {i, j});
            }
        }

        for (int i = 0; i < n; i++) {
            // Find remaining value to get zero sum
            int rem = -arr[i];
            if (mp.containsKey(rem)) {
                List<int[]> pairs = mp.get(rem);
                for (int[] p : pairs) {
                    // Ensure no two indices are same in triplet
                    if (p[0] != i && p[1] != i) {
                        List<Integer> curr = Arrays.asList(i, p[0], p[1]);
                        Collections.sort(curr);
                        resSet.add(curr);
                    }
                }
            }
        }

        return new ArrayList<>(resSet);
    }
}
