class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
                # inputs are strings
        # first thing that occurs to me is to order the strings
        # but lets use a hashmap
        
        # if they have different lenghts then they are not anagrams
        if len(s) != len(t):
            return False
        # Let create dictionaries for each string
        s_dict, t_dict = {}, {}

        #  We know they are the same length so lets just iterate through range of one string
        for index in range(len(s)):
            # add 1 to the value of the key value map
            s_dict[s[index]] = 1 + s_dict.get(s[index], 0)
            t_dict[t[index]] = 1 + t_dict.get(t[index], 0)
        # Now that we have the loop lets compare the dictionaries
        for key in s_dict:
            if s_dict[key] != t_dict.get(key, 0):
                return False
        
        # Everything matched
        return True