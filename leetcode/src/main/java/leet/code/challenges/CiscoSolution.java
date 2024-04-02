package leet.code.challenges;

import java.util.HashMap;

public class CiscoSolution {

	// "abcdsabc"
	public static void main(String[] args) {
		System.out.println(checkFirstChar("inNterview"));
	}

	private static char checkFirstChar(String string) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : string.toCharArray())
		{
			if (map.containsKey(c))
				map.put(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}
		for (char c : string.toCharArray())
		{
			if (map.get(c) == 1)
				return c;
		}
		return 0;
	}
}
