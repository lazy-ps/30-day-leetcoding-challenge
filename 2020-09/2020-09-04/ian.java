class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> lefts = new HashMap<>();
        Map<Character, Integer> rights = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if (lefts.containsKey(ch)) {
                continue;
            }
            lefts.put(ch, i);
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            char ch = S.charAt(i);
            if (rights.containsKey(ch)) {
                continue;
            }
            rights.put(ch, i);
        }

        List<Integer> answers = new ArrayList<>();
        int count = 0;
        int currentLength = 0;
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);
            if(lefts.get(ch) == i) {
                count += 1;
            }

            if(rights.get(ch) == i) {
                count -= 1;
            }

            currentLength += 1;

            if(count == 0) {
                answers.add(currentLength);
                currentLength = 0;
            }
        }

        return answers;
    }
}
