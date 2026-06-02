class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row_len = len(matrix[0])
        col_len = len(matrix)
        
        top_index = 0
        bottom_index = col_len - 1
        # loop through columns and check first value
        while (top_index <= bottom_index):
            #what row are we at?
            current_row = (top_index + bottom_index) // 2
            # check if target is in the current row by checking row edges
            if target >= matrix[current_row][0] and target <= matrix[current_row][-1]:
                # the target is in this row, break and keep this row
                break
            elif target < matrix[current_row][0]:
                bottom_index = current_row - 1
            else:
                top_index = current_row + 1
        
        # next iteration
        left_index = 0
        right_index = row_len - 1

        while (left_index <= right_index):
            #update the middle index
            middle_index = (left_index + right_index) // 2
            current_value = matrix[current_row][middle_index]
            #check if we found target
            if current_value == target:
                return True
            elif current_value < target:
                left_index = middle_index + 1
            else:
                right_index = middle_index - 1

        return False