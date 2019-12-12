import java.util.Scanner;

public class LoiChao {
    public static void main(String[] args) {
        String input_name = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        input_name = scanner.nextLine();
        System.out.println("Hello: " + input_name);
    }
}
