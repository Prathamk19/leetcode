package leet.code.challenges;

public class MaxLengthRepeatedSubarray
{

    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        for (int i = 0; i < nums1.length + nums2.length - 1; i++)
        {
            int aIndex = Math.max(0, nums1.length - 1 - i);
            int bIndex = Math.max(0, i - (nums1.length - 1));
            int tempI = 0;
            while (aIndex < nums1.length && bIndex < nums2.length)
            {
                tempI = nums1[aIndex] == nums2[bIndex] ? tempI + 1 : 0;
                aIndex++; bIndex++;
                result = Math.max(tempI, result);
            }
        }
        System.out.println(result);
        return result;
    }
    
    public static void main(String[] args)
    {
        MaxLengthRepeatedSubarray m = new MaxLengthRepeatedSubarray();
        m.findLength(new int[] {0,1,1,1,1}, new int[] {1,0,1,0,1});
        m.findLength(new int[] {5,14,53,80,48}, new int[] {50,47,3,80,83});
        // [5,14,53,80,48]
//        [50,47,3,80,83]
        // [0,1,1,1,1]
//        [1,0,1,0,1]
        
        m.findLength(new int[] {0,0,0,0,0,0,1,0,0,0}, new int[] {0,0,0,0,0,0,0,1,0,0});
    }
}
