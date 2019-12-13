import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        int choice = 0;
        Scanner input = new Scanner(System.in);
        while (choice != 4) {
            System.out.println("Menu");
            System.out.println("1.Draw the triangle");
            System.out.println("2.Draw the square");
            System.out.println("3.Draw the rectangle");
            System.out.println("4.Exit");
            System.out.println("Enter your choice:");
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    for (int i = 0; i < 6; i++) {
                        for (int j = 6 - i; j > 0; j--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    for (int i = 0; i < 6; i++) {
                        for (int j = 6; j > 0; j--) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    for (int i = 0; i < 3; i++) {
                        for (int j = 6; j > 0; j--) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
            }
        }
    }
}
