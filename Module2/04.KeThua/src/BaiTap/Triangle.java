package BaiTap;

import ThucHanh.Shape;

import java.util.Scanner;

class TestTriangle
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Shape shape = new Shape();
        Triangle triangle;

        System.out.print("Enter triangle's side1: ");
        double side1 = scanner.nextDouble();
        System.out.print("Enter triangle's side2: ");
        double side2 = scanner.nextDouble();
        System.out.print("Enter triangle's side3: ");
        double side3 = scanner.nextDouble();
        triangle = new Triangle(side1, side2, side3);
        System.out.print("Enter triangle's color: ");
        String color = scanner.nextLine();
        triangle.setColor(scanner.nextLine());
        System.out.println(shape);
        System.out.println(triangle);
    }
}

public class Triangle extends Shape
{
    private double side1, side2, side3;

    public Triangle()
    {
        super();
        this.side1 = this.side2 = this.side3 = 1;
    }

    public Triangle(double side1, double side2, double side3)
    {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {return this.side1;}

    public void setSide1(double side1) {this.side1 = side1;}

    public double getSide2() {return this.side2;}

    public void setSide2(double side2) {this.side2 = side2;}

    public double getSide3() {return this.side3;}

    public void setSide3(double side3) {this.side3 = side3;}

    public double[] getSide123()
    {
        return new double[]{this.getSide1(), this.getSide2(), this.getSide3()};
    }

    public void setSide123(double side1, double side2, double side3)
    {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getArea()
    {
        return 0.25 * Math.sqrt((this.getSide1() + this.getSide2() + this.getSide3())
                * (this.getSide1() + this.getSide2() - this.getSide3())
                * (this.getSide2() + this.getSide3() - this.getSide3())
                * (this.getSide3() + this.getSide1() - this.getSide2()));
    }

    public double getPerimeter()
    {
        return this.getSide1() + this.getSide2() + this.getSide3();
    }

    @Override
    public String toString()
    {
        return "I'm a triangle. My three sides: " + this.getSide1() + " , "
                + this.getSide2() + " , " + this.getSide3()
                + "\nMy color: " + this.getColor()
                + "\nMy Area: " + this.getArea()
                + "\nMy Perimeter: " + this.getPerimeter()
                + "\n-->Here is my dad<--\n" + super.toString();
    }
}
