# Problem

- [문제 링크](https://leetcode.com/problems/happy-number/)

<br>

숫자가 주어지면 `(각 자리수)^2` 의 합이 최종적으로 1 이 되는지 아닌지 판단하는 문제입니다.

<br><br>

# Solution 1

각 자리수로 나누고 제곱한 다음에 전부 합하는 건 `getDigitSum` 함수를 따로 만들었습니다.

그리고 `n == 1` 이 될 때까지 반복하면서 지나온 숫자는 `Set` 에 담습니다.

`n` 을 새롭게 계산했을 때 `Set` 에 존재하는 숫자라면 영원히 1 이 될 수 없다는 뜻입니다.

<br><br>

# Java Code 1

```java
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        
        while (n != 1) {
            n = getDigitSum(n);
            
            if (set.contains(n)) {
                return false;
            }
            
            set.add(n);
        }

        return true;
    }
    
    private int getDigitSum(int number) {
        int sum = 0;
        
        while (number != 0) {
            sum += (number % 10) * (number % 10);
            number /= 10;
        }
        
        return sum;
    }
}
```

<br><br>

# Solution 2

`n == 1` 이 되지 않는 경우는 무한 반복하는 경우입니다.

무한 반복한다는건 싸이클을 형성한다는 뜻이고 싸이클을 찾는지만 확인하면 됩니다.

**_Floyd's Cycle Detection Algorithm_** 을 이용하여 싸이클을 찾을 수 있습니다.

<br><br>

# Java Code 2

```java
class Solution {
    public boolean isHappy(int n) {
        int slow = getDigitSum(n);
        int fast = getDigitSum(getDigitSum(n));
                               
        while (fast != 1 && slow != 1) {
            if (fast == slow) {
                return false;
            }
            
            slow = getDigitSum(slow);
            fast = getDigitSum(getDigitSum(fast));
        }

        return true;
    }
    
    private int getDigitSum(int number) {
        int sum = 0;
        
        while (number != 0) {
            sum += (number % 10) * (number % 10);
            number /= 10;
        }
        
        return sum;
    }
}
```