# Problem

문자열 `s`와 움직이는 방향과 횟수가 담긴 `shift` 배열이 주어졌을 때 최종 문자열을 리턴하는 문제입니다.

<br><br>

# Solution

`Deque` 자료구조를 사용하여 문제에서 제시하는 대로 구현하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public String stringShift(String s, int[][] shift) {
        Deque<Character> deque = new ArrayDeque<>();
        
        for (char c : s.toCharArray()) {
            deque.addLast(c);
        }
        
        for (int[] shi : shift) {
            int direction = shi[0];
            int amount = shi[1];
            
            for (int i = 0; i < amount; i++) {
                if (direction == 0) {
                    deque.addLast(deque.pollFirst());
                } else {
                    deque.addFirst(deque.pollLast());
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }

        return sb.toString();
    }
}
```
