class Solution:
    def wordPattern(self, pattern: str, str: str) -> bool:
        str_list = str.split()
        
        if len(str_list) != len(pattern):
            return False
        
        mapping = {}
        str_set = set()
        for idx, p in enumerate(pattern):
            if p not in mapping:
                if str_list[idx] in str_set:
                    return False
                mapping[p] = str_list[idx]
                str_set.add(str_list[idx])
            elif mapping[p] != str_list[idx]:
                return False
            
        return True