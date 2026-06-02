class Solution {

    public String encode(List<String> strs) {
        StringBuilder concatString = new StringBuilder();
        for (String word : strs) {
            concatString.append(word.length()).append("#").append(word);
        }
        return concatString.toString();
    }

    public List<String> decode(String str) {

        List<String> result = new ArrayList<>();

        int index = 0;

        while (index < str.length()){

            int helper = index;
            while (str.charAt(helper) != '#') {
                helper++;
            }
            int length = Integer.parseInt(str.substring(index,helper));
            index = helper + 1;
            helper = index + length;
            String substring = str.substring(index, helper);
            result.add(substring);
            index = helper;
        }
        return result;
    }
}
