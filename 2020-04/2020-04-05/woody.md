# Problem

- [문제 링크](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/)

<br>

물건의 가격은 매일 바뀌고, 우리는 각 날의 물건 가격을 알 수 있습니다.

이 정보를 갖고 물건을 사고 팔 때 얻을 수 있는 최대한의 이득을 구하는 문제입니다.

<br><br>

# Solution

물건은 판 날에도 바로 물건을 살 수 있기 때문에 팔아서 이득이 되는 순간 즉시 팔면 됩니다.

오늘 물건을 산 후 내일과 비교했을 때

내일 가격이 더 비싸다면 오늘 물건을 팔고 내일 물건을 바로 삽니다. (항상 팔 수 있는 물건을 소지)

내일 가격이 더 싸다면 오늘 물건 산 걸 취소하고 내일 물건을 삽니다. (최소값 유지)

결국 내일 가격에 상관없이 항상 물건을 갱신해줘야 합니다.

따라서 `min`, `max` 값을 따로 저장할 필요 없이 `prices[i]` 와 `prices[i+1]` 만 비교하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
                
        for (int i = prices.length-2; i >= 0; i--) {
            if (prices[i+1] > prices[i]) {
                sum += prices[i+1] - prices[i];
            }
        }
        
        return sum;
    }
}
```