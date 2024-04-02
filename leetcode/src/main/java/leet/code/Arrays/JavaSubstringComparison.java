package leet.code.Arrays;

import java.util.HashMap;

public class JavaSubstringComparison
{

    public static boolean isAnagram(String a, String b) {
        
//        if (a.equalsIgnoreCase(b))
//            return true;
//        char[] aArray = a.toCharArray();
//        Arrays.parallelSort(aArray);
//        char[] bArray = b.toCharArray();
//        Arrays.parallelSort(bArray);
//        if (new String(aArray).equalsIgnoreCase(new String(bArray)))
//            return true;

        int[] aLetters = new int[26];
        int[] bLetters = new int[26];
        
        for (char aC : a.toLowerCase().toCharArray())
        {
            aLetters[aC - 'a']++;
        }
        for (char bC : b.toLowerCase().toCharArray())
        {
            bLetters[bC - 'a']++;
        }
        for (int i = 0; i < aLetters.length; i++)
        {
            if (aLetters[i] != bLetters[i])
                return false;
        }
        return true;
    }
    
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = "";
        
        for (int i = 0; i<s.length(); i++)
        {
            if ((i + k) <= s.length() && s.substring(i, i+k).compareTo(largest) > 0)
            {
                largest = s.substring(i, i+k);
            }
            if ((i + k) <= s.length() && s.substring(i, i+k).compareTo(smallest) < 0)
            {
                smallest = s.substring(i, i+k);
            }
        }
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        
        return smallest + "\n" + largest;
    }
    
    public static void main(String[] args)
    {
        int[] nums = new int[] {2,7,11,15};
        int target = 9;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int a=0; a<nums.length; a++)
        {
            hm.put(nums[a], a);
        }
        int[] res = new int[2];
        for (int a=0; a<nums.length; a++)
        {
            int f = target - nums[a];
            if (hm.containsKey(f))
            {
                res[0] = nums[a];
                res[1] = hm.get(f);
            }
        }
        
        System.out.println(getSmallestAndLargest("ASDFHDSFHsdlfhsdlfLDFHSDLFHsdlfhsdlhkfsdlfLHDFLSDKFHsdfhsdlkfhsdlfhsLFDLSFHSDLFHsdkfhsdkfhsdkfhsdfhsdfjeaAAADFHSDLFHDFlajfsdlfhsdlfhDSLFHSDLFHdlfhs", 30));
    }
}
