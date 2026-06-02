class Solution:
    def isValid(self, s: str) -> bool:
                # lets create a stack
        stack = list()
        # hashmap with close to open relation
        close_open_map = {
            "}" : "{",
            ")" : "(",
            "]" : "["
        }

        #{}[]()
        # {}
        for character in s:
            #We need to check if the current character is closing a bracket
            if character in close_open_map:
                if stack and stack[-1] == close_open_map[character]:
                    stack.pop() #pop the last one
                else:
                    return False
                #by default the current character wont be adde to the list
            else:
                stack.append(character)

        return True if not stack else False