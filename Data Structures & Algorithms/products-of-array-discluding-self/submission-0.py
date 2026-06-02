class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
                # First thoughts is i want to iterate through the list of numbers
        # multiply them and just add them to the result
        # But these limits are making me need to apply different log
        # first pass [1 1 2 6]  O(n)
        # backward pass [24 12 4 1] O(n)
        # result [24 12 8 6]
        length_nums = len(nums)
        result = [1] * length_nums

        #forward pass to calculate pre values
        current_value = 1 #
        for index in range(0, length_nums, 1):
            # update the result array
            result[index] = current_value
            # update the current value of the pres sums
            current_value = current_value * nums[index]
        # Backward pass to calculate post values
        current_value = 1
        # 0 1 2 3  index
        #[1 1 2 6] pre result
        #[24 12 8 6] result
        #
        #[1 2 3 4] nums
        for index in range(length_nums - 1, -1, -1):
            # update the result arry
            result[index] = current_value * result[index]
            # update current value for backwards pass
            current_value = current_value * nums[index]
            #24
        return result