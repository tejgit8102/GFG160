//Module 12 - Heap
//Problem 4 - Day98 - Merge K sorted linked lists

class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        // code here
        ArrayList<Double> result = new ArrayList<>();
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        
        for(int num : arr) {
            if(leftHeap.isEmpty() || num <= leftHeap.peek()) {
                leftHeap.add(num);
            } else {
                rightHeap.add(num);
            }
            
            if(leftHeap.size() > rightHeap.size() + 1) {
                rightHeap.add(leftHeap.poll());
            } else if (rightHeap.size() > leftHeap.size()) {
                leftHeap.add(rightHeap.poll());
            }
            
            if(leftHeap.size() > rightHeap.size()) {
                result.add((double) leftHeap.peek());
            } else {
                result.add((leftHeap.peek() + rightHeap.peek()) / 2.0);
            }
        }
        return result;
    }
}
