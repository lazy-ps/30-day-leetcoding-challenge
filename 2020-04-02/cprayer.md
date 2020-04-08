# Problem

- [문제 링크](https://leetcode.com/problems/happy-number/)

주어진 숫자 n이 happy number인지, 아닌지를 판별하는 문제입니다.

happy number는 다음과 같은 프로세스를 반복합니다.

1. 각 자리 수의 제곱 값을 모두 더한다.
2. 1이 된 경우 happy number이다. 그렇지 않은 경우 1의 과정을 반복한다.
3. 1의 과정을 반복하며 cycle이 반복되는 경우 happy number가 아니다.

숫자 n은 32비트 int에 속합니다. 이는 대략적으로 2*10^9이므로 최대 9가지의 자리수를 가집니다.

한 자리수에서 가장 큰 수를 만들면 81이므로 처음 n을 제외한 다음 숫자부터는 81 * 9 범위 안에 속하게 됩니다.

따라서 사이클이 생겨도 81 * 9을 초과하지 않으므로 해당 과정을 반복하여 1로 수렴하지 않는 사이클을 찾으면 됩니다.

```golang
func getNextNumber(num int) int {
    nextNum := 0
    for num > 0 {
        m := num % 10
        nextNum += m * m
        num /= 10
    }

    return nextNum
}

func isHappy(n int) bool {
    visited := make(map[int]bool)

    for visited[n] != true {
        visited[n] = true
        n = getNextNumber(n)
    }

    return n == 1
}
```
