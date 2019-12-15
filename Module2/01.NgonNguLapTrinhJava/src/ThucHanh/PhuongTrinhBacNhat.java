package ThucHanh;

import java.util.Scanner;

public class PhuongTrinhBacNhat
{
    public static void main(String[] args)
    {
        // f(x): ax+b=0
        Scanner scanner = new Scanner(System.in);
        float num_a = 0f, num_b = 0f;
        String result = "";
        System.out.print("Nhap so a: ");
        num_a = scanner.nextFloat();
        System.out.print("Nhap so b: ");
        num_b = scanner.nextFloat();
        if (num_a == 0)
        {
            if (num_b == 0)
            {
                result += "Phuong trinh vo so nghiem";
            } else
            {
                result += "Phuong trinh vo nghiem";
            }
        } else
        {
            result += "Phuong trinh co nghiem x=" + (-num_b / num_a);
        }
        System.out.println(result);
    }
}
