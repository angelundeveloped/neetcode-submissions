class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        depthFirstSearch(nums, 0, subset, result);
        return result;

    }

    private void depthFirstSearch(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        depthFirstSearch(nums, i + 1, subset, result);
        subset.remove(subset.size() - 1);
        depthFirstSearch(nums, i + 1, subset, result);
    }
}