class Solution:
    def getHint(self, secret: str, guess: str) -> str:
        A, B = 0, 0
        a_cnt, b_cnt = {}, {}
        
        for i in range(len(secret)):
            if secret[i] == guess[i]:
                A += 1
            else:
                a_cnt[secret[i]] = a_cnt.get(secret[i], 0) + 1
                b_cnt[guess[i]] = b_cnt.get(guess[i], 0) + 1
        
        B = sum([min(a_cnt[k], b_cnt.get(k, 0)) for k in a_cnt.keys()])
        
        return f'{A}A{B}B'