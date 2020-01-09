package BaiTap;

public class MyLinkedListTest
{
    public static void main(String[] args)
    {
        MyLinkedList<Object> myLinkedList = new MyLinkedList<>();

        int i = -1;
        //myLinkedList.addFirst(99);
        while (i++ < 10)
        {
            myLinkedList.add(i);
        }
        i = -1;
        while (i++ < 10)
        {
            System.out.println(myLinkedList.get(i));
        }
    }
}
