package leet.code.Arrays;

import java.util.Arrays;

public class MergeSort
{
    public static void main(String[] args)
    {
        MergeSort ms = new MergeSort();
        ms.sort(new int[]
        { 44, 12, 25, 87, 63, 11, 2 });
    }

    private void sort(int[] is)
    {
        merge(is, new int[is.length], 0, is.length - 1);
        System.out.println(Arrays.toString(is));
    }

    private void merge(int[] arr, int[] aux, int left, int right)
    {
        if (left >= right)
            return;
        int mid = left + (right - left) / 2;
        merge(arr, aux, left, mid);
        merge(arr, aux, mid + 1, right);
        mergeSort(arr, aux, left, mid, right);
    }

    private void mergeSort(int[] arr, int[] aux, int left, int mid, int right)
    {
        for (int i = left; i <= right; i++)
        {
            aux[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++)
        {
            if (i > mid)
                arr[k] = aux[j++];
            else if (j > right)
                arr[k] = aux[i++];
            else if (aux[i] < aux[j])
                arr[k] = aux[i++];
            else
                arr[k] = aux[j++];
        }
    }
}
