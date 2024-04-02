package leet.code.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<Integer>();
        combinationSum(0, 0, candidates, target, temp, result);
        return result;
    }

    private void combinationSum(int i, int total, int[] candidates, int target, List<Integer> temp, List<List<Integer>> result)
    {
        if (total == target)
        {
            result.add(new ArrayList<Integer>(temp));
            return;
        }
        if (i >= candidates.length || total > target)
        {
            return;
        }
        
        temp.add(candidates[i]);
        combinationSum(i + 1, total + candidates[i], candidates, target, temp, result);
        if (temp.size() > 0)
        {
            temp.remove(temp.size() - 1);
        }
        combinationSum(i + 1, total, candidates, target, temp, result);
    }

    public static void main(String[] args)
    {
        CombinationSum cs = new CombinationSum();
        System.out.println(Arrays.toString(cs.combinationSum(new int[]
        { 1, 2, 3, 4, 5}, 10).toArray()));
    }
}
