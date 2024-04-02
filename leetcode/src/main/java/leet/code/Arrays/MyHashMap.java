package leet.code.Arrays;

public class MyHashMap
{
    class Node
    {
        int key;
        int val;
        Node next;
    }
    
    Node[] map;
    int size = 0;

    public MyHashMap() {
        map = new Node[16];
    }
    
    public void put(int key, int value)
    {
        int ind = (map.length - 1) & key;
        Node n = map[ind];
        if (n != null && n.key == key)
        {
            n.val = value;
        }
        else if (n != null)
        {
            while (n.next != null && n.next.key != key)
            {
                n = n.next;
            }
            if (n.next != null)
            {
                n.next.val = value;
            } 
            else
            {
                Node next = new Node();
                next.key = key;
                next.val = value;
                n.next = next;
            }
        } 
        else
        {
            n = new Node();
            n.key = key;
            n.val = value;
            map[ind] = n;
        }
    }
    
    public int get(int key)
    {
        int ind = (map.length - 1) & key;
        Node n = map[ind];
        if (n != null)
        {
            while (n != null && n.key != key)
            {
                n = n.next;
            }
            if (n != null && n.key == key)
                return n.val;
        }
        return -1;
    }
    
    public void remove(int key)
    {
        int ind = (map.length - 1) & key;
        Node n = map[ind];
        if (n != null && n.key == key)
        {
            map[ind] = n.next;
        }
        else if (n != null && n.key != key)
        {
            while (n.next != null && n.next.key != key)
            {
                n = n.next;
            }
            if (n.next != null && n.next.key == key)
                n.next = n.next.next;
        }
    }
}
