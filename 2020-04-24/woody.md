# Problem

- [문제 링크](https://leetcode.com/problems/lru-cache/)

<br>

LRU Cache 를 구현하면 됩니다.

cache 는 capacity 가 정해져 있습니다.

`get`, `put` 메소드를 구현하는데 `O(1)` 시간복잡도가 되도록 구현해야합니다.

<br><br>

# Solution 1

자바에 있는 `LinkedHashMap` 을 사용하면 쉽게 구현할 수 있습니다.

`LinkedHashMap` 는 선언할 때 `accessOrder` 라는 변수를 받는데, 이 값을 `true` 로 세팅하면 `LinkedHashMap` 의 순서가 접근 빈도에 따라 바뀝니다.

가장 최근에 접근한 `Key` 데이터가 `LinkedHashMap` 의 가장 뒤에 위치하게 됩니다.

그러므로 `put` 메소드에서 데이터를 넣은 후 `map` 의 크기가 `capacity` 를 초과한다면 가장 사용되지 않은 데이터를 지우면 됩니다.

가장 사용되지 않은 데이터는 `map` 의 가장 맨 앞에 있는 값이므로 해당 값을 구해서 `remove` 를 해주면 됩니다.

+)

아래에 있는 코드는 **Discuss** 에서 본건데 `LinkedHashMap` 을 상속받아서 구현했습니다.

`removeEldestEntry` 는 가장 오래된 데이터를 지우는 메소드인데 `Override` 하여 조건을 변경하였습니다.

**LeetCode** 에서 이렇게 상속받아서 구현할 수 있는지 몰랐는데 처음 알게되어서 신기합니다.

<br><br>

# Java Code 1

```java
class LRUCache {
    Map<Integer, Integer> map;
    final int CAPACITY;
    
    public LRUCache(int capacity) {
        map = new LinkedHashMap<>(capacity, 0.75f, true);
        CAPACITY = capacity;
    }
    
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        map.put(key, value);
        
        if (map.size() > CAPACITY) {
            int leastUsedKey = map.keySet().iterator().next();
            map.remove(leastUsedKey);
        }
    }
}

class LRUCache extends LinkedHashMap<Integer, Integer> {
    private int capacity;
    
    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }
    
    public int get(int key) {
        return super.getOrDefault(key, -1);
    }
    
    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }
}
```

<br><br><br>

# Solution 2


<br><br>

# Java Code 2

```java

```