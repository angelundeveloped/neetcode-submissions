class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // For the final result
        Map<String, List<String>> anagramMap = new HashMap<>();
        // we need to iterate through each word
        for (String word : strs) {
            // create a new fixed 26 size array
            int[] counts = new int[26];
            //iterate through the characters in the string
            for (char character : word.toCharArray()) {
                // create the counts array
                counts[character - 'a'] = counts[character - 'a'] + 1;
            }
            //create the current counts key to string
            String countsStringKey = Arrays.toString(counts);
            // add the counts in string for to the anagramMap
            List<String> currentList = anagramMap.computeIfAbsent(
                countsStringKey,
                k -> new ArrayList<>()
            );
            currentList.add(word);
        }
        return new ArrayList<>(anagramMap.values());
    }
}
