# Problem

- [문제 링크](https://leetcode.com/problems/min-stack/)

<br>

*__Easy__* 문제입니다.

스택을 구현한건데 나머지는 다 똑같고 `getMin()` 함수를 호출할 때 스택에 있는 최소값을 구하면 됩니다.

<br><br>

# Solution

변수는 현재 최소값을 저장하는 `minimum` 변수 하나만을 선언합니다.

만약에 `push(x)` 가 호출되었을 때 `x > minimum` 조건이라면 최소값이 변하지 않기 때문에 그대로 스택에 푸시합니다.

만약 `x <= minimum` 조건이라면 `minimum` 을 `x` 값으로 갱신해주어야 합니다.

하지만 위에서 언급했듯이 `x` 가 `pop()` 되었을 때 스택에 남아있는 숫자 중 최소값을 알 수 있는 방법이 없습니다.

따라서 `x` 를 `push` 하기 전에 `minimum` 값을 먼저 `push` 합니다.

그러면 `minimum (이전 최소값)` 위에 `x (현재 최소값)` 가 쌓이는 상태가 되겠죠.

`pop()` 을 호출할 때 `pop` 되는 값이 최소값 `pop() == minimum` 이라면 `minimum` 바로 밑에 있는 값은 바로 이전 최소값이기 때문에

해당 값을 빼내어 `minimum` 을 갱신해주면 됩니다.

<br><br>

# Java Code

```java
class MinStack {
    Stack<Integer> stack = new Stack();
    int minimum = Integer.MAX_VALUE;

    public void push(int x) {
        if (x <= minimum) {
            stack.push(minimum);
            minimum = x;
        }
        
        stack.push(x);
    }
    
    public void pop() {
        if (stack.pop() == minimum) {
            minimum = stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minimum;
    }
}
```