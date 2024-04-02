package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SubdomainVisitCount
{
    public static void main(String[] args)
    {
        int[] nums = new int[] {555,901,482,1771};
        int counter = 0;
        for (int i : nums)
        {
            int tempCount = 0;
            while (i > 0)
            {
                i = i/10;
                tempCount++;
            }
            if (tempCount % 2 == 0)
                counter++;
        }
        System.out.println(counter);
        
        SubdomainVisitCount s = new SubdomainVisitCount();
        String[] cpdomains = new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(Arrays.toString(s.subdomainVisits(cpdomains).toArray(new String[] {})));
    }
    
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : cpdomains)
        {
            String[] domains = s.split("\\s+");
            String[] frags = domains[1].split("\\.");
            
            int occ = Integer.parseInt(domains[0]);
            String cur = "";
            for (int i = frags.length - 1; i >= 0; i--)
            {
                cur = frags[i] + (i < frags.length - 1 ? "." : "") + cur;
                map.put(cur, map.getOrDefault(cur, 0) + occ);
            }
        }
        List<String> list = new ArrayList<>();
        for (String s : map.keySet())
        {
            list.add(map.get(s) + " " + s);
        }
        return list;
    }
}
