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

정해는 **_Double Linked List_** 를 만드는 겁니다.

`HashMap<Integer, Node>` 를 선언하여 `key` 에 대해서 `Node` 를 저장해둡니다.

`head` 와 `tail` 로 관리하며 새로운 노드를 추가하는 `vodi addNodeAfterHead(Node node)` 메소드는 항상 `head` 다음에 노드를 삽입합니다.

`map` 의 크기가 `capacity` 를 넘어간다면 `tail` 바로 위에 있는 `tail.prev` 노드를 삭제하면 됩니다.

<br><br>

# Java Code 2

```java
class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    Map<Integer, Node> map = new HashMap<>();;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    final int CAPACITY;
    
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        
        if (node == null) {
            return -1;
        }
        
        updateCache(node);
        
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = map.get(key);
        
        if (node != null) {
            node.value = value;
            updateCache(node);
            return;
        }
        
        Node newNode = new Node(key, value);
        addNodeAfterHead(newNode);
        map.put(key, newNode);

        if (map.size() > CAPACITY) {
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }
    }
    
    private void updateCache(Node node) {
        removeNode(node);
        addNodeAfterHead(node);
    }
    
    private void addNodeAfterHead(Node node) {
        node.next = head.next;
        head.next.prev = node;
        
        node.prev = head;
        head.next = node;
    }
    
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
```