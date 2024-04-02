package leet.code.challenges;

import java.util.ArrayList;

public class SummaryRanges
{
    ArrayList<int[]> result = null;
    
    public SummaryRanges()
    {
        result = new ArrayList<int[]>();
    }

    public void addNum(int val)
    {
        if (result == null)
        {
            return;
        }
        
        if (result.size() == 0)
        {
            result.add(new int[] {val, val});
            return;
        }
        
        for (int i = 0; i < result.size(); i++)
        {
            int [] arr = result.get(i);
            // [1, 1] val = 2
            // [1, 2] check for next int arr of interval
            if (arr[0] + 1 == val && arr[1] == arr[0])
            {
                arr[1] = val;
                checkNextIntervals(val, i);
                return;
            }
            else if (arr[0] - 1 == val && arr[0] == arr[1])
            {
                arr[0] = val;
                checkPrevIntervals(val, i);
            }
            else if (arr[0] - 1 == val)
            {
                arr[0] = val;
                checkPrevIntervals(val, i);
                return;
            }
            else if (arr[1] + 1 == val)
            {
                arr[1] = val;
                checkNextIntervals(val, i);
                return;
            }
            else if (arr[0] <= val || arr[1] >= val)
                return;
        }
    }

    private void checkNextIntervals(int val, int i)
    {
        
    }
    
    private void checkPrevIntervals(int val, int i)
    {
        
    }

    public int[][] getIntervals()
    {
        
        
        return (int[][]) result.toArray();
    }

    public static void main(String[] args)
    {
        SummaryRanges sr = new SummaryRanges();
        sr.addNum(1);
        sr.addNum(2);

    }

}
