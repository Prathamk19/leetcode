package leet.code.challenges;

public class SetMatrixZeroes
{
    public void setZeroes(int[][] matrix)
    {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (matrix[i][j] == 0)
                {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (rows[i] == true || cols[j] == true)
                {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args)
    {
        SetMatrixZeroes s = new SetMatrixZeroes();
        s.setZeroes(new int[][]
        {
                { 0, 1, 2, 0 },
                { 3, 4, 5, 2 },
                { 1, 3, 1, 5 } });
        
        s.setZeroes(new int[][] {{1,1,1},{1,0,1},{1,1,1}});
    }
}
