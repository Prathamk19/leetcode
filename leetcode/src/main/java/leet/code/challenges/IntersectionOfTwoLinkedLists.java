package leet.code.challenges;

public class IntersectionOfTwoLinkedLists
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

    public class Result
    {
        int length;
        ListNode last;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        ListNode pA = headA;
        ListNode pB = headB;
        while (pA != pB)
        {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public ListNode getIntersectionNodeWaste(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null)
            return null;

        Result resultA = getResult(headA);
        Result resultB = getResult(headB);
        
        if (resultA.last != resultB.last)
            return null;
        
        ListNode larger = resultA.length > resultB.length ? headA : headB;
        ListNode smaller = resultA.length < resultB.length ? headA : headB;
        
        larger = getNthNode(larger, Math.abs(resultA.length - resultB.length));
        
        while (larger.next != smaller.next)
        {
            larger = larger.next;
            smaller = smaller.next;
        }
        
        return larger.next;
    }

    private ListNode getNthNode(ListNode larger, int abs)
    {
        while (abs > 0)
        {
            larger = larger.next;
            abs--;
        }
        return larger;
    }

    private Result getResult(ListNode n)
    {
        int size = 0;
        while (n != null)
        {
            n = n.next;
            size++;
        }
        
        Result r = new Result();
        r.last = n;
        r.length = size;
        return r;
    }

    public static void main(String[] args)
    {
        IntersectionOfTwoLinkedLists i = new IntersectionOfTwoLinkedLists();
        i.initiate();
    }

    private void initiate()
    {
        ListNode l0 = new ListNode(0);
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        ListNode l8 = new ListNode(8);
        ListNode l9 = new ListNode(9);
        
        
        ListNode l10 = new ListNode(10);
        ListNode l11 = new ListNode(11);
        ListNode l12 = new ListNode(12);
        ListNode l13 = new ListNode(13);
        ListNode l14 = new ListNode(14);

        l10.next = l11;
        l11.next = l12;
        l12.next = l13;
        l13.next = l14;
        l14.next = l0;
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l7;

        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l8;
        l8.next = l9;

        System.out.println(getIntersectionNode(l10, l4).val);
    }
}
