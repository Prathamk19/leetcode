package leet.code.challenges;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class RobotChallenge
{
    public static void main(String[] args)
    {
        RobotChallenge c = new RobotChallenge();
        int[] coordinates = c.moveRobot("LFFFRFFFRRFFF");
        System.out.println(Arrays.toString(coordinates));
    }

    int[] moveRobot(String string)
    {
        int[] coordinates = {0,0};
        for (char c : string.toCharArray())
        {
            switch (c)
            {
            case 'F':
                coordinates[1]++;
                break;
            case 'L':
                coordinates[0]++;
                break;
            case 'R':
                coordinates[0]--;
                break;
            default:
                break;
            }
        }
        return coordinates;
    }
}

class RobotChallengeTest
{
    @Test
    public void testRobot()
    {
        RobotChallenge c = new RobotChallenge();
        assertArrayEquals(new int[]{0, 2}, c.moveRobot("FF"));
    }
    
}
