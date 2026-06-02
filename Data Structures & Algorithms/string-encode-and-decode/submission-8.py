from typing import List

class Solution:
    """Encode and decode strings using a length-prefixing method"""

    def encode(self, strs: List[str]) -> str:
        """
        Encodes a list of strings into a single string.
        Format: [length][delimiter][string]...
        """
        # Note: Your encode method is already correct and efficient.
        result = ""
        delimiter = "$" # Using a character unlikely to appear in the strings
        for string in strs:
            # The length of the string is prefixed, followed by the delimiter.
            result += str(len(string)) + delimiter + string
        return result

    def decode(self, s: str) -> List[str]:
        """
        Decodes a string based on the length indicator and delimiter.
        This uses a two-pointer approach for O(N) time complexity.
        """
        delimiter = "$"
        result = []
        # 'i' will act as the starting point for the *length* of the current word
        i = 0 
        
        # We iterate as long as we have characters left to read
        while i < len(s):
            j = i # 'j' will search for the delimiter
            
            # Step 1: Find the delimiter to determine the length of the length indicator
            # We search forward until we hit the delimiter.
            # FIX: Check the *character* at index j, not the index converted to a string.
            while s[j] != delimiter:
                j += 1
                
            # Step 2: Extract the length of the upcoming word
            # The length indicator is between index i (start) and j (delimiter)
            # The segment s[i:j] gives the length as a string (e.g., "5", "10")
            current_word_length = int(s[i:j])
            
            # Step 3: Identify the start and end of the actual word
            word_start_index = j + 1  # Word starts right after the delimiter
            word_end_index = word_start_index + current_word_length
            
            # Step 4: Extract and append the word
            word = s[word_start_index:word_end_index]
            result.append(word)
            
            # Step 5: Advance the main pointer 'i' to the beginning of the *next* length indicator
            # The next length indicator starts immediately after the end of the current word.
            i = word_end_index 

        return result