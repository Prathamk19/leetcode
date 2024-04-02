package leet.code.challenges;

public class MedianOfTwoSortedArrays
{
    public static void main(String[] args)
    {
        MedianOfTwoSortedArrays med = new MedianOfTwoSortedArrays();
        int[] num1 = new int[]
        { 1, 2 };
        int[] num2 = new int[]
        { 3, 4 };
        double d = med.findMedianSortedArrays(num1, num2);
        System.out.println(d);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2)
    {
        int[] resultArray = new int[nums1.length + nums2.length];
        double med = 0.0;
        int one = 0, two = 0, i = 0;
        while (one < nums1.length && two < nums2.length)
        {
            if (nums1[one] < nums2[two])
                resultArray[i++] = nums1[one++];
            else if (nums1[one] >= nums2[two])
                resultArray[i++] = nums2[two++];
        }
        while (one < nums1.length)
        {
            resultArray[i++] = nums1[one++];
        }
        while (two < nums2.length)
        {
            resultArray[i++] = nums2[two++];
        }
        med = ((resultArray.length % 2) == 0
                ? (resultArray[resultArray.length / 2 - 1] + resultArray[resultArray.length / 2]) / 2.0
                : resultArray[resultArray.length / 2]);
        return med;
    }

}
