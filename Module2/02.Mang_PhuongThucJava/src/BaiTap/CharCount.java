package BaiTap;

import java.util.Scanner;

public class CharCount
{
    public static void main(String[] args)
    {
        int count = 0;
        String exmp_str = "Happyy new yearrr!";
        System.out.println(exmp_str);
        char input_c;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter char: ");
        input_c = input.next().charAt(0);
        for (int i = 0; i < exmp_str.length(); i++)
        {
            if (input_c == exmp_str.charAt(i))
            {
                count++;
            }
        }
        System.out.println(input_c + " appears " + count + " time(s)!");
    }
}
