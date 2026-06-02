class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
                # Array of arrayw where each inner array is the full row
        # Rules element in each inner array are a set of 1-9
        # also the eleemtns in array[index] are also a set of 1-90
        # left_top pointer [0,0], right_bottom point [2,2]
        # we can use a sort of cordiante system to identify where we are
        # We need a hashset so that no duplicate values can be added

        #varaibles
        board_length = len(board)
        # hashset of rows
        rows = defaultdict(set)
        # hashset of columns
        columns = defaultdict(set)
        # hashset of squares
        squares = defaultdict(set)

        # iterate through the board
        for x in range(0, board_length, 1):
            for y in range(0, board_length, 1):
                # We can travesers the whole board
                # Check if x,y coordinate value is valid
                # We have to check current row, current column and current square
                if board[x][y] == ".":
                    continue
                if (
                    #condition 1 x=1 [1 5 6 8 8]
                    board[x][y] in rows[x] or
                    board[x][y] in columns[y] or
                    # condition 9, 3x3 0,0 2,2
                    board[x][y] in squares[(x//3, y//3)]
                ):
                    return False
                #after each pass update the values at position
                rows[x].add(board[x][y])
                columns[y].add(board[x][y])
                squares[(x//3,y//3)].add(board[x][y])
        return True

# memory complexity is O(n) for the rows+ O(n) for columsn+ O(n) for squares = O(3n) = O(n). However since we have fixed n values then it os O(1)
# time complexity is n x n = n squared. Becasue you to do a pass through the board through rows times columsn