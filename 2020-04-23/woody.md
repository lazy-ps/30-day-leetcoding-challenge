# Problem

- [문제 링크](https://leetcode.com/problems/bitwise-and-of-numbers-range/)

<br>

`[m, n]` 이 주어지면 `m, m+1, ..., n-1, n` 까지의 숫자를 전부 `AND` 연산한 결과를 구하는 문제입니다.

<br><br>

# Solution 1

생각해낸 아이디어는 주어진 수를 이진수로 변환했을 때 길이가 다른부분은 전부 0 이 된다는 것입니다.

예를 들어 `m` 이 `10101` 이고 `n` 이 `11110101011110` 이라면 n 에서 맨 뒤의 `11110` 을 제외한 나머지 앞자리는 전부 필요가 없습니다.

결국 계속 `AND` 연산을 하면서 0 이 될 것이기 때문에 계산할 필요가 없습니다.

그래서 `m` 을 이진변환 했을 때의 길이 5 를 구한 후 `m` 의 이진수 길이가 6 이 될때까지만 비교하면 됩니다.

<br><br>

# Java Code 1

```java
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        String binaryM = Integer.toBinaryString(m);
        int len = (int) Math.pow(2, binaryM.length() - 1);
        int res = m;
        
        while (len-- > 0 && m < n) {
            if (res == 0) return 0;
            res &= ++m;
        }
        
        return res;
    }
}
```

<br><br><br>

# Solution 2

두번째는 **Discuss** 에서 봤습니다.

기본적인 아이디어는 비트의 각 자리는 `m -> n` 으로 가는동안 한번이라도 0 을 만나면 영원히 0 이라는 점을 활용한 겁니다.

`m` 과 `n` 이 같아지는 순간까지 오른쪽으로 쉬프트 한 뒤, 같아지는 순간에 지금까지 쉬프트 했던 걸 왼쪽으로 쉬프트 해주면 답이 됩니다.

간단한 예를 들어보겠습니다.

`m` 은 이진수 `110100` 이고 `n` 은 이진수 `111010` 입니다.

```html
110100
110101
110110
110111
111000
111001
111010
```

`m ~ n` 까지 순서대로 증가시키면 위와 같은데, 맨 앞의 두 비트 `11` 을 제외하고는 전부 한번씩 0 을 거칩니다.

따라서 오른쪽으로 쉬프트 네번을 하며 `m` 과 `n` 이 `11` 이 될때, 지금까지 오른쪽으로 쉬프트 했던 만큼 다시 왼쪽으로 쉬프트 네번을 하면 최종적으로 `110000` 이 답이 됩니다.

<br><br>

# Java Code 2

```java
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int shift = 0;
        
        while (m != n) {
            m >>= 1;
            n >>= 1;
            shift++;
        }
        
        return m << shift;
    }
}
```