package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

import leet.code.Arrays.MyHashMap;

// TODO incomplete...Leetcode error
public class WordSquares
{
    public List<List<String>> wordSquares(String[] words)
    {
        PriorityQueue<Integer> pq= new PriorityQueue<Integer>((a, b) -> b- a);
        pq.add(12);
        pq.add(18);
        pq.add(1);
        pq.add(2);
        pq.add(20);
        
        
        // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        MyHashMap map = new MyHashMap();
        
        map.put(2, 1);
        map.put(20, 1);
        map.put(4, 4);
        map.put(20, 20);
        map.put(200, 1);
        map.put(200, 4);
        System.out.println(map.get(20));
        System.out.println(map.get(2));
        map.remove(2);
        
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = Arrays.asList(words);
        int[] closest = new int[2];
        for (int i = 0; i < list.size() - 1; i++)
        {
            String ithS = list.get(i);
            for (int j = i + 1; j < list.size(); j++)
            {
                if (ithS.length() == list.get(j).length() && checkClosest(ithS, list.get(j)))
                {
                    closest[0] = i;
                    closest[1] = j;
                    break;
                }
            }
        }
        
        for (int i = 0; i < closest.length; i++)
        {
            List<String> temp = new ArrayList<String>();
            temp.add(list.get(closest[i]));
            for (int j = 0; j < list.size(); j++)
            {
                if (j != closest[0] && j != closest[1])
                {
                    temp.add(list.get(j));
                }
            }
            result.add(temp);
        }
        
        return result;
    }

    private boolean checkClosest(String string, String string2)
    {
        int mismatchCnt = 0;
        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) != string2.charAt(i) && mismatchCnt > 0)
                return false;
            else if (string.charAt(i) != string2.charAt(i) && mismatchCnt == 0)
                mismatchCnt++;
        }
        return true;
    }

    public static void main(String[] args)
    {
        WordSquares ws = new WordSquares();
        System.out.println(Arrays.toString(ws.wordSquares(new String[] {"area","lead","wall","lady","ball"}).toArray()));
    }
}
