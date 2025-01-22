//Module 6 - Hashing
//Problem 4 - Day45 - Intersection of Two arrays with Duplicate Elements

class Solution {
    public ArrayList<Integer> intersectionWithDuplicates(int[] a, int[] b) {
        // Create a HashSet to store unique elements of array 'a'
        HashSet<Integer> setA = new HashSet<>();
        for (int num : a) {
            setA.add(num);
        }

        // Create another HashSet for storing the intersection result
        HashSet<Integer> intersection = new HashSet<>();
        for (int num : b) {
            // If the element of array 'b' is present in 'setA', add it to the intersection
            if (setA.contains(num)) {
                intersection.add(num);
            }
        }

        // Convert the intersection set to an ArrayList
        return new ArrayList<>(intersection);
    }
}
