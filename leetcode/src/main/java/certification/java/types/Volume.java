package certification.java.types;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Volume implements Comparable<Double>
{
    // public final double liter;
    Boolean b = Boolean.FALSE;
    
    public Volume()
    {
        System.out.println("Super");
//        liter = val + Math.PI;
    }

    public static void main(String[] args)
    {
        Thread t = new Thread(() -> {
            System.out.println("New Thread ...");
        } );
        t.start();
        String[] cl = {"blue", "red", "orange", "green", "yellow"};
        List<String> l1 = Arrays.asList(cl);
        System.out.println(l1.getClass().getName());
        ArrayList<String> al = new ArrayList<String>(l1);
        System.out.println(al.getClass().getName());
        al.forEach((s) -> System.out.println(s));
        String[] narr = al.toArray(new String[0]);
        System.out.println(Arrays.toString(narr));
    }

    @Override
    public int compareTo(Double o)
    {
        // TODO Auto-generated method stub
        return 0;
    }
}
