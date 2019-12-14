package BaiTap;

import java.util.Scanner;

public class SumMatrix
{
    public static void main(String[] args)
    {
        double[][] db_arr = new double[5][5];
        double sum_01 = 0d, sum_02 = 0d;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < db_arr.length; i++)
        {
            for (int j = 0; j < db_arr[i].length; j++)
            {
                db_arr[i][j] = Math.floor(Math.random() * 90 + 10);
            }
        }
        for (double[] i : db_arr)
        {
            for (double j : i)
            {
                System.out.print(j + "\t");
            }
            System.out.println();
            System.out.println();
        }
        for (int i = 0; i < 5; i++)
        {
            sum_01 += db_arr[i][i];
        }
        int j = 0;
        for (int i = 4; i >= 0; i--)
        {
            sum_02 += db_arr[i][j];
            j++;
        }
        System.out.println("Sum01 " + sum_01);
        System.out.println("Sum02 " + sum_02);
        for (int i = 0; i < db_arr.length; i++)
        {
            for (int k = 0; k < db_arr[i].length; k++)
            {
                System.out.print("Enter element [" + i + "][" + k + "]: ");
                db_arr[i][k] = scanner.nextDouble();
            }
        }
        for (double[] i : db_arr)
        {
            for (double k : i)
            {
                System.out.print(k + "\t");
            }
            System.out.println();
            System.out.println();
        }
        sum_01 = 0;
        sum_02 = 0;
        for (int i = 0; i < 5; i++)
        {
            sum_01 += db_arr[i][i];
        }
        j = 0;
        for (int i = 4; i >= 0; i--)
        {
            sum_02 += db_arr[i][j];
            j++;
        }
        System.out.println("Sum01 " + sum_01);
        System.out.println("Sum02 " + sum_02);
    }
}
