package leet.code.challenges;

public class LongestPalindromeSubstring
{

    int cnt = 0;

    // zyabbacdefggfedca
    public static void main(String[] args)
    {
        LongestPalindromeSubstring lp = new LongestPalindromeSubstring();
//        String s = lp.longestPalindrome("asdfghjklqwertasdfghjklqwertyuiozyabbacdefggfedca");
        String s = lp.longestPalindrome("asdfghjklqwertasdfghjklqwertyuiozyabbacdefggfedca");
        System.out.println(lp.cnt);
        lp.cnt = 0;
        // "abcda"
        String s2 = lp.longPalindrome("asdfghjklqwertasdfghjklqwertyuiozyabbacdefggfedca");
        System.out.println(lp.cnt);
        System.out.println(s);
        System.out.println(s2);
    }

    public String longestPalindrome(String s)
    {
        if (s == null || s.length() < 1)
            return "";
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++)
        {
            int len1 = expandMiddle(s, i, i);
            int len2 = expandMiddle(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start)
            {
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandMiddle(String s, int left, int right)
    {
        if (s == null || left > right)
            return 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right))
        {
            cnt++;
            left--;
            right++;
        }
        return right - left - 1;
    }

    private String longPalindrome(String s)
    {
        if (s.length() < 2)
            return s;
        if (s.length() == 2)
            return checkPalindrome(s, 0, s.length() - 1) ? s : s.substring(0, s.length() - 1);
        String res = "";
        for (int i = 0; i < s.length(); i++)
        {
            if ((s.length() - i) < res.length())
                break;
            if (!s.substring(i + 1).contains("" + s.charAt(i)))
                continue;

            int right = s.length() - 1;
            if (checkPalindrome(s, i, right))
            {
                res = res.length() < s.substring(i, right + 1).length() ? s.substring(i, right + 1) : res;
            } 
            else
            {
                int left = i;
                right--;
                while (left < right && s.substring(left + 1, right).contains("" + s.charAt(left)))
                {
                    if (checkPalindrome(s, left, right))
                    {
                        res = res.length() < s.substring(left, right + 1).length() ? s.substring(left, right + 1) : res;
                        break;
                    }
                    right--;
                }
            }
        }
        return res.length() == 0 ? s.substring(0, 1) : res;
    }

    private String longestPalindromeOld(String s)
    {
        String result = "";
        for (int i = 0; i < s.length(); i++)
        {
            for (int j = i + 1; j <= s.length(); j++)
            {
                if (j - i > result.length() && checkPalindrome(s, i, j - 1))
                {
                    result = s.substring(i, j);
                }
            }
        }

        return result;
    }

    boolean checkPalindrome(String s, int i, int j)
    {
        while (i < j)
        {
            cnt++;
            if (s.charAt(i) == s.charAt(j))
            {
                i++;
                j--;
            } else
                return false;
        }
        return true;
    }

}
