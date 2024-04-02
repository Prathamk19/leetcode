package leet.code.challenges;

import java.util.HashMap;

public class GridTraveler
{
    public static void main(String[] args)
    {
        GridTraveler gd = new GridTraveler();
        gd.gridTravelerLogic(3,2);
    }

    private void gridTravelerLogic(int i, int j)
    {
        HashMap<String, Long> map = new HashMap<String, Long>();
        System.out.println(gridTravelerLogic(i, j, map));
    }

    private long gridTravelerLogic(int i, int j, HashMap<String, Long> map)
    {
        if (i == 1 && j == 1) return 1;
        if (i == 0 || j == 0) return 0;
        if (map.containsKey(i+"," +j))
            return map.get(i+"," +j);
        else if (map.containsKey(j+"," +i))
            return map.get(j+"," +i);
        long result = gridTravelerLogic(i - 1, j, map) + gridTravelerLogic(i, j - 1, map);
        map.put(i+","+j, result);
        return result;
    }

}
