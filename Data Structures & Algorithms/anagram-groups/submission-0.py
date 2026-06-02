class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
                # Right away I am thinking of a hashmap.
        # What i would do is create a map where the key is a hasmap of the each word
        # this would work because each hasmap would be a key=char, value= # of instances
        # then we could traverse each string and then check each hashmap to the keys and if it exist we could just add the word but hashmaps cannot be keys in python.
        # So we could try to make the keys into a vector. If they 
        anagrams_list = defaultdict(list) # formato {[],[],...[]}
        
        
        # iterate through each word
        for word in strs:
            #Since there are only lowercase characters we can use a scaler or array it has to be created new for each word
            word_scaler = [0] * 26  # Where 0=a and z=25
            print(word_scaler)
            #iterate through each character in the word
            for character in word:    
                #update the word scaler at poistion character
                word_scaler[ord(character) - ord("a")] += 1 # convert to integer value
                # now we have a scaler for the current word we need to see if we add it to anagram list
            anagrams_list[tuple(word_scaler)].append(word)

        return list(anagrams_list.values())