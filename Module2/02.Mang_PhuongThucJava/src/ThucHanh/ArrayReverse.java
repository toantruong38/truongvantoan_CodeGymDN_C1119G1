package ThucHanh;
import java.util.Scanner;

public class ArrayReverse {
    public static void main(String[] args) {
        int[] int_arr = new int[20];
        int temp = 0;
        String result = "";
        int[] reversed_int_arr = new int[20];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < int_arr.length; i++) {
            System.out.print("Enter element " + i + ": ");
            int_arr[i] = scanner.nextInt();
        }
        System.out.println("After reverse");
        int j = 0;
        for (int i = int_arr.length - 1; i >= 0; i--) {
            reversed_int_arr[j] = int_arr[i];
            j++;
        }
        for (int i = 0; i < reversed_int_arr.length; i++) {
            result += reversed_int_arr[i] + "\n";
        }
        System.out.println(result);
    }
}
