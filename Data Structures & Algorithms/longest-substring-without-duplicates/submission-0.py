class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
         # 'seen_chars' acts as the current window (a set for O(1) lookups)
        seen_chars = set() 
        
        # 'left' is the start of the current window
        left = 0
        
        # 'max_len' stores the longest length found so far
        max_len = 0 
        
        # 'right' is the pointer that expands the window 
        for right in range(len(s)):
            # 1. Handle Duplicates: While the character at 'right' is already in the window
            while s[right] in seen_chars:
                # Remove the leftmost character from the window 
                seen_chars.remove(s[left])
                # Shrink the window by moving the left pointer right
                left += 1
            
            # 2. Expand Window: Add the new, non-repeating character to the window
            seen_chars.add(s[right])
            
            # 3. Update Max Length: The current window length is right - left + 1
            # Note: len(seen_chars) is also equivalent to right - left + 1
            max_len = max(max_len, right - left + 1)
            
        return max_len