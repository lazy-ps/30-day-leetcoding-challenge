# Problem

- [문제 링크](https://leetcode.com/problems/single-number/)

<br>

난이도 *__Easy__* 문제입니다.

배열이 주어졌을 때 한 숫자를 제외한 나머지는 모두 한 쌍으로 존재합니다.

중복되지 않는 숫자를 찾아서 리턴하는 문제입니다.

단, 추가 조건에 추가적인 메모리 사용 없이 `O(n)` 에 풀어보라고 나와있습니다.

<br><br>

# Solution

`O(n)` 에 푸는건 쉽게 할 수 있습니다.

`Map, Set, Array` 등을 활용하여 중복된 숫자를 체크하면서 `for` 문 한번만 돌면 됩니다.

변수 하나로 풀려면 문제의 조건을 잘 봐야 합니다.

**중복된 숫자는 무조건 한쌍**입니다.

그리고 비트 연산자 중에 `XOR` 연산이라는 게 있습니다.

`XOR` 은 두 비트가 같으면 0 다르면 1 을 리턴해줍니다.

그리고 이 `XOR` 에는 **같은 숫자에 대해 `XOR` 연산을 두번하면 자기 자신이 된다는 특징**이 있습니다.

위에 강조한 두 가지를 이용하여 쉽게 풀 수 있습니다.

<br><br>

# Java Code 1

```java
class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        
        for (int num : nums) {
            result ^= num;
        }
        
        return result;
    }
}
```

<br><br>

# Java Code 2

```java
// without using extra memory
class Solution {
    public int singleNumber(int[] nums) {
        for (int i=1; i<nums.length; i++) {
            nums[0] ^= nums[i];
        }
        
        return nums[0];
    }
}
```
