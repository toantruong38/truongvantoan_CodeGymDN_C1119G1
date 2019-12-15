package ThucHanh;

import java.util.Scanner;

public class DaysInMonth
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String user_option = "";
        System.out.print("Enter a month: ");
        user_option = scanner.nextLine();
        switch (user_option)
        {
            case "1":
            case "3":
            case "5":
            case "7":
            case "8":
            case "10":
            case "12":
                System.out.println("Thang " + user_option + " co 31 ngay!");
                break;
            case "2":
                System.out.println("Thang " + user_option + " co 28/29 ngay!");
                break;
            case "11":
            case "6":
            case "9":
            case "4":
                System.out.println("Thang " + user_option + " co 30 ngay!");
                break;
            default:
                System.out.println("Loi!");
        }
    }
}
