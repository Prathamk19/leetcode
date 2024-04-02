package leet.code.challenges;

public class LinkedListAddNumbers
{
    public class ListNode
    {
        int val;
        ListNode next;

        ListNode()
        {
        }

        ListNode(int val)
        {
            this.val = val;
        }

        ListNode(int val, ListNode next)
        {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbersR(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null)
            return new ListNode(0);
        ListNode dummyHead = new ListNode();
        ListNode p = l1, q = l2, node = dummyHead;
        int carry = 0;
        while (p != null || q != null)
        {
            int pVal = p != null ? p.val : 0;
            int qVal = q != null ? q.val : 0;
            int sum = pVal + qVal + carry;
            carry = sum >= 10 ? 1 : 0;
            sum = sum >= 10 ? sum % 10 : sum;
            node.next = new ListNode(sum);
            node = node.next;
            if (p != null)
                p = p.next != null ? p.next : null;
            if (q != null)
                q = q.next != null ? q.next : null;
        }
        if (carry > 0)
            node.next = new ListNode(carry);
        return dummyHead.next;
    }
    
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        return addTwoNumbers(l1, l2, 0);
    }
    
    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int carry)
    {
        if (l1 == null && l2 == null)
        {
            if (carry > 0)
                return  new ListNode(carry);
            else
                return null;
        }
        
        int res = 0;
        if (l1 != null && l2 != null)
        {
            res = l1.val + l2.val + carry;
        }
        else if (l1 == null && l2 != null)
        {
            res = l2.val + carry; 
        }
        else
        {
            res = l1.val + carry; 
        }
        carry = 0;
        if (res > 9)
        {
            res %= 10; 
            carry++;
        }
        
        ListNode lResult = new ListNode(res);
        lResult.next = addTwoNumbers(l1 != null ? l1.next : null, l2 != null ? l2.next : null, carry);
        return lResult;
    }

    public static void main(String[] args)
    {
        LinkedListAddNumbers la = new LinkedListAddNumbers();
        la.createData();
    }

    private void createData()
    {
        ListNode l1 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(3);
        
        l1.next = l3;
        l3.next = l4;
        
        l2.next = l5;
        l5.next = l6;
        l6.next = l7;
        // addTwoNumbers(l1, l2);
        ListNode l = addTwoNumbersR(l1, l2);
        while (l != null)
        {
            System.out.println(l.val);
            l = l.next;
        }
    }
}
