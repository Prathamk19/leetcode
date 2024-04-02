package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ThreeSome
{
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        HashSet<List<Integer>> res = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n = 0; n < nums.length; n++)
        {
            map.put(nums[n], n);
        }
        for (int i = 0; i < nums.length - 1; i++)
        {
            for (int j = i + 1; j < nums.length; j++)
            {
                int temp = nums[i] + nums[j];
                
                if (map.containsKey(-temp) && map.get(-temp) != i && map.get(-temp) != j)
                {
                    int[] tempArr = new int[] {nums[i], nums[j], -temp};
                    Arrays.sort(tempArr);
                    List<Integer> r = new ArrayList<>();
                    for (int val : tempArr)
                        r.add(val);
                    res.add(r);
                }
            }
        }
        return new ArrayList<>(res);
    }
    
    public static void main(String[] args)
    {
        ThreeSome t = new ThreeSome();
        t.threeSum(new int[] {-1,0,1,2,-1,-4});
    }
}
