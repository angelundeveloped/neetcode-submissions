class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        # First we see that the nums is only ints
        # I assume it can be positive and negatives
        # Ordered and unordered
        
        if nums is None or len(nums) < 1:
            return False
        
        # create a set because we know there are no duplicates in sets
        dupes = set()
        # We want to iterate through each value of nums
        for number in nums:
            # As we iterate we check if the current number is in dupes
            if number in dupes:
            # We return true if it does exist
                return True
        # As we iterate we add it to the set of dupes
            dupes.add(number)

        return False