# Problem

- [문제 링크](https://leetcode.com/problems/repeated-substring-pattern/)

<br>

Easy 문제입니다.

문자열 `s` 가 특정 `substring` 의 반복으로만 이루어진 경우를 찾는 문제입니다.

<br><br>

# Solution

`substring` 을 구한 후 반복해서 붙인 다음 `s` 와 비교하면 됩니다.

순서대로 나열하면 다음과 같습니다.

1. `substring` 의 길이를 `s` 의 절반부터 시작해서 1 까지 확인한다. (절반보다 길면 `substring` 이 반복될 수가 없음)
2. `s` 의 길이가 `substring` 의 길이와 나누어 떨어지는 지 확인한다.
3. `substring` 을 반복해서 붙인 다음 `s` 와 비교한다.
4. 일치하는게 나올 때까지 확인한다.

<br><br>

# Java Code

```java
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        for (int len = s.length() / 2; len > 0; len--) {
            if (s.length() % len != 0) {
                continue;
            }
            
            int repeatCount = s.length() / len;
            String pattern = s.substring(0, len);
            StringBuilder sb = new StringBuilder();
            
            while (repeatCount-- > 0) {
                sb.append(pattern);
            }
            
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        
        return false;
    }
}
```
