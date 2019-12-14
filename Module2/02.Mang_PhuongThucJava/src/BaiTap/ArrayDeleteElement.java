package BaiTap;

import java.util.Scanner;

public class ArrayDeleteElement
{
    public static void main(String[] args)
    {
        int[] int_arr = new int[10];
        Scanner input = new Scanner(System.in);
        int search_value = 0;
        for (int i = 0; i < int_arr.length; i++)
        {
            int_arr[i] = (int) Math.floor(Math.random() * 101);
        }
        for (int i : int_arr)
        {
            System.out.print(i + "\t");
        }
        System.out.print("Enter search value: ");
        search_value = input.nextInt();
        for (int i = 0; i < int_arr.length; i++)
        {
            if (search_value == int_arr[i])
            {
                System.out.println("Found at " + i);
                for (int j = i; j < int_arr.length - 1; j++)
                {
                    int_arr[j] = int_arr[j + 1];
                }
                break;
            } else
            {
                System.out.println("Not found!");
            }
        }
        for (int i : int_arr)
        {
            System.out.print(i + "\t");
        }
    }
}
