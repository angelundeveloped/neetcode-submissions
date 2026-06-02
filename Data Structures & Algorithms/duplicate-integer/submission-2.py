class Solution:
    def hasDuplicate(self, nums: List[int]) -> bool:
        # create a dictionary to keep track of what numbers have been used.
        record = set()

        for num in nums:
            if num in record:
                return True
            record.add(num)
        return False