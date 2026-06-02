class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
                # sorted non decreaseing goes up from lower to higher
        # lets try to pinpoint the anser coming in from the edges.
        left_pointer = 0
        right_pointer = len(numbers) - 1
        
        # run the loop while the sum is not target and while left and right pointer
        # dont overlap
        while (left_pointer < right_pointer):
            current_sum = numbers[left_pointer] + numbers[right_pointer]
            if current_sum == target:
                return [left_pointer + 1, right_pointer + 1]

            elif current_sum > target:
                right_pointer -= 1
            
            else:
                left_pointer += 1