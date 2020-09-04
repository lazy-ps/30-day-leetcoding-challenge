# Problem

![07-counting-elements](../images/07-counting-elements.png)

<br>

배열 안에 있는 임의의 수 `n` 에 대해서 `n+1` 가 배열 안에 존재한다면 그 갯수를 전부 카운트해서 응답하는 문제입니다.

<br><br>

# Solution 1

`HashSet` 을 선언하여 배열 안의 값을 전부 담아둡니다.

다시 `for` 문을 돌며 `num + 1` 값이 `Set` 에 존재한다면 갯수를 세줍니다.

<br><br>

# Java Code 1

```java
class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        
        for (int num : arr) {
            set.add(num);
        }
        
        int sum = 0;
        
        for (int num : arr) {
            if (set.contains(num + 1)) {
                sum++;
            }
        }
        
        return sum;
    }
}
```

<br><br><br>

# Solution 2

`0 <= arr[i] <= 1000` 조건을 이용하여 배열의 각 숫자들의 갯수를 담아두고 더해주는 방법도 있습니다.

`counting[i+1] > 0` 이라면 `i+1` 인 숫자가 존재한다는 뜻이므로 `i` 의 갯수인 `counting[i]` 를 전부 더해줍니다.

<br><br>

# Java Code 2

```java
class Solution {
    public int countElements(int[] arr) {
        int[] counting = new int[1002];
        
        for (int num : arr) {
            counting[num]++;
        }
        
        int sum = 0;
        
        for (int i=0; i<=1000; i++) {
            if (counting[i+1] > 0) {
                sum += counting[i];
            }
        }
        
        return sum;
    }
}
```