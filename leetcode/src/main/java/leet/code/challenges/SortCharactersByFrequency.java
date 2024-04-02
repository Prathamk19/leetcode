package leet.code.challenges;

import java.util.HashMap;
import java.util.PriorityQueue;

public class SortCharactersByFrequency
{
    public String frequencySort(String s) 
    {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (char c : s.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> q = new PriorityQueue<Character>((a, b) -> map.get(b) - map.get(a));
        q.addAll(map.keySet());
        
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty())
        {
            char c = q.remove();
            for (int i = 0; i < map.get(c); i++)
            {
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
    
    
    public static void main(String[] args)
    {
        SortCharactersByFrequency s = new SortCharactersByFrequency();
        System.out.println(s.frequencySort("Aabbsdfkdjddllll"));
    }

}
