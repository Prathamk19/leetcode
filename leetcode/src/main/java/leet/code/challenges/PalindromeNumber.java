package leet.code.challenges;

public class PalindromeNumber
{
    public static void main(String[] args)
    {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(-123321));
    }

    public boolean isPalindrome(int x)
    {
        if (x >= Integer.MAX_VALUE || x < 0)
            return false;
        int temp = x;
        long result = 0;
        while (temp != 0)
        {
            int rem = temp % 10;
            temp /= 10;
            result = result * 10 + (rem);
        }
        if (result >= Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return false;
        return result == x;
    }
}
