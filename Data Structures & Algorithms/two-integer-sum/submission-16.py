class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        # I initially think of ordering but what we could use is a hashmap to store past values as we traverse the array.

        # First lets handle the case where nums has less than 2 values
        if len(nums) < 2:
            return False

        # Lets now create a hashmap where we will keep the values that we traverse
        history = {}
        # now we need to iterate through the nums [index, number]
        for index, number in enumerate(nums):
            # What value are we at? How much is left to the target?
            goal = target - number
            # check if goal existes in history
            if goal in history:
                # If it does exist then we have a match
                return [history[goal], index]
            # if the match doesnt exist we have to add the current number to history and move on
            history[number] = index

        # In case nothing works return an empty brackets
        return []