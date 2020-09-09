class Solution:
    def compareVersion(self, version1: str, version2: str) -> int:
        v1 = list(map(int, version1.split('.')))
        v2 = list(map(int, version2.split('.')))
        
        v1_len = len(v1)
        v2_len = len(v2)
        
        for i in range(min(v1_len, v2_len)):
            if v1[i] > v2[i]:
                return 1
            elif v1[i] < v2[i]:
                return -1
        
        if v1_len == v2_len:
            return 0
        elif v1_len > v2_len:
            return 1 if any(v1[v2_len:]) else 0
        elif v1_len < v2_len:
            return -1 if any(v2[v1_len:]) else 0
