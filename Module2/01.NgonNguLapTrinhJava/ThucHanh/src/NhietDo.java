import java.util.Scanner;

public class NhietDo {
    public static void main(String[] args) {
        String option="1.Fahrenheit to Celsius\n" +
                        "2.Celsius to Fahrenheit\n" +
                        "0.Exit";
        int option_index=0;
        Scanner scanner=new Scanner(System.in);
        System.out.println(option);
        option_index=scanner.nextInt();
        switch (option_index)
        {
            case 1:
                double input_fah=0d;
                System.out.print("Enter Fahrenheit:");
                input_fah=scanner.nextInt();
                System.out.print("Result: "+convertToCelsius(input_fah));
                break;
            case 2:
                double input_cel=0d;
                System.out.print("Enter Celsius:");
                input_cel=scanner.nextInt();
                System.out.print("Result: "+convertToFahrenheit(input_cel));
                break;
            case 0:
                System.out.println("Closing!");
                break;
            default:
                System.out.println("Wrong key!");
        }
    }
    public static double convertToCelsius(double fahrenheit)
    {
        return (5.0/9)*(fahrenheit-32);
    }
    public static double convertToFahrenheit(double celsius)
    {
        return celsius*(9/5.0)+32;
    }
}
