package leet.code.challenges;

public class PossiblePalindrome
{
    public static void main(String[] args)
    {
        System.out.println(checkPossiblePalindrome("racecar"));
    }

    private static char checkPossiblePalindrome(String string)
    {
        if (checkPalindrome(string))
        {
            return 0;
        }
        else
        {
            int i = 0;
            int l = string.length() - 1;
            while (i < l)
            {
                if (string.charAt(i) == string.charAt(l))
                {
                    i++; l--;
                }
                else if (string.charAt(i + 1) == string.charAt(l))
                {
                    if (checkPalindrome(string.substring(i + 1, l + 1)))
                        return string.charAt(i);
                    break;
                }
                else if (string.charAt(i) == string.charAt(l - 1))
                {
                    if (checkPalindrome(string.substring(i, l)))
                        return string.charAt(l);
                    break;
                }
            }
        }
        return 0;
    }

    private static boolean checkPalindrome(String string)
    {
        if (string.length() == 0 || string.length() == 1)
            return true;
        else if (string.charAt(0) == string.charAt(string.length() - 1))
            return checkPalindrome(string.substring(1, string.length() - 1));
        return false;
    }
    
    

}
