import java.util.Scanner;

public class Operators {
    public static void main(String[] args) {
        float height = 0f, weight = 0f;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap chieu cao: ");
        height = scanner.nextFloat();
        System.out.println("Nhap chieu rong: ");
        weight = scanner.nextFloat();
        System.out.println("Chieu cao: " + height + "\nChieu rong: " + weight + "\nDien tich: " + height * weight);
    }
}
