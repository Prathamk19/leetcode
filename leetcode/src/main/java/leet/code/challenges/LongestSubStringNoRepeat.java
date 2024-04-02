package leet.code.challenges;

import java.util.ArrayList;

public class LongestSubStringNoRepeat
{

    public static void main(String[] args)
    {
        // thames
        // ameshdB
        LongestSubStringNoRepeat longestSub = new LongestSubStringNoRepeat();
        String sub = longestSub.checkLongestSubString("abcadefghijklmnoapaqrstu");
        System.out.println(sub);
        System.out.println(longestSub.lengthOfLongestSubstring("abcadefghijklmnoapaqrstu"));
    }
    
    public int lengthOfLongestSubstring(String s)
    {
        StringBuilder sb = new StringBuilder();
        int res = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (sb.toString().contains("" + s.charAt(i)))
            {
                res = Math.max(res, sb.toString().length());
                sb = new StringBuilder(sb.substring(sb.indexOf(""+s.charAt(i)) + 1, sb.length()));
                sb.append("" + s.charAt(i));
            } 
            else
            {
                sb.append(s.charAt(i));
            }
        }
        return Math.max(res, sb.toString().length());
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private String checkLongestSubString(String string)
    {
        StringBuilder res = new StringBuilder();
        ArrayList<String> tempList = new ArrayList<String>();
        for (int i = 0; i < string.length(); i++)
        {
            if (res.toString().contains(""+string.charAt(i)))
            {
                tempList.add(res.substring(0, (res.length())));
                res = new StringBuilder(res.substring(res.toString().indexOf(string.charAt(i)) + 1, res.length()));
                res.append(string.charAt(i));
            }
            else
            {
                res.append(string.charAt(i));
            }
        }
        String temp = "";
        for (String s : tempList)
        {
            temp = s.length() > temp.length() ? s : temp;
        }
        return res.toString().length() > temp.length() ? res.toString() : temp;
    }

}
