package leet.code.binaryTree;

public class LinkedList
{
    class Node
    {
        int val;
        Node next;
        
        Node(int i)
        {
            val = i;
        }
    }
    
    Node head;
    
    Node reverseLinkedList(Node n)
    {
        if (n.next == null)
            return head = n;
        
        Node newNode = reverseLinkedList(n.next);
        newNode.next = n;
        n.next = null;
        
        return n;
    }
    
    Node reverseLinkedListLoop(Node n)
    {
        if (n == null)
            return null;
        Node prev = null;
        Node current = n;
        Node next = null;
        while (current != null)
        {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        n = prev;
        return n;
    }
    
    // Bottom up
    Node alterNodes(Node n)
    {
        if (n == null || n.next == null)
            return n;
        Node node = alterNodes(n.next);
        if (n.next == node)
        {
            Node temp = n;
            n = node;
            temp.next = n.next;
            n.next = temp;
        }
        else
        {
            n.next = node;
            node = n;
        }
        return node;
    }
    
    
    Node alterNodesTopDown(Node n)
    {
        if (n == null || n.next == null)
            return n;
        Node temp = n; // 10
        n = n.next; // n = 6
        temp.next = n.next; // 
        n.next = temp;
        
        n.next.next = alterNodesTopDown(n.next.next); 
        return n;
    }
    
    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList();
        ll.init();
    }

    private void init()
    {
        Node n1 = new Node(10);
        Node n2 = new Node(6);
        Node n3 = new Node(3);
        Node n4 = new Node(8);
        Node n5 = new Node(16);
        Node n6 = new Node(12);
        Node n7 = new Node(18);
        Node n8 = new Node(17);
        Node n9 = new Node(19);
        
        head = n1;
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = n9;
        reverseLinkedListLoop(n1);
        alterNodesTopDown(n1);
        alterNodes(n1);
        reverseLinkedList(n1);
    }

}
