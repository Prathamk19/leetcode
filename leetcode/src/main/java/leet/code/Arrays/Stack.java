package leet.code.Arrays;

public class Stack<T>
{
    private Object[] objects;
    private int index = -1;
    
    public Stack()
    {
        objects = new Object[5];
    }
    
    public boolean push(T item)
    {
        if (index == objects.length - 1)
            increaseArray();
        objects[++index] = item;
        return true;
    }

    private void increaseArray()
    {
        Object[] newArr = new Object[objects.length * 2];
        System.arraycopy(objects, 0, newArr, 0, objects.length);
        objects = newArr;
    }
    
    @SuppressWarnings("unchecked")
    public T pop()
    {
        if (index < 0)
            throw new IndexOutOfBoundsException();
        if (index > 0 && index * 5 < objects.length)
            decreaseArray();
        return (T) objects[index--];
    }

    private void decreaseArray()
    {
        Object[] newArr = new Object[objects.length / 3];
        System.arraycopy(objects, 0, newArr, 0, newArr.length);
    }
    
    public static void main(String[] args)
    {
        Stack<Integer> s = new Stack<Integer>();
        System.out.println(s.push(5));
        System.out.println(s.push(9));
        System.out.println(s.push(4));
        System.out.println(s.push(87));
        System.out.println(s.push(55));
        System.out.println(s.push(12));
        System.out.println(s.push(33));
        System.out.println(s.index);
        System.out.println(s.objects.length);
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}
