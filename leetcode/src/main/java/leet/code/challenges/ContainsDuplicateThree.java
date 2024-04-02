package leet.code.challenges;

import java.util.TreeSet;

public class ContainsDuplicateThree
{

    public static void main(String[] args)
    {
        ContainsDuplicateThree c = new ContainsDuplicateThree(); // [8,7,15,1,6,1,9,15]
        System.out.println(c.containsNearbyAlmostDuplicate(new int[] {8,7,15,1,6,1,9,15}, 1 , 3));
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            // Find the successor of current element
            Integer s = set.ceiling(nums[i]);
            if (s != null && (long) s <= nums[i] + t) return true;

            // Find the predecessor of current element
            Integer g = set.floor(nums[i]);
            if (g != null && nums[i] <= (long) g + t) return true;

            set.add(nums[i]); 
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
    
//    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t)
//    {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++)
//        {
//            map.put(nums[i], i);
//            for (int j = 0; j <= t; j++)
//            {
//                if (i != j && map.containsKey(Math.abs(nums[i] - j))  && map.get(Math.abs(nums[i] - j)) != i && Math.abs(i - map.get(Math.abs(nums[i] - j))) <= k)
//                {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
