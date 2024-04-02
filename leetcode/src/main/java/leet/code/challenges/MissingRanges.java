package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingRanges
{
    public List<String> findMissingRanges(int[] nums, int lower, int upper)
    {
        List<String> res = new ArrayList<>();
        int prev = lower;
        int curr = 0;
        for (int i = 0; i <= nums.length; i++)
        {
            if (i == nums.length)
                curr = upper + 1;
            else
                curr = nums[i];
            if (curr == prev || curr == (prev + 1))
            {
                prev = curr;
                continue;
            }
            else
            {
                if (curr - prev == 2)
                    res.add(""+(curr - prev));
                else
                {
                    res.add((prev + 1) + "->" + (curr - 1));
                }
            }
            prev = curr;
        }
        if (nums.length == 0)
            res.add(""+lower);
        return res;
    }

    public static void main(String[] args)
    {
        MissingRanges m = new MissingRanges();
        System.out.println(Arrays.toString(m.findMissingRanges(new int[] {0,1,3,50,75}, 0, 99).toArray()));
    }
}
