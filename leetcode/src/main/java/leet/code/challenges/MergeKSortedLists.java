package leet.code.challenges;

import java.util.PriorityQueue;

public class MergeKSortedLists
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

    public static void main(String[] args)
    {
        MergeKSortedLists msl = new MergeKSortedLists();
        msl.initialize();
    }

    private void initialize()
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        n4.next = n5;
        n5.next = n6;
        ListNode n7 = new ListNode(0);
        ListNode n8 = new ListNode(7);
        n7.next = n8;
        ListNode[] lists = new ListNode[] {n1,n4,n7};
        mergeKLists(lists);
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for (int i = 0; i < lists.length; i++)
        {
            ListNode n = lists[i];
            while (n != null)
            {
                pq.add(n.val);
                n = n.next;
            }
        }
        if (pq.isEmpty())
        {
            return null;
        }
        ListNode result = new ListNode(pq.poll());
        ListNode prev = result;
        
        while (!pq.isEmpty())
        {
            prev.next = new ListNode(pq.poll());
            prev = prev.next;
        }
        return result;
    }
}
