package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LeetCode1160Words
{
    public static void main(String[] args)
    {
        LeetCode1160Words l = new LeetCode1160Words();
        System.out.println(l.countCharacters(new String[] {"cat","bt","hat","tree"}, "atach"));
    }

    public int countCharactersFastest(String[] words, String chars) {
        int[] scan = new int[26];
        for (char c : chars.toCharArray())
        {
            scan[c - 'a']++;
        }
        int result = 0;
        for (String s : words)
        {
            int[] tscan = Arrays.copyOf(scan, scan.length);
            int wordLength = 0;
            for (char c : s.toCharArray())
            {
                if (tscan[c - 'a'] > 0)
                    tscan[c - 'a']--;
                else
                    break;
                wordLength++;
            }
            if (wordLength == s.length())
                result+= wordLength;
        }
        return result;
    }
    
    public int countCharacters(String[] words, String chars) {
        List<String> res = new ArrayList<>();
        for (String s : words)
        {
            HashMap<Character, Integer> map = new HashMap<>();
            for (char c : chars.toCharArray())
            {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            boolean completed = true;
            for (char c : s.toCharArray())
            {
                if (map.containsKey(c) && map.get(c) > 0)
                {
                    map.put(c, map.get(c) - 1);
                }
                else
                {
                    completed = false;
                    break;
                }
            }
            if (completed)
            {
                res.add(s);
            }
        }
        
        int count = 0;
        for (String s : res)
        {
            count += s.length();
        }
        return count;
    }
    
}
