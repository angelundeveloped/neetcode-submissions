class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # check that they are not empty
        if not s and not t:
            return True # both string are null
        
        if not s or not t:
            return False # either s or t are null, therfore they are not the same

        # we could sort first then compare character per character but id rather use extra space.
        # s_sorted = sorted(t)
        # t_sorted = sorted(t)

        # lets get the length of the string
        t_len = len(t)
        s_len = len(s)
        #assuming that all characters are considered.
        if t_len != s_len:
            return False
        
                # lets use a map to keep track of all the characters in the string
        s_map = {}
        t_map = {}

        for char in s:
            if char in s_map:
                s_map[char] += 1
            else:
                s_map[char] = 1

        for char in t:
            if char in t_map:
                t_map[char] += 1
            else:
                t_map[char] = 1

        if t_map == s_map:
            return True
        
        return False