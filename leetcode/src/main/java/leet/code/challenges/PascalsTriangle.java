package leet.code.challenges;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle
{
    public static void main(String[] args)
    {
        PascalsTriangle pt = new PascalsTriangle();
        System.out.println(pt.getRow(4));
    }

    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++)
        {
            list.add(getRow(rowIndex, i));
        }
        return list;
    }

    private int getRow(int row, int col)
    {
        if (row == 0 || col == 0 || row == col)
        {
            return 1;
        }
        return getRow(row - 1, col - 1) + getRow(row - 1, col);
    }
}
