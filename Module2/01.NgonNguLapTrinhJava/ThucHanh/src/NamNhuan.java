import java.util.Scanner;

public class NamNhuan {
    public static void main(String[] args) {
        int input_year = 0;
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap vao nam: ");
        input_year = scanner.nextInt();
        result += input_year;
        if (input_year % 100 == 0) {
            if (input_year % 400 == 0) {
                result += " la nam nhuan";
            } else {
                result += " khong la nam nhuan";
            }
        } else if (input_year % 4 == 0) {
            result += " la nam nhuan";
        } else {
            result += " khong phai la nam nhuan";
        }
        System.out.println(result);
    }
}
