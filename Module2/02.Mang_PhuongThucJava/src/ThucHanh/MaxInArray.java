package ThucHanh;
import java.util.Scanner;

public class MaxInArray {
    public static void main(String[] args) {
        int[] int_arr = new int[20];
        //int input_element=0;
        String result = "";
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < int_arr.length; i++) {
            System.out.print("Enter element number " + i + ": ");
            int_arr[i] = scanner.nextInt();
        }
        int max = int_arr[0];
        for (int i = 0; i < int_arr.length; i++) {
            if (max < int_arr[i]) {
                max = int_arr[i];
                result = "Max number in array is " + max + " at position " + i;
            }
        }
        System.out.println(result);
    }
}
