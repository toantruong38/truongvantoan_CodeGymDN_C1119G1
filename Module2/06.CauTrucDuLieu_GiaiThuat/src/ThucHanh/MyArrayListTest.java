package ThucHanh;

import BaiTap.MyArrayList;

public class MyArrayListTest
{
    public static void main(String[] args)
    {
        MyArrayList<Integer> arrayList = new MyArrayList();

        arrayList.add(13);

        arrayList.add(99);

        //attempt add more than 10 elements

        for (int i = 0; i < 20; i++)
        {
            arrayList.add((int) Math.floor(Math.random() * 101 + 1));
        }

        for (int i = 0; i < arrayList.size(); i++)
        {
            System.out.printf(arrayList.get(i) + " ");
        }
    }
}
