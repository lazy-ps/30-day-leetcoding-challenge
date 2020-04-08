class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        group = {}
        OFFSET_A = ord('a')
        for word in strs:
            char_count = [0] * 26
            for c in word:
                char_count[ord(c) - OFFSET_A] += 1
            
            char_hash = '#'.join(map(str, char_count))
            group.setdefault(char_hash, []).append(word)
            
        return group.values()
