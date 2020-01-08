package BaiTap;

import ThucHanh.Circle;
import ThucHanh.Rectangle;
import ThucHanh.Square;

public class ResizeableTest
{
    public static void main(String[] args)
    {
        Circle[] circles = new Circle[3];
        Rectangle[] rectangles = new Rectangle[3];
        Square[] squares = new Square[3];

        for (int i = 0; i < 3; i++)
        {
            circles[i] = new Circle();
            rectangles[i] = new Rectangle();
            squares[i] = new Square();
        }
        for (int i = 0; i < 3; i++)
        {
            circles[i].setRadius(Math.floor(Math.random() * 101 + 1));

            rectangles[i].setWidth(Math.floor(Math.random() * 101 + 1));
            rectangles[i].setLength(Math.floor(Math.random() * 101 + 1));

            squares[i].setSide(Math.floor(Math.random() * 101 + 1));
        }

        for (int i = 0; i < 3; i++)
        {
            System.out.println("Circle");
            System.out.println(circles[i].getRadius());

            System.out.println("Rectangle");
            System.out.println(rectangles[i].getLength() + " / " + rectangles[i].getWidth());

            System.out.println("Square");
            System.out.println(squares[i].getSide());
        }

        for (int i = 0; i < 3; i++)
        {
            circles[i].resize(Math.floor(Math.random() * 101));
            rectangles[i].resize(Math.floor(Math.random() * 101));
            squares[i].resize(Math.floor(Math.random() * 101));
        }

        System.out.println("---------------Resized---------------");

        for (int i = 0; i < 3; i++)
        {
            System.out.println("Circle");
            System.out.println(circles[i].getRadius());

            System.out.println("Rectangle");
            System.out.println(rectangles[i].getLength() + " / " + rectangles[i].getWidth());

            System.out.println("Square");
            System.out.println(squares[i].getSide());
        }
    }
}
