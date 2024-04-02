package leet.code.challenges;

import java.util.HashMap;
import java.util.Scanner;

public class VisaSolution
{

    static int addNumbers(int a, int b)
    {
        return a + b;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int a;
        a = in.nextInt();
        int b;
        b = in.nextInt();
        int sum;

        sum = addNumbers(a, b);
        System.out.println(sum);
    }

    interface ILRUCache<K, V>
    {
        public V getValue(K k);

        public void addValue(K k, V v);
    }

    static class LRUCache<K, V> implements ILRUCache<K, V>
    {
        private HashMap<K, DNode> map;
        private int cap;
        private int size;
        private DNode head;
        private DNode tail;

        class DNode
        {
            private DNode prev;
            private DNode next;
            private K key;
            private V val;

            public DNode()
            {

            }
        }

        LRUCache(int capacity)
        {
            cap = capacity;
            head = new DNode();
            tail = new DNode();
            head.next = tail;
            tail.prev = head;
            map = new HashMap<>();
        }

        private void setFirst(DNode node)
        {
            DNode first = head.next;
            head.next = node;

            first.prev = node;
            node.next = first;
            node.prev = head;
        }

        private void removeNode(DNode node)
        {
            // node prev
            DNode prev = node.prev;
            prev.next = node.next;
            node.next.prev = prev;
            node.next = null;
            node.prev = null;
        }

        // Returns the value associated with Key k
        public V getValue(K k)
        {
            V val = null;
            DNode node = map.get(k);
            if (node != null)
            {
                removeNode(node);
                setFirst(node);
                val = node.val;
            }
            return val;
        }

        public void addValue(K k, V v)
        {
            DNode node = map.get(k);
            if (node != null)
            {
                node.val = v;
                removeNode(node);
            } else
            {
                node = new DNode();
                node.key = k;
                node.val = v;

                size++;
                if (size > cap)
                {
                    DNode toRemove = tail.prev;
                    map.remove(toRemove.key);
                    removeNode(toRemove);
                    map.put(k, node);
                    size--;
                }
            }
            setFirst(node);
        }
    }

}
