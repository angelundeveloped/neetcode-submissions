class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Create a hashmap where we can store all each value value: index
        Map<Integer, Integer> prev = new HashMap<>();
        // iterate through the nums array
        // We need an index to indicate where we are
        for (int index = 0; index < nums.length; index++) {
            // what is the current difference between the target and the current nums value
            int diff = target - nums[index];
            // check if diff is in the map
            if (prev.containsKey(diff)) {
                return new int[] {prev.get(diff), index};
            }
            // if not found add the current nums value and index
            prev.put(nums[index], index);
        }
        return new int[2];
    }
}
