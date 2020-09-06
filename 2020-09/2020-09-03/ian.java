class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = 1; i < len; i++) {
            if(len % i != 0) {
                continue;
            }

            String sub = s.substring(0, i);
            if(s.equals(sub.repeat(len / i))) {
                return true;
            }
        }
        return false;
    }
}

