package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class July_22_Partition
{

    public int partitionDisjoint(int[] nums)
    {
        // find largest in left and smallest in right and largest in left has to be smaller than Smallest in right
        
        int smallestR = nums[nums.length - 1];
        int tempL = 0;
        int tempR = nums.length - 1;
        int smallestRIndex = tempR; 
        while (nums[tempL] <= smallestR && tempR > 0)
        {
            if (nums[tempR] > nums[tempL] && nums[tempR] <= smallestR)
            {
                smallestR = nums[tempR];
                smallestRIndex = tempR;
            }
            else if (nums[tempL] > nums[tempR] || tempL>= tempR)
                break;
            tempR--;
        }
        
        while (smallestRIndex > tempL)
        {
            if (nums[tempL] > nums[smallestRIndex])
            {
                smallestRIndex++;
                break;
            }
            tempL++;
        }
        
        return Math.max(tempL, smallestRIndex);
    }

    public static void main(String[] args)
    {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        l.add(6);
        int[] a = new int[l.size()];
        int d = 4;
        int s = l.size();
        for (int i =0; i < s; i++)
        {
            if (i < d)
            {
                a[s - (d - i)] = l.get(i);
            }
            else
            {
                a[i - d] = l.get(i);
            }
        }
        
        System.out.println(Arrays.toString(a));
        l.clear();
        for (int i =0; i < a.length; i++)
        {
            l.add(a[i]);
        }
        
        
        July_22_Partition n = new July_22_Partition();
        System.out.println(n.partitionDisjoint(new int[] {32,57,24,19,0,24,49,67,87,87}));
    }

}
