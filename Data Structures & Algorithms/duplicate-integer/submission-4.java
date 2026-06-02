class Solution {
    public boolean hasDuplicate(int[] nums) {
        // We need a sett
        Set<Integer> dupes = new HashSet<>();

        // Iterate through the loop to see if there are loop
        for (int number : nums) {
            // Check if the currrent number is in the dupes hash set
            if (dupes.contains(number)) {
                // it does contain it so return 
                return true;
            }
            // update the set
            dupes.add(number);
        }
        return false;
    }
}