class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        complement = 0

        for index in range(0, len(nums)):
            complement = target - nums[index]
            if complement in seen:
                return [seen[complement], index]
            seen[nums[index]] = index

