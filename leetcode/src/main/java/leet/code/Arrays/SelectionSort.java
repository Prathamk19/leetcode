package leet.code.Arrays;

import java.util.Arrays;

public class SelectionSort
{
    public static void main(String[] args)
    {
        SelectionSort s = new SelectionSort();
        s.sort(new int[]{44, 12, 25, 87, 63, 11, 2});
    }

    private void sort(int[] is)
    {
        for (int i = 0; i < is.length - 1; i++)
        {
            int minIndex = i;
            for (int j = i; j < is.length; j++)
            {
                if (is[j] < is[minIndex])
                {
                    minIndex = j;
                }
            }
            int temp = is[minIndex];
            is[minIndex] = is[i];
            is[i] = temp;
        }
        System.out.println(Arrays.toString(is));
    }
}
