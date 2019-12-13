import java.util.Scanner;

public class ArrayAddE {
    public static void main(String[] args) {
        int[] int_arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i : int_arr) {
            System.out.print(i + "\t");
        }
        System.out.println();
        //String input="";
        int int_instead = 0;
        int index = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter X: ");
        int_instead = scanner.nextInt();
        System.out.print("Enter index: ");
        index = scanner.nextInt();
        if (index <= 1 && index >= int_arr.length - 1) {
            System.out.println("Cant add!");
        } else {
            for (int i = int_arr.length-1; i > index-1; i--) {
                int_arr[i]=int_arr[i-1];
            }
            int_arr[index]=int_instead;
        }
        for (int i : int_arr) {
            System.out.print(i + "\t");
        }
    }
}
