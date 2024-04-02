package leet.code.challenges;

import java.util.ArrayList;
import java.util.List;

public class AmazonMaxSubArray
{
    public static int maxSubarrayLength(List<Integer> badges)
    {
        // Write your code here
        int maxLength = 0;
        int count = 0;
        for (int i : badges)
        {
            if (maxLength > badges.size() - count)
                break;
            int left, right = 0;
            int prod = 1;
            prod *= i;
            left = count;
            int j = count + 1;
            while (j < badges.size())
            {
                prod *= badges.get(j);
                j++;
                if (prod > 0)
                    right = j;
            }
            maxLength = Math.max((right - left), maxLength);
            count++;
        }
        return maxLength;
    }

    public static void main(String[] args)
    {
        List<Integer> l = new ArrayList<Integer>();
        // -1, 1, -1, 1
        l.add(1);
        l.add(-1);
        l.add(-1);
        l.add(-1);
        l.add(1);
        l.add(1);
        l.add(-1);
        l.add(-1);
        l.add(-1);
        l.add(1);
        l.add(1);
        maxSubarrayLength(l);
    }
}
