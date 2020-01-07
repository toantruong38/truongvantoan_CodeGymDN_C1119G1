import java.util.*;

public class IteratorDemo
{
    public static void main(String[] args)
    {
        //testEnumeration();
        //testIterator();
        testListIterator();
    }

    public static void testEnumeration()
    {
        Vector vector = new Vector<Integer>();
        for (int i = 0; i < 5; i++)
        {
            vector.addElement(i);
        }
        System.out.print(vector);
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements())
        {
            System.out.print(enumeration.nextElement());
        }
    }

    public static void testIterator()
    {
        ArrayList arrL = new ArrayList();
        for (int i = 0; i < 10; i++)
        {
            arrL.add(i);
        }
        Iterator iterator = arrL.iterator();
        while (iterator.hasNext())
        {
            System.out.print(iterator.next() + " ");
        }
    }

    public static void testListIterator()
    {
        ArrayList arrL = new ArrayList();
        for (int i = 0; i < 10; i++)
        {
            arrL.add(i);
        }
        ListIterator lIter = arrL.listIterator();
        while (lIter.hasNext())
        {
            System.out.print(lIter.next() + " ");
        }
        System.out.println();
        while (lIter.hasPrevious())
        {
            System.out.print(lIter.previous() + " ");
            //System.out.print(lIter.previousIndex()+" ");
        }
    }
}