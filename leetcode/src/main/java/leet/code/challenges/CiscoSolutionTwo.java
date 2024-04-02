package leet.code.challenges;

public class CiscoSolutionTwo {

	public static void main(String[] args) {
	    findTargetString("asebcseewaea", "see");
	    cnt = 0;
		findTargetStringTwo("asebcseewaea", "see");
	}

	static int cnt = 0; 
	private static void findTargetStringTwo(String string, String target)
    {
	    System.out.println(string.contains(target));
	    int index = 0;
	    String temp = string;
	    StringBuilder sb = new StringBuilder();
	    while (index < temp.length())
	    {
	        index = temp.indexOf(target.charAt(0));
	        if (index < 0)
	            break;
	        cnt++;
	        for (int i = 0; i < target.length(); i++)
	        {
	            if (temp.charAt(index + i) != target.charAt(i))
	                break;
	            else
	                sb.append(temp.charAt(index + i));
	        }
	        if (sb.toString().equals(target))
	            break;
	        else
	        {
	            temp = temp.substring(index + 1, temp.length());
	        }
	        sb = new StringBuilder();
	    }
	    System.out.println(sb.toString() + " " + cnt);
    }
	
	private static void findTargetString(String string, String target)
	{
		for (int i = 0; i < string.length(); i++)
		{
		    cnt++;
			if (string.charAt(i) == target.charAt(0))
			{
				StringBuilder sb = new StringBuilder();
				sb.append(string.charAt(i));
				for (int j = 1; j < target.length(); j++)
				{
					if (string.charAt(i + j) == target.charAt(j))
					{
						sb.append(string.charAt(i + j));
					}
				}
				if (sb.toString().equals(target))
				{
					System.out.println(sb.toString());
				}
			}
		}
		System.out.println(cnt);
	}
}
