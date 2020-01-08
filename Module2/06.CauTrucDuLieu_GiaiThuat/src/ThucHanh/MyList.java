package ThucHanh;

import java.util.Arrays;

public class MyList
{
    private final static int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public MyList()
    {
        elements = new Object[DEFAULT_CAPACITY];
    }

    public boolean add(Object e)
    {
        if (size == elements.length)
        {
            ensureCapa();
        }
        elements[size++] = e;
        return true;
    }

    public void ensureCapa()
    {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public Object get(int i)
    {
        if (i < 0 || i >= elements.length)
        {
            return "Out of index";
        }
        return elements[i];
    }
}
