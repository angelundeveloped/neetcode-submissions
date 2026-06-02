class Solution:
    def isPalindrome(self, s: str) -> bool:
                # lets work on the most obviouse steps and remove non alphanmeric characters
        # and convert to upper case

        #but if we do that that would requrei us to do multiple passes when we could
        # probably just 
        left_pointer = 0
        right_pointer = len(s) - 1

        # We need to check every character
        # assurances that there is some character of at least
        while (left_pointer < right_pointer):
            # We need to check that the current character is a letter
            while not s[left_pointer].isalnum() and left_pointer < right_pointer:
                #increase left_pointer value
                left_pointer += 1
            # same for the right pointer
            while not s[right_pointer].isalnum() and left_pointer < right_pointer:
                # decrease right pointer
                right_pointer -= 1
            # now that we are at an alpha numeric character we need to compare them
            if(s[left_pointer].lower() != s[right_pointer].lower()):
                return False
            # increas the pointer
            left_pointer += 1
            right_pointer -= 1

        return True