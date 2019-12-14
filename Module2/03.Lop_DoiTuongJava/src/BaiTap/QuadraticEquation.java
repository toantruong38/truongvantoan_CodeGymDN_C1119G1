package BaiTap;

import java.util.Scanner;

public class QuadraticEquation
{
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getDiscriminant()
    {
        return b * b - 4 * a * c;
    }

    public double getRoot1()
    {
        return (-b + Math.sqrt(this.getDiscriminant())) / (2 * a);
    }

    public double getRoot2()
    {
        return (-b - Math.sqrt(this.getDiscriminant())) / (2 * a);
    }
}

class Test
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a, b, c;
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        c = scanner.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() > 0)
        {
            System.out.println("The equation has two roots " + quadraticEquation.getRoot1()
                    + " and " + quadraticEquation.getRoot2());
        } else if (quadraticEquation.getDiscriminant() == 0)
        {
            System.out.println("The equation has one root " + quadraticEquation.getRoot1());
        } else
        {
            System.out.println("The equation has no roots");
        }
    }
}
