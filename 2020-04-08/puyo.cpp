/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* middleNode(ListNode* head) {
        int len = 0;
        ListNode* iter = head;
        while(iter)
        {
            len++;
            iter = iter->next;
        }
        
        int m = len / 2;
        while(m)
        {
            head = head->next;
            m--;
        }
        return head;
    }
};
