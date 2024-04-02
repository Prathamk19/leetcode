package leet.code.challenges;

import java.util.HashSet;

public class SingleNumberII
{
    public int singleNumber(int[] nums) {
        HashSet<Long> set = new HashSet<>();
        long sumSet = 0;
        long sumNum = 0;
        for (int num : nums)
        {
            sumSet += num;
            set.add((long)num);
        }
        
        for (Long num : set)
        {
            sumNum +=num;
        }
        // (3 * (a + b + c) - (a + a + a + b + b + b + c)) / 2
        return (int)((3*sumNum - sumSet)/2);
    }

    public static void main(String[] args)
    {
        SingleNumberII ss = new SingleNumberII();
        System.out.println(ss.singleNumber(new int[] {0,1,0,1,0,1,99}));;
    }
}
