class Solution {
    public boolean isValid(String s) {
                //lets check first that the input is valid or even
        if (s.length() % 2 != 0) {
            //odd
            return false;
        }
        // we need to map the pairs
        Map<Character, Character> pairings = new HashMap<>();
        pairings.put('}', '{');
        pairings.put(']', '[');
        pairings.put(')', '(');
        // we need a place to store the pairs stack (deque)
        Deque<Character> stack = new ArrayDeque<>();

        // We need to traverse the string
        for (char bracket : s.toCharArray()) {
            // if the current character is a closing bracket
            if (pairings.containsKey(bracket)) {
                // check if the stack is not empty and has the corresponding character
                if(!stack.isEmpty() && stack.peek() == pairings.get(bracket)) {
                    // pop the top stack and dont add the current bracket
                    stack.pop();
                } else {
                    //the closeing brackets doesnt coincide with the top stack element
                    return false;
                }
            } else {
                // this current bracket is an opening one
                stack.push(bracket);
            }
        }
        
        return stack.isEmpty();
    }
}
