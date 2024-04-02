package leet.code.challenges;

import java.util.Arrays;

public class July_22_2021
{

    public int threeSumClosest(int[] nums, int target)
    {
        int closest = Integer.MAX_VALUE- 10;
        Arrays.parallelSort(nums);
        for (int i = 0; i < nums.length ; i++)
        {
            for (int j = 0; j < nums.length; j++)
            {
                if (i == j)
                    continue;
                int desired = target - (nums[i] + nums[j]);
                if (desired <= nums[j])
                {
                    int tempI = 0;
                    while (tempI < j)
                    {
                        if (tempI == i)
                        {
                            tempI++;
                            continue;
                        }
                        if (Math.abs(target - (nums[tempI] + nums[i] + nums[j])) == 0)
                            closest = nums[tempI] + nums[i] + nums[j];
                        else if (Math.abs(target - (nums[tempI] + nums[i] + nums[j])) < Math.abs(target - closest))
                            closest = nums[tempI] + nums[i] + nums[j];
                        tempI++;
                    }
                }
                if (desired > nums[j])
                {
                    int tempI = j + 1;
                    while (tempI < nums.length && (tempI+1) < nums.length)
                    {
                        if (tempI == i)
                        {
                            tempI++;
                            continue;
                        }
                        if (Math.abs(target - (nums[tempI] + nums[i] + nums[j])) == 0)
                            closest = nums[tempI] + nums[i] + nums[j];
                        else if (Math.abs(target - (nums[tempI] + nums[i] + nums[j])) < Math.abs(target - closest))
                            closest = nums[tempI] + nums[i] + nums[j];
                        tempI++;
                    }
                }
            }
        }
        return closest;
    }

    public static void main(String[] args)
    {
        July_22_2021 n = new July_22_2021();
        System.out.println(n.threeSumClosest(new int[] {1,1,-1,-1,3}, -1));
    }
}
