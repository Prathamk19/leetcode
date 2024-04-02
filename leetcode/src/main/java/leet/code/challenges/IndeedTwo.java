package leet.code.challenges;

import java.util.HashMap;

public class IndeedTwo
{

    public static void main(String[] argv)
    {
        String tiles1 = "11133555";
        String tiles2 = "111333555";
        String tiles3 = "00000111";
        String tiles4 = "13233121";
        String tiles5 = "11223344555";
        String tiles6 = "99999999";
        String tiles7 = "999999999";
        String tiles8 = "9";
        String tiles9 = "99";
        String tiles10 = "000022";
        String tiles11 = "888889";
        String tiles12 = "889";
        String tiles13 = "88888844";
        String tiles14 = "77777777777777";
        String tiles15 = "1111111";
        String tiles16 = "1111122222";

        System.out.println(checkValidTile(tiles1)); // true
        System.out.println(checkValidTile(tiles2));
        System.out.println(checkValidTile(tiles3)); // true
        System.out.println(checkValidTile(tiles4)); // true
        System.out.println(checkValidTile(tiles5)); // true
        System.out.println(checkValidTile(tiles6)); // true
        System.out.println(checkValidTile(tiles7));
        System.out.println(checkValidTile(tiles8));
        System.out.println(checkValidTile(tiles9));
        System.out.println(checkValidTile(tiles10));
        System.out.println(checkValidTile(tiles11));
        System.out.println(checkValidTile(tiles12));
        System.out.println(checkValidTile(tiles13)); // true
        System.out.println(checkValidTile(tiles14)); // true
        System.out.println(checkValidTile(tiles15));
        System.out.println(checkValidTile(tiles16)); // true
    }

    public static boolean checkValidTile(String tile)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (char c : tile.toCharArray())
        {
            int value = Integer.parseInt("" + c);
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        int[] pairsTriplets = new int[2];
        for (int key : map.keySet())
        {
            int freq = map.get(key);
            if (freq % 3 == 0)
            {
                map.put(key, 0);
                pairsTriplets[1] += (freq % 3 == 0 || (freq > 2) && (freq % 3) == 2) ? 1 : 0;
            } 
            else if (freq % 2 == 0)
            {
                map.put(key, 0);
                pairsTriplets[0] += (freq % 2 == 0 || (freq > 3) && (freq % 2) == 3) ? 1 : 0;
            } 
            else
            {
                if ( ((freq > 3) && ((freq - 2) % 3) == 0) || (freq > 2) && ((freq - 3) % 2) == 0)
                {
                    pairsTriplets[0] ++;
                    pairsTriplets[1] ++;
                    map.put(key, 0);
                }
            }
        }
        for (int key : map.keySet())
        {
            int freq = map.get(key);
            if (freq != 0)
            {
                return false;
            }
        }

        return pairsTriplets[0] > 0 && pairsTriplets[1] > 0 ;
    }
}
