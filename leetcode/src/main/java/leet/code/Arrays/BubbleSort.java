package leet.code.Arrays;

import java.util.Arrays;

public class BubbleSort
{
    public static void main(String[] args)
    {
        BubbleSort bs = new BubbleSort();
        bs.sort(new int[]{44, 12, 25, 87, 63, 11, 2});
    }

    private void sort(int[] is)
    {
        // largest number in the end of the array
        for (int i = 0; i < is.length - 1 ; i++)
        {
            for (int j = 0; j < is.length - i - 1; j++)
            {
                if (is[j] > is[j + 1])
                {
                    int temp = is[j];
                    is[j] = is[j + 1];
                    is[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(is));
    }
}
