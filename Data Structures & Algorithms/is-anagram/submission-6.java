class Solution {
    public boolean isAnagram(String s, String t) {
        // Edge cases
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sCounts = new HashMap<>();
        Map<Character, Integer> tCounts = new HashMap<>();

        // iterate through lenght of string
        for (int index = 0; index < s.length(); index++) {
            // Get current char
            char sChar = s.charAt(index);
            char tChar = t.charAt(index);
            // Update the hash maps

            sCounts.put(sChar, sCounts.getOrDefault(sChar,0) + 1);
            tCounts.put(tChar, tCounts.getOrDefault(tChar,0) + 1);
        }
        return sCounts.equals(tCounts);
    }
}
