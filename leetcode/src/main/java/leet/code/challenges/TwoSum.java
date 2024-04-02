package leet.code.challenges;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum
{
    public static void main(String[] args)
    {
        TwoSum ts = new TwoSum(); // []
        System.out.println(Arrays.toString(ts.twoSum(new int[] {-1,-2,-3,-4,-5}, -8)));
    }

    public int[] twoSum(int[] nums, int target)
    {
        int[] result = new int[2];
        // Value and Index
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++)
        {
            if (hm.containsKey(target - nums[i]))
            {
                result = new int [] {hm.get(target - nums[i]) , i};
                break;
            }
            hm.put(nums[i], i);
        }
        return result;
    }
}
