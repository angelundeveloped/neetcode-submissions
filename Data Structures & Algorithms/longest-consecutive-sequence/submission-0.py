class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        # now that we know how this actually works
        
        #variables
        longest_consecutive_sequence = 0
        # set can only have 1 unique isntance of a value
        nums_set = set(nums)

        for number in nums:
            #check if this is the first number in a sequence
            if (number - 1) not in nums_set:
                #this is the first number in the sequence
                current_sequence_length = 0
                # check if there is a number to the right
                while (number + current_sequence_length) in nums_set:
                    #increase the length while there is a number to the right
                    current_sequence_length += 1
                longest_consecutive_sequence = max(longest_consecutive_sequence, current_sequence_length)
        return longest_consecutive_sequence