package leet.code.recursion;

public class RecursionNode
{
    class ListNode
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
    
    private ListNode reverse(ListNode head)
    {
        if(head == null) {
            return head;
        }
  
        // last node or only one node
        if(head.next == null) {
            return head;
        }
  
        ListNode newHeadNode = reverse(head.next);
  
        // change references for middle chain
        head.next.next = head;
        head.next = null;
  
        // send back new head node in every recursion
        return newHeadNode;
    }



    public static void main(String[] args)
    {
        RecursionNode rn = new RecursionNode();
        rn.createNodes();
    }

    private void createNodes()
    {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNode rev = reverse(n1);
        while (rev != null)
        {
            System.out.println(rev.val);
            rev = rev.next;
        }
        ListNode newN = swapPairs(n1);
        while (newN != null)
        {
            System.out.println(newN.val);
            newN = newN.next;
        }
    }
    
    private ListNode swapPairs(ListNode head)
    {
        if(head == null || head.next == null) {
            return head;
        }
        
        ListNode first = new ListNode(head.next.val);
        ListNode second = new ListNode(head.val);
        
        first.next = second;
  
        ListNode newNode = swapPairs(head.next.next);
  
        // change references for middle chain
        second.next = newNode;
        return first;
    }
}
