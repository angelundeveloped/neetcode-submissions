class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26];

        for (int i = 0; i < s.length(); i += 1) {
            charCount[s.charAt(i) - 'a'] += 1;
            charCount[t.charAt(i) - 'a'] -= 1;

        }

        for (int val : charCount) {
            if (val != 0) {
                return false;
            }
        }

        return true;

    }
}
