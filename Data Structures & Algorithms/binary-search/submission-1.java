class Solution {
    public int search(int[] nums, int target) {
        int result = -1;

        // key points, orderd.
        // we need a left, middle, and right pointer
        int left = 0;
        int right = nums.length - 1;
        // 1 2 3 5 6. target 5, result 4
        // 2 l=0, r=0, m = 0+0/2=0
        while (left <= right) {
            // get the current middle index
            int middle = ((left + right) / 2);
            // get the current value at middle index
            int current_value = nums[middle];
            System.out.printf("Debug: %d\n", current_value);
            // check if the current value is what wee need greater than or less than target
            if (current_value == target) {
                result = middle;
                return result;
            // what if the current value is less than target
            } else if (current_value < target) {
                //update left pointer
                left = middle + 1;
            } else { // for when current value > target
                right = middle - 1;
            }
        }
        return result;
    }
}
