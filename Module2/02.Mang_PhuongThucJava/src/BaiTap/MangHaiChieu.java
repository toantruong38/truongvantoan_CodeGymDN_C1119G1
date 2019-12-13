package BaiTap;
import java.util.Scanner;

public class MangHaiChieu {
    public static void main(String[] args) {
        double[][] doubles_arr = new double[3][5];
        double max_value = 0f;
        int row = 0, col = 0;
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < doubles_arr.length; i++) {
            for (int j = 0; j < doubles_arr[i].length; j++) {
                doubles_arr[i][j] = Math.random() * 101;
            }
        }
        max_value = doubles_arr[1][2];
        for (int i = 0; i < doubles_arr.length; i++) {
            for (int j = 0; j < doubles_arr[i].length; j++) {
                if (doubles_arr[i][j] > max_value) {
                    max_value = doubles_arr[i][j];
                    row = i;
                    col = j;
                }
                System.out.print(doubles_arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("Found max value " + max_value + " at row " + (row + 1) + " column " + (col + 1));


        //User customize;
        int row_amount = 0;
        int col_amount = 0;
        System.out.print("Enter row amount: ");
        row_amount = input.nextInt();
        System.out.print("Enter col amount: ");
        col_amount = input.nextInt();
        int[][] int_arr = new int[row_amount][col_amount];
        for (int i = 0; i < int_arr.length; i++) {
            for (int j = 0; j < int_arr[i].length; j++) {
                System.out.print("Enter value of [" + i + "]" + "[" + j + "]: ");
                int_arr[i][j] = input.nextInt();
            }
        }
        for (int[] i : int_arr) {
            for (int j : i) {
                System.out.print(j + "\t");
            }
            System.out.println();
        }
        int row_index = 0, col_index = 0;
        int max = int_arr[0][0];
        for (int i = 0; i < int_arr.length; i++) {
            for (int j = 0; j < int_arr[i].length; j++) {
                if (int_arr[i][j] > max) {
                    max = int_arr[i][j];
                    row_index = i;
                    col_index = j;
                }
            }
        }
        System.out.println("Found max value " + max + " at row " + (row_index + 1) + " col " + (col_index + 1));
    }
}
