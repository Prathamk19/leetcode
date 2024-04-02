package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmazonFindMaxProduct
{
    public static long findMaxProduct(List<Integer> products)
    {
        long res = 0;
        int[] pr = new int[products.size()];
        for (int i = 0; i < products.size(); i++)
        {
            pr[i] = products.get(i);
        }
        
        for (int i = 0; i < pr.length; i++)
        {
            int curr = pr[i];
            int j = i + 1;
            int count = 1;
            int right = 0;
            while (j < pr.length)
            {
                int temp = pr[j];
                if (temp >= curr + count)
                    right = j;
                else
                    break;
                count++;
                j++;
            }
            if (right > i)
                res = Math.max(formatArrayReturnSum(Arrays.copyOfRange(pr, i, right + 1)), res);
        }
        return res;
    }
    private static long formatArrayReturnSum(int[] pr)
    {
        for (int i = pr.length - 1; i >= 0 ; i--)
        {
            for (int j = i - 1; j >= 1; j--)
            {
                if (pr[i] <= pr[j])
                    pr[j] = pr[i] - (i - j);
            }
        }
        long sum = 0;
        for (int i : pr)
            sum += i;
        return sum;
    }
    public static void main(String[] args)
    {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1); // 1
        l.add(14); // 2
        l.add(5); // 3
        l.add(4); // 4
        l.add(8); // 6
        l.add(7); // 7
        l.add(2);
        l.add(3);
        System.out.println(findMaxProduct(l));
    }
}
