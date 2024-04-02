package leet.code.challenges;

import java.util.Arrays;

public class StringCompressionOne
{

    public char[] compress(char[] chars) {
        int i = 0;
        int index = 0;
        while (i < chars.length)
        {
            int j = i;
            while (j < chars.length && chars[i] == chars[j])
            {
                j++;
            }
            
            chars[index++] = chars[i];
            if (j - i > 1)
            {
                String count = j - i + "";
                for (char c : count.toCharArray())
                {
                    chars[index++] = c;
                }
            }
            i = j;
        }
        
        System.out.println(Arrays.toString(chars));
        // decompress(Arrays.copyOfRange(chars, 0, index));
        
        return Arrays.copyOfRange(chars, 0, index);
    }
    
    // TODO
//    public char[] decompress(char[] chars)
//    {
//        int i = 0;
//        int index = 0;
//        
//        while (i < chars.length)
//        {
//            int j = i;
//            while (j < chars.length && )
//        }
//        
//        return chars;
//    }
    
    public static void main(String[] args)
    {
        StringCompressionOne s = new StringCompressionOne();
        System.out.println(s.compress(new char[] {'a','a','b','b','c','c','c'}));
    }
}
