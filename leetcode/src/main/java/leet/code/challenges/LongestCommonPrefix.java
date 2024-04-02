package leet.code.challenges;

import java.util.HashMap;


public class LongestCommonPrefix
{
    class TrieNode
    {
        boolean isLeaf = false;
        HashMap<Character, TrieNode> characters = new HashMap<Character, TrieNode>();
    }

    private void insert(String s, TrieNode head)
    {
        TrieNode curr = head;
        for (Character c : s.toCharArray())
        {
            curr.characters.putIfAbsent(c, new TrieNode());
            curr = curr.characters.get(c);
        }
        curr.isLeaf = true;
    }

    private String longestCommonPrefix(String[] str)
    {
        TrieNode head = new TrieNode();
        for (String s : str)
        {
            insert(s, head);
        }
        StringBuilder sb = new StringBuilder();

        TrieNode curr = head;
        while (!curr.isLeaf && curr.characters.size() == 1)
        {
            for (Character c : curr.characters.keySet())
            {
                sb.append(c);
                curr = curr.characters.get(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        lcp.initialize();
    }

    private void initialize()
    {
        String[] str = new String[]
        { "flower", "flow", "flight" };
        String longestPrifix = longestCommonPrefix(str);
        System.out.println(longestPrifix);
    }
}
