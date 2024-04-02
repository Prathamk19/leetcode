package leet.code.challenges;

public class ReverseWordsString
{

    public String reverseWords(String s)
    {
        StringBuilder sb = new StringBuilder();
        String[] output = s.split(" ");
        for (int i = output.length - 1; i >= 0; i--)
        {
            if (!output[i].isEmpty())
            {
                sb.append(output[i]);
                if (i != 0)
                {
                    sb.append(" ");
                }
            }
        }
        
        boolean isEmptyEnd = sb.toString().charAt(sb.toString().length() - 1) == ' ';
        return isEmptyEnd ? sb.toString().substring(0, sb.toString().length() - 1) : sb.toString();
    }
    
    public static void main(String[] args)
    {
        ReverseWordsString rv = new ReverseWordsString();
        System.out.println(rv.reverseWords("  Bob    Loves  Alice   "));
    }
}
