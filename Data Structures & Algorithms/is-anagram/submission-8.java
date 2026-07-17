class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (int sChar = 0; sChar < s.length(); sChar += 1) {
            charCount[s.charAt(sChar) - 'a'] += 1;
        }

        for (int tChar = 0; tChar < s.length(); tChar += 1) {
            charCount[t.charAt(tChar) - 'a'] -= 1;
        }

        for (int val : charCount) {
            if (val != 0) {
                return false;
            }
        }

        return true;

    }
}
