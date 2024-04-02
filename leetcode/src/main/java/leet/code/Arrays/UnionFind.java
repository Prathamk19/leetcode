package leet.code.Arrays;

import java.nio.BufferOverflowException;
import java.util.HashMap;

public class UnionFind<T>
{
    int[] parent;
    int[] rank;
    Object[] elem;
    HashMap<T, Integer> map = new HashMap<T, Integer>();
    int count = 0;
    
    // Must get the initial size
    public UnionFind(int n)
    {
        parent = new int[n];
        rank = new int[n];
        elem = new Object[n];
        
        for (int i =0; i<n; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }
    }
    
    // add t if count is less than size 
    T add(T t)
    {
        if (count >= parent.length)
            throw new BufferOverflowException();
        if (map.containsKey(t))
            throw new IllegalArgumentException();
        elem[count] = t;
        map.put(t, parent[count++]);
        return t;
    }
    
    boolean contains(T t)
    {
        return map.containsKey(t);
    }
    
    // gives root index
    int find(T t)
    {
        if (!contains(t))
            throw new IllegalArgumentException();
        int index = map.get(t);
        while (index != parent[index])
        {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }

        return index;
    }
    
    // Joins 2 elements
    T union(T i, T j)
    {
        if (!contains(i) || !contains(j))
            throw new IllegalArgumentException();

        int iIndex = find(i);
        int jIndex = find(j);

        if (rank[iIndex] >= rank[jIndex])
        {
            parent[jIndex] = iIndex;
            rank[iIndex] += rank[jIndex];
        }
        else
        {
            parent[iIndex] = jIndex;
            rank[jIndex] += rank[iIndex];
        }

        return i;
    }
    
    // checks 2 elements connected
    boolean connected(T i, T j)
    {
        return (find(i) == find(j));
    }
    
    boolean isAllUnion()
    {
        boolean oneSkip = false;
        for (int i =0; i < count; i++)
        {
            if (!oneSkip && parent[i] == i) oneSkip = true;
            else if (oneSkip && parent[i] == i) return false;
        }
        return true;
    }
    
    
    public static void main(String[] args)
    {
        UnionFind<String> uf = new UnionFind<String>(10);
//        uf.add("pra");
//        uf.add("tha");
//        uf.add("mesh");
//        uf.add("shra");
//        uf.add("ddha");
//        uf.add("bhagya");
//        uf.add("shree");
//        uf.add("dhan");
//        uf.add("anjay");
//
//        uf.union("pra", "tha");
//        uf.union("tha", "mesh");
//        uf.union("shra", "ddha");
//        uf.union("bhagya", "shree");
//        uf.union("dhan", "anjay");
//        uf.union("shra", "pra");
        
        uf.add("MSP");
        uf.add("BOM");
        uf.add("DFW");
        uf.add("DEN");
        uf.add("DEL");
        uf.add("PUN");
        uf.add("AMS");
        uf.add("LON");
        uf.add("NYC");
        uf.add("JFK");

        uf.union("MSP", "NYC");
        uf.union("NYC", "DFW");
        uf.union("NYC", "DEN");
        uf.union("BOM", "DEL");
        uf.union("BOM", "PUN");
        uf.union("LON", "AMS");
        uf.union("BOM", "AMS");
        uf.union("NYC", "AMS");
        
        System.out.println(uf.isAllUnion());
        
//        if (uf.find("pra") == uf.find("ddha"))
//            System.out.println("Connected");
    }

}
