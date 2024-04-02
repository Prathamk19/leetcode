package leet.code.challenges;

public class ReverseInteger
{
    public static void main(String[] args)
    {
        ReverseInteger rv = new ReverseInteger();
        System.out.println(rv.reverse(153423646));
    }

    public int reverse(int x)
    {
        // -231, 231 - 1
        // 2147483647
        // 1534236469
        if (x >= Integer.MAX_VALUE || x < Integer.MIN_VALUE)
            return 0;
        long result = 0;
        while (x != 0)
        {
            int rem = x % 10;
            x /= 10;
            result = result * 10 + (rem);
        }
        if (result >= Integer.MAX_VALUE || result < Integer.MIN_VALUE)
            return 0;
        return (int) result;
    }

}
