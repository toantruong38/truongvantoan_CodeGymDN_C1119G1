package ThucHanh;

import java.util.Scanner;

public class SoNguyenTo
{
    public static void main(String[] args)
    {
        int input_number = 0;
        //int count=0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap 1 so: ");
        input_number = scanner.nextInt();
        while (true)
        {
            if (input_number == 2 || input_number == 3 || input_number == 5)
            {
                System.out.println(input_number + " la so nguyen to!");
            } else if (input_number % 2 == 0 || input_number % 3 == 0 || input_number % 5 == 0)
            {
                System.out.println(input_number + " khong la so nguyen to!");
            } else
            {
                System.out.println(input_number + " la so nguyen to!");
            }
            break;
        }
    }
}
