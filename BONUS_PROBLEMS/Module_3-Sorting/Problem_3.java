//Problem - Form the Largest Number

class Solution {
    public String findLargest(int[] arr) {
        // Convert integers to strings for easy comparison
        String[] strArr = Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);

        // Custom comparator: compare concatenated strings
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest number is "0", return "0"
        if (strArr[0].equals("0")) {
            return "0";
        }

        // Concatenate the sorted strings to form the result
        StringBuilder largestNumber = new StringBuilder();
        for (String num : strArr) {
            largestNumber.append(num);
        }

        return largestNumber.toString();
    }
}
