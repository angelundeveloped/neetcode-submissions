class Solution {
    public boolean isPalindrome(String s) {
        // we are going to need two pointer
        int left = 0;
        int right = s.length() - 1;
        // convert the string to an arrya
        char[] stringArray = s.toCharArray();

        while (left < right) {

            // check if the current values at left and right pointers are alphanumeric
            while (!Character.isLetterOrDigit(stringArray[left]) && left < right) {
                // increment until we find a letter or digit
                left += 1;
            }
            
            while (!Character.isLetterOrDigit(stringArray[right]) && left < right) {
                // decrease until we find a letter or digit
                right -= 1;
            }
            // in theory the pointers are at matching characters if not
            if (Character.toLowerCase(stringArray[left]) != Character.toLowerCase(stringArray[right])) {
                return false;
            }
            // increment and decrement the pointers.
            left += 1;
            right -= 1;

        }
        return true;
    }
}
