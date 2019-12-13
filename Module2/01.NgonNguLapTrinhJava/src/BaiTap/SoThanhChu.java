package BaiTap;
import java.util.Scanner;

public class SoThanhChu {
    public static void main(String[] args) {
        int input_number = 0;
        String result = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap 1 so: ");
        input_number = scanner.nextInt();
        int hangTram = 0, hangChuc = 0, hangDonVi = 0;
        hangTram = input_number / 100;
        hangChuc = (input_number - hangTram * 100) / 10;
        hangDonVi = input_number % 10;
        //System.out.print(hangTram+"/"+hangChuc+"/"+hangDonVi);
        if (hangTram > 0) {
            switch (hangTram) {
                case 1:
                    result += "one hundred";
                    break;
                case 2:
                    result += "two hundred";
                    break;
                case 3:
                    result += "three hundred";
                    break;
                case 4:
                    result += "four hundred";
                    break;
                case 5:
                    result += "five hundred";
                    break;
                case 6:
                    result += "six hundred";
                    break;
                case 7:
                    result += "seven hundred";
                    break;
                case 8:
                    result += "eight hundred";
                    break;
                case 9:
                    result += "nine hundred";
                    break;
            }
        }
        if (hangChuc > 1) {
            result += " and ";
            switch (hangChuc) {
                case 2:
                    result += "twenty";
                    break;
                case 3:
                    result += "thirty";
                    break;
                case 4:
                    result += "forty";
                    break;
                case 5:
                    result += "fifty";
                    break;
                case 6:
                    result += "sixty";
                    break;
                case 7:
                    result += "seventy";
                    break;
                case 8:
                    result += "eighty";
                    break;
                case 9:
                    result += "ninety";
                    break;
            }
        } else if (hangChuc == 1) {
            result += " and ";
            switch (hangDonVi) {
                case 0:
                    result += "ten";
                    break;
                case 1:
                    result += "eleven";
                    break;
                case 2:
                    result += "twelve";
                    break;
                case 3:
                    result += "thirteen";
                    break;
                case 4:
                    result += "fourteen";
                    break;
                case 5:
                    result += "fifteen";
                    break;
                case 6:
                    result += "sixteen";
                    break;
                case 7:
                    result += "seventeen";
                    break;
                case 8:
                    result += "eighteen";
                    break;
                case 9:
                    result += "nineteen";
                    break;
            }
        }
        if (hangTram > 0 && hangChuc == 0 && hangDonVi > 0) {
            result += " and ";
        }
        if (hangDonVi > 0 && hangChuc != 1) {
            switch (hangDonVi) {
                case 0:
                    result += "zero";
                    break;
                case 1:
                    result += "one";
                    break;
                case 2:
                    result += "two";
                    break;
                case 3:
                    result += "three";
                    break;
                case 4:
                    result += "four";
                    break;
                case 5:
                    result += "five";
                    break;
                case 6:
                    result += "six";
                    break;
                case 7:
                    result += "seven";
                    break;
                case 8:
                    result += "eight";
                    break;
                case 9:
                    result += "nine";
                    break;
            }
        }
        System.out.println(result);
    }
}
