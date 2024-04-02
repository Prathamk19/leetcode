package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsArray
{
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i : nums)
        {
            temp.add(i);
        }
        permutation(res, temp, nums.length - 2, nums.length - 1,  nums.length);
        return res;
    }
    
    public void permutation(List<List<Integer>> res, List<Integer> temp, int left, int right, int size)
    {
        if (temp.size() == size)
        {
            res.add(temp);
        }
        
        
    }
    
    public static void main(String[] args)
    {
        PermutationsArray p = new PermutationsArray();
        System.out.println(Arrays.toString(p.permute(new int[] {1, 2, 3}).toArray()));
    }
}
