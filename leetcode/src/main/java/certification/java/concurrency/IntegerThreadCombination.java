package certification.java.concurrency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public enum IntegerThreadCombination
{
    INSTANCE;
    
    static class MyStaticClass
    {
        public void firstMethod()
        {
            
        }
    }
    
    class MyNonStaticClass
    {
        public void firstMethod()
        {
            
        }
    }
    
    static Object obj = new Object();

    public static void main(String[] args)
    {
        MyStaticClass c = new MyStaticClass();
        c.firstMethod();
        
        MyNonStaticClass non = INSTANCE.new MyNonStaticClass();
        non.firstMethod();
        
        
        int[] arr = new int[] {5,8,1,2,6,7,3,4,1,2,3,4,5,6,7};
        List<Integer> list = new ArrayList<>();
        System.out.println("size " + arr.length);
        ConcurrentLinkedQueue<Integer> q = new ConcurrentLinkedQueue<Integer>();
        
        // Using Executor service 
//        ExecutorService es = Executors.newCachedThreadPool();
//        
//        for (int i : arr)
//        {
//            es.submit(new Runnable()
//            {
//                @Override
//                public void run()
//                {
//                    try
//                    {
//                        Thread.sleep(i * 10);
//                    } 
//                    catch (InterruptedException e)
//                    {
//                        e.printStackTrace();
//                    }
//                    q.add(i);
//                    synchronized (IntegerThreadCombination.class)
//                    {
//                        list.add(i);
//                    }
//                }
//            });
//        }
//        
//        es.shutdown();
//        try
//        {
//            es.awaitTermination(1, TimeUnit.MINUTES);
//        } 
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//        q.forEach(System.out::println);
        // list.forEach(System.out::println);
        
        for (int i : arr)
        {
            Runnable r = () -> {
                try
                {
                    Thread.sleep(i * 10);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                Collections.synchronizedList(list).add(i);
            };
            
            Thread t = new Thread(r);
            t.start();
        }
        try
        {
            Thread.currentThread().join(1000);
//            synchronized (Thread.currentThread())
//            {
//                Thread.currentThread().wait(1000);
//            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        System.out.println(list.size());
        list.forEach(System.out::println);
        
    }
}
