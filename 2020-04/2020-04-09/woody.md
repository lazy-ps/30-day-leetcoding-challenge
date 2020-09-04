# Problem

- [문제 링크](https://leetcode.com/problems/backspace-string-compare/)

<br>

`#` 은 백스페이스를 나타냅니다.

문자열이 주어지면 백스페이스 처리를 모두 한 후의 두 문자열이 같은지 비교하는 문제입니다.

<br><br>

# Solution

`O(N)` 시간복잡도는 `Stack` 을 사용하면 쉽게 할 수 있습니다.

`O(1)` 공간복잡도는 완성된 문자열을 따로 담지 않고 바로 처리해야합니다.

문자열의 뒤에서부터 진행하며 `#` 을 만날때마다 `index` 를 앞으로 더 밀어주면 됩니다.

`#` 은 의미없는 기호고, 문자 하나를 지워야 하기 때문에 `#` 하나당 `del` 카운트를 2개씩 증가시킵니다.

`S` 와 `T` 각각 다음 인덱스를 구해서 모두 일치한다면 `true` 를 반환합니다.

만약 두 문자열의 길이가 다르거나, 문자가 하나라도 다르다면 `false` 를 반환하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int s = S.length() - 1;
        int t = T.length() - 1;
        
        while (true) {
            s = getNextIndex(S, s);
            t = getNextIndex(T, t);
        
            if (s < 0 && t < 0) return true;
            if (s < 0 || t < 0 ) return false;
            if (S.charAt(s) != T.charAt(t)) return false;
            
            s--;
            t--;
        }
    }
    
    private int getNextIndex(String str, int current) {
        if (current < 0 || str.charAt(current) != '#') return current;
        
        int del = 2;
        
        while (del-- > 0) {
            current--;

            if (current >= 0 && str.charAt(current) == '#') {
                del += 2;
            }
        }
        
        return current;
    }
}
```