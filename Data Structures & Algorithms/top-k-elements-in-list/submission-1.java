class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       // --- 1. COUNT FREQUENCIES (O(N) Time) ---
        // Map: Key = Number (Integer), Value = Frequency Count (Integer)
        Map<Integer, Integer> count = new HashMap<>();
        
        // Populate the count map using the getOrDefault trick for clean incrementing.
        for (int n : nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }
        
        // --- 2. INITIALIZE FREQUENCY BUCKETS (O(N) Time) ---
        
        // Array of Lists (The Buckets): Index is the frequency, Value is a list of numbers 
        // that appeared that many times. Size is N+1 because max frequency is nums.length.
        List<Integer>[] freq = new List[nums.length + 1];

        // Initialize every bucket position with an empty ArrayList to prevent NullPointerExceptions.
        for (int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }
        
        // --- 3. FILL THE BUCKETS (O(N) Time) ---
        
        // Iterate through all unique numbers and their counts from the HashMap.
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int number = entry.getKey();
            int frequency = entry.getValue();
            
            // Place the number into the bucket corresponding to its frequency.
            // Example: If '1' appeared 3 times, it goes into freq[3].
            freq[frequency].add(number);
        }

        // --- 4. COLLECT TOP K RESULTS (O(N) Time) ---
        
        // Final result array of size k.
        int[] res = new int[k];
        int index = 0; // Pointer to fill the result array.
        
        // Start iterating from the highest possible frequency bucket (freq.length - 1)
        // down to 1. Stop if we've found k elements (index < k).
        for (int i = freq.length - 1; i > 0 && index < k; i--) {
            
            // Check if the current frequency bucket is empty (it might be null, but we initialized them).
            // We iterate through all numbers in this bucket (all have the same frequency 'i').
            for (int n : freq[i]) {
                // Add the current number to the result array.
                res[index++] = n;
                
                // Check if the result array is full (we've found exactly k elements).
                if (index == k) {
                    return res; // Return the result immediately for an early exit.
                }
            }
        }
        
        // This line is technically reached if the loop finishes without filling 'res', 
        // though the constraints usually guarantee k elements exist.
        return res; 
    }
}
