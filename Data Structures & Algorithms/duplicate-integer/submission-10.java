class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<Integer>();

        for(int n : nums) {
            if (seen.add(n) == false) {
                return true;
            }
        }
        return false;
    }
}