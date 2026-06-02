class Solution {
    public int lastStoneWeight(int[] stones) {
                PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int x;
        int y; // y>=x

        // we need to add the weights to the stack
        for (int stoneWeight : stones) {
            maxHeap.offer(stoneWeight);
        }
        // How long do we need to run this? untill there is 1 or no stones left
        while(maxHeap.size() > 1) {
            // get top two values
            y = maxHeap.poll();
            x = maxHeap.poll();
            // compare the stones
            int newValue = y - x;
            if (newValue > 0) {
                // then return the rock to the maxHeap.
                maxHeap.offer(newValue);
            }
        }
        // once the loop ends check if there is 1 winner left
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();

        // Memory of O(n), time complexity of O(n) + O(n log n)
    }
}
