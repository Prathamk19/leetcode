package leet.code.recursion;

public class RecursionString
{
    public void reverseString(char[] s) {
        reverseString(s, 0);
    }

    private void reverseString(char[] s, int i)
    {
        if ((s.length % 2 == 0) && i >= (s.length/2))
            return;
        else if ((s.length % 2 == 1) && i > (s.length/2))
            return;
        reverseString(s, i + 1);
        char temp = s[i];
        s[i] = s[s.length - i - 1]; 
        s[s.length - i - 1] = temp;
    }
}
