class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        seen = {}
        complement = 0

        for index in range(0, len(nums)):
            complement = target - nums[index]
            if complement in seen:
                return [min(index, seen[complement]), max(index, seen[complement])]
            seen[nums[index]] = index

