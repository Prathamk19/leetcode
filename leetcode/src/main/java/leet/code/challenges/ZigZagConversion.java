package leet.code.challenges;

public class ZigZagConversion
{
    public static void main(String[] args)
    {
        ZigZagConversion zzc = new ZigZagConversion();
        System.out.println(zzc.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows)
    {
        if (s.length() == 1)
            return s;
        String t = s;
        int size = s.length();
        int ind = 0;
        while (size > 0 && numRows > 1)
        {
            if (ind % (numRows - 1) == 0)
                size -= numRows - 1;
            ind++;
            size--;
        }
        char[][] mat = new char[numRows][ind];
        ind = 0;
        int i = 0, j = 0;
        while (ind < s.length())
        {
            while ((j % (numRows - 1) == 0) && i < numRows && ind < s.length())
            {
                mat[i++][j] = t.charAt(ind++);
            }
            j++;
            i--;
            while (i > 1 && ind < s.length())
            {
                mat[--i][j++] = t.charAt(ind++); 
            }
            i = 0;
        }
        
        StringBuilder sb = new StringBuilder();
        for(i = 0; i < mat.length ; i++)
        {
            for (j = 0 ; j < mat[i].length ; j++)
            {
                if (Character.isAlphabetic(mat[i][j]) || mat[i][j] == '.' || mat[i][j] == ',')
                    sb.append(mat[i][j]);
            }
        }
        return sb.toString();
    }
}
