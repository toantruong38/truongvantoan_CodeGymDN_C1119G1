package BaiTap;

import java.util.Arrays;

public class MyArrayList<E>
{
//    private int size=0;
//
//    private static final int DEFAULT_CAPACITY=10;
//
//    private Object[] elements;
//
//    public MyArrayList()
//    {
//        this.elements=new Object[DEFAULT_CAPACITY];
//    }
//    public MyArrayList(int capacity)
//    {
//        this.elements=new Object[capacity];
//    }
//
//    public void add(int index, Object element)
//    {
//        try
//        {
//            elements[index] = element;
//        }catch(IndexOutOfBoundsException e)
//        {
//            e.printStackTrace();
//        }
//    }
//    public Object remove(int index)
//    {
//        Object removed_element=null;
//
//        try
//        {
//            removed_element=elements[index];
//            for(int i=index;i<this.size-1;i++)
//            {
//                elements[i]=elements[i+1];
//            }
//        }catch(IndexOutOfBoundsException e)
//        {
//            e.printStackTrace();
//        }
//        return removed_element;
//    }
//    public int size()
//    {
//        return this.elements.length;
//    }
//    public Object[] clone()
//    {
//        return this.elements;
//    }
//    public boolean contains(Object o)
//    {
//        try
//        {
//            for(int i=0;i<this.size;i++)
//            {
//                if(elements[i].equals(o))
//                {
//                    return true;
//                }
//            }
//        }catch(IndexOutOfBoundsException e)
//        {
//            e.printStackTrace();
//        }
//        return false;
//    }
//    public int indexOf(Object o)
//    {
//        for(int i=0;i<this.size();i++)
//        {
//            if(elements[i].equals(o))
//            {
//                return i;
//            }
//        }
//        return -1;
//    }
//    public boolean add(Object e)
//    {
//        try
//        {
//            this.elements[this.size()]=e;
//            return true;
//        }catch(IndexOutOfBoundsException exc)
//        {
//            exc.printStackTrace();
//        }
//        return false;
//    }
//    public void ensureCapacity(int minCapacity)
//    {
//        elements=Arrays.copyOf(elements,minCapacity);
//    }
//    public Object get(int i)
//    {
//        try
//        {
//            return elements[i];
//        }catch(IndexOutOfBoundsException e)
//        {
//            e.printStackTrace();
//        }
//        return -1;
//    }
//    public void clear()
//    {
//        this.elements=new Object[this.DEFAULT_CAPACITY];
//    }

    private static final int DEFAULT_CAPACITY = 10;
    private int size = 0;
    private Object[] elements;

    public MyArrayList()
    {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int capacity)
    {
        this.elements = new Object[capacity];
    }

    public void add(int index, E element)
    {
        if (this.size == this.elements.length)
        {
            //call the ensure function

            this.ensureCapacity(DEFAULT_CAPACITY);
        }


        this.elements[index] = element;

        this.size++;
    }

    public E remove(int index)
    {
        // --?--

        E remove_element = (E) this.elements[index];

        for (int i = index; i < this.size - 1; i++)
        {
            this.elements[i] = this.elements[i + 1];
        }

        this.size--;

        return remove_element;
    }

    public int size()
    {
        return this.size;
    }


    public E clone()
    {
        return (E) this.elements;
    }

    public boolean contains(E element)
    {
        for (int i = 0; i < this.size; i++)
        {
            if (element == this.elements[i])
            {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E element)
    {
        for (int i = 0; i < this.size; i++)
        {
            if (element == this.elements[i])
            {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E element)
    {
        try
        {
            if (this.size == this.elements.length)
            {
                //call the ensure function

                this.ensureCapacity(DEFAULT_CAPACITY);
            }
            this.elements[this.size++] = element;
            return true;
        } catch (Exception err)
        {
            return false;
        }
    }

    public void ensureCapacity(int minCapacity)
    {
        this.elements = Arrays.copyOf(elements, this.size + minCapacity);
    }

    public E get(int index)
    {
        return (E) this.elements[index];
    }

    public void clear()
    {
        this.elements = new Object[DEFAULT_CAPACITY];
    }
}
