package BaiTap;
import java.util.Scanner;

public class ArrayMerge {
    public static void main(String[] args) {
        int[] first_int_arr = new int[3];
        int[] second_int_arr = new int[4];
        int[] merged_int_arr = new int[7];
        Scanner input = new Scanner(System.in);
        System.out.println("First array!");
        for (int i = 0; i < first_int_arr.length; i++) {
            System.out.print("Enter element [" + i + "]: ");
            first_int_arr[i] = input.nextInt();
            merged_int_arr[i] = first_int_arr[i];
        }
        System.out.println("Second array!");
        for (int j = 0; j < second_int_arr.length; j++) {
            System.out.print("Enter element [" + j + "]: ");
            second_int_arr[j] = input.nextInt();
            merged_int_arr[second_int_arr.length - 1 + j] = second_int_arr[j];
        }
        System.out.println("Merged array!");
        for (int i : merged_int_arr) {
            System.out.print(i + "\t");
        }
    }
}
