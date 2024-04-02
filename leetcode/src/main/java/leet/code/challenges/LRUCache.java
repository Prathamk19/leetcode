package leet.code.challenges;

import java.util.HashMap;

public class LRUCache
{
    class DLinkedNode
    {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    HashMap<Integer, DLinkedNode> map = new HashMap<>();
    DLinkedNode head;
    DLinkedNode tail;
    int size = 0;
    int cap = 0;

    public LRUCache(int capacity)
    {
        cap = capacity;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    private void placeAtFront(DLinkedNode node)
    {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node)
    {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    public int get(int key)
    {
        if (!map.containsKey(key))
            return -1;
        DLinkedNode node = map.get(key);
        removeNode(node);
        placeAtFront(node);
        return node.value;
    }

    public void put(int key, int value)
    {
        DLinkedNode node = map.get(key);

        if (map.containsKey(key))
        {
            node.value = value;
            removeNode(node);
            placeAtFront(node);
        } 
        else
        {
            node = new DLinkedNode();
            node.key = key;
            node.value = value;
            placeAtFront(node);
            map.put(key, node);
            ++size;

            if (size > cap)
            {
                int toRemove = tail.prev.key;
                removeNode(tail.prev);
                map.remove(toRemove);
                --size;
            }
        }
    }
}
