# Problem

- [문제 링크](https://leetcode.com/problems/middle-of-the-linked-list/)

<br>

`Singly Linked List` 가 주어지면 리스트의 가장 중간부터 끝까지를 리턴하면 됩니다.

만약 `List` 의 길이가 짝수라면 뒤의 절반을 리턴합니다.

<br><br>

# Solution

간단하게 *__two pointer__* 로 해결할 수 있습니다.

`slow` 는 한번, `fast` 는 두번 씩 전진하면 `fast` 가 끝에 도달했을 때 `slow` 의 위치가 `List` 의 중간입니다.

<br><br>

# Java Code

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
}
```