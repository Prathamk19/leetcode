package leet.code.challenges;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ShortestUnsortedContinuousSubarray
{

    public int findUnsortedSubarray(int[] nums)
    {
        int length = nums.length - 1;
        int lowerDelta = length;
        int upperDelta = 0;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (prev > nums[i] && lowerDelta > i)
            {
                lowerDelta = i - 1;
            }
            if (prev < nums[i] && upperDelta < i)
            {
                upperDelta = i;
            }
            prev = nums[i];
        }
        return upperDelta - lowerDelta;
    }
    
    public static void main(String[] args)
    {
        String s3 = "String1";
        String s1 = new String("String1");
        
        ShortestUnsortedContinuousSubarray s = new ShortestUnsortedContinuousSubarray();
        System.out.println(s.findUnsortedSubarray(new int[]{1,2,3,4}));
        String s2 = "String1";
        
        
        boolean res = s3.equals(s2);
        System.out.println(res);
        System.out.println("St".hashCode());
        
        Map<Integer, String> syncMap = Collections.synchronizedMap(new HashMap<Integer, String>());
        syncMap.put(1, "One");
        
    }
}
