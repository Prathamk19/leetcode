package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram
{

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        for (String s : strs)
        {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sorted = new String(c);
            if (map.containsKey(sorted))
                map.get(sorted).add(s);
            else
            {
                List<String> l = new ArrayList<String>();
                l.add(s);
                map.put(sorted, l);
            }
        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> ls : map.values())
        {
            res.add(ls);
        }
        
        return res;
    }
    
    public static void main(String[] args)
    {
        GroupAnagram ga= new GroupAnagram();
        System.out.println(Arrays.toString(ga.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}).toArray()));
    }
}
