public class TrieNode {
    // Every node has a character in it and points to its children
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean endOfWord = false;
}

class PrefixTree {
    // When working with trees we need to create a root
    private TrieNode root;

    public PrefixTree() {
         // Initialize the root
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root; // initialize teh root
        for (char character : word.toCharArray()) {
            current.children.putIfAbsent(character, new TrieNode());
            current = current.children.get(character);
        }
        current.endOfWord = true; // since we have traversed the word

    }

    public boolean search(String word) {
        // we establish the current node
        TrieNode current = root;
        for (char character : word.toCharArray()) {
            // we need to check that the whole word is there
            // for each character we check if it is in the prefixtree
            if (!current.children.containsKey(character)) {
                // if we find that the current character is not in the current node we return
                return false;
            }
            // update the current node
            current = current.children.get(character);
        }
        // we return if the current node is the end of a word or not
        return current.endOfWord;

    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (char character : prefix.toCharArray()) {
            if (!current.children.containsKey(character)) {
                return false;
            }
            // update the current node
            current = current.children.get(character);
        }
        return true;

    }
}
