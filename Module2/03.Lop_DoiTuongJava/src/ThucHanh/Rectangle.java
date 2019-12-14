package ThucHanh;

import java.util.Scanner;

public class Rectangle
{
    double width, height;

    public Rectangle() {}

    public Rectangle(double width, double height)
    {
        this.height = height;
        this.width = width;
    }

    public double getArea()
    {
        return this.width * this.height;
    }

    public double getPerimeter()
    {
        return (this.width + this.height) * 2;
    }

    public String display()
    {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}

class Ex14_1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter width: ");
        double width = scanner.nextDouble();
        System.out.print("Enter height: ");

        double height = scanner.nextDouble();
        Rectangle rectangle = new Rectangle(width, height);
        System.out.println("Your Rectangle \n" + rectangle.display());
        System.out.println("Perimeter of the Rectangle: " + rectangle.getPerimeter());
        System.out.println("Area of the Rectangle: " + rectangle.getArea());
    }
}
