# Problem

- [문제 링크](https://leetcode.com/problems/last-stone-weight/)

<br>

배열에서 가장 무거운 돌 두개를 골라 서로 부딪힙니다.

두 돌의 무개가 같으면 둘다 사라집니다.

`y` 돌의 무게가 `x` 돌보다 크다면 `y-x` 돌 하나만 남습니다.

이런식으로 최대 하나의 돌만 남을때까지 모든 돌을 부딪힌 후 남은 돌의 무게를 `return` 하면 됩니다.

<br><br>

# Solution 1

우선순위 큐를 사용합니다.

일반적으로 `PriorityQueue<Integer>` 는 작은 숫자가 먼저 나오기 때문에 `Collections.reverseOrder()` 를 사용하여 큰 수가 먼저 나오도록 선언합니다.

우선순위 큐가 비거나 `size` 가 1 이 될 때까지 두번씩 `poll` 하며 돌의 무게를 비교합니다.

둘이 같은 경우는 사라져야 하기 때문에 `pq` 에 추가하지 않습니다.

만약 돌의 무게가 다르다면 먼저 뽑은 `y` 가 더 큰 돌이므로 `y-x` 값을 `pq` 에 넣습니다.

`pq` 에 하나만 남는다면 무게를 리턴하고 아니면 0 을 리턴합니다.

<br><br>

# Java Code 1

```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int stone : stones) {
            pq.add(stone);
        }
        
        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            
            if (y != x) {
                pq.add(y - x);
            }
        }
        
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
```

<br><br><br>

# Solution 2

정렬을 사용합니다.

`stones[i-1] = stones[i] - stones[i-1]` 값으로 돌을 계속 쪼개고 정렬합니다.

`stones[0]` 값이 마지막에 남은 돌입니다.

만약 남는 돌이 없더라도 0 을 리턴하기 때문에 상관없습니다.

<br><br>

# Java Code 2

```java
class Solution {
    public int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        
        for (int i = stones.length - 1; i > 0; i--) {
            stones[i-1] = stones[i] - stones[i-1];
            Arrays.sort(stones);
        }
        
        return stones[0];
    }
}
```