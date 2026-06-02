class KthLargest {

    // We need a Heap and in java that is a PriorityQueue
    private PriorityQueue<Integer> minHeap;
    private int k; // global k variable

    public KthLargest(int k, int[] nums) {
        this.k = k; // we assign th k value
        this.minHeap = new PriorityQueue<>(); // we create a new queue
        for (int num : nums) {  // iterate through each number int in nums
            minHeap.offer(num); // add each number to the minHeap this creates a heap of nums size
            if (minHeap.size() > k) {
                minHeap.poll(); // we drop the smallest 
            }
        }
    }
    
    public int add(int val) {
        minHeap.offer(val);  // add/offer the value to the heap
        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
        
        
    }
}
