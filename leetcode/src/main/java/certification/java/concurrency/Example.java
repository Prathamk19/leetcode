package certification.java.concurrency;

public class Example
{
    public static void main(String[] args)
    {
        Example ex = new Example();
        ex.testThreads();
    }

    private void testThreads()
    {
        Thread t1 = new Thread(new RunType());
        t1.start();
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }

    class RunType implements Runnable
    {
        @Override
        public void run()
        {
            for (int i = 0; i < 10; i++)
            {
                System.out.println(i);
                try
                {
                    Thread.sleep(500);
                } 
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
