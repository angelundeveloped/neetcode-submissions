class Solution:
    def search(self, nums: List[int], target: int) -> int:
                # create a left and right pointer
        left_pointer = 0
        right_pointer = len(nums) - 1

        #iteerate using binary search
        while (left_pointer <= right_pointer):
            #keep searching for the indicated value
            #get middle index
            middle_index = (left_pointer + right_pointer) // 2
            #check the current value based on middle index
            current_value = nums[middle_index]
            #then if the current value is greater than target, move left
            if current_value < target:
                #move left pointer to 1 greater then middle index
                left_pointer = middle_index + 1
            #then if the current value is less than target, move right
            elif current_value > target:
                right_pointer = middle_index - 1
            #if the current value is equal to the target then return index
            else:
                return middle_index

        #retur -1 if this fails
        return -1