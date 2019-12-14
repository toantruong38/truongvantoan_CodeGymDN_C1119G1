package BaiTap;

import java.util.Scanner;

public class MinInArray
{
    public static void main(String[] args)
    {
        int[] int_arr = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < int_arr.length; i++)
        {
            System.out.print("Enter value of element[" + i + "]: ");
            int_arr[i] = scanner.nextInt();
        }
        int minValue = int_arr[0];
        for (int i : int_arr)
        {
            if (i < minValue)
            {
                minValue = i;
            }
        }
        System.out.println("Min value in array is: " + minValue);
    }
}
