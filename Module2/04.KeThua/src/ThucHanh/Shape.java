package ThucHanh;

class ShapeTest
{
    public static void main(String[] args)
    {
        Shape shape = new Shape();
        System.out.println(shape);
        shape = new Shape("red", false);
        System.out.println(shape);

        Circle circle = new Circle();
        System.out.println(circle);
        circle = new Circle(3.5);
        System.out.println(circle);
        circle = new Circle("indigo", false, 3.5);
        System.out.println(circle);

        Rectangle rectangle = new Rectangle();
        System.out.println(rectangle);
        rectangle = new Rectangle(2.3, 5.8);
        System.out.println(rectangle);
        rectangle = new Rectangle("orange", true, 2.5, 3.8);
        System.out.println(rectangle);

        Square square = new Square();
        System.out.println(square);
        square = new Square(2.3);
        System.out.println(square);
        square = new Square("yellow", true, 5.8);
        System.out.println(square);
        Circle circle1 = new Circle("Red", false, 13);
        System.out.println("Color " + circle1.getColor() + "filled " + circle1.getFilled() + "radius " + circle1.getRadius());
        Square square1 = new Square();
    }
}

public class Shape
{
    private String color;
    private boolean filled;

    public Shape()
    {
        this.color = "green";
        this.filled = true;
    }

    public Shape(String color, boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {return this.color;}

    public void setColor(String color) {this.color = color;}

    public boolean getFilled() {return this.filled;}

    public void setFilled(boolean filled) {this.filled = filled;}

    @Override
    public String toString()
    {
        return "A Shape with color of " + this.getColor() + " and "
                + (this.getFilled() ? " filled" : " not filled");
    }
}

class Circle extends Shape
{
    private double radius;

    public Circle()
    {
        super();
        this.radius = 1;
    }

    public Circle(double radius)
    {
        super();
        this.radius = radius;
    }

    public Circle(String color, boolean filled, double radius)
    {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {return this.radius;}

    public void setRadius(double radius) {this.radius = radius;}

    public double getArea()
    {
        return Math.pow(this.getRadius(), 2) * Math.PI;
    }

    public double getPerimeter()
    {
        return 2 * this.getRadius() * Math.PI;
    }

    @Override
    public String toString()
    {
        return "A Circle with radius=" + this.getRadius() + ", which is" +
                " a subclass of " + super.toString();
    }
}

class Rectangle extends Shape
{
    private double width;
    private double length;

    public Rectangle()
    {
        super();
        this.width = 1;
        this.length = 1;
    }

    public Rectangle(double width, double length)
    {
        super();
        this.width = width;
        this.length = length;
    }

    public Rectangle(String color, boolean filled, double width, double length)
    {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {return this.width;}

    public void setWidth(double width) {this.width = width;}

    public double getLength() {return this.length;}

    public void setLength(double length) {this.length = length;}

    public double getArea()
    {
        return this.getLength() * this.getWidth();
    }

    public double getPerimeter()
    {
        return (this.getLength() + this.getWidth()) * 2;
    }

    @Override
    public String toString()
    {
        return "A Rectangle with=" + this.getWidth() + " and length=" + this.getLength()
                + ", which is a subclass of " + super.toString();
    }
}

class Square extends Rectangle
{
    private double side;

    public Square(double side)
    {
        super();
        this.side = side;
    }

    public Square()
    {
        this.side = 1;
    }

    public Square(String color, boolean filled, double side)
    {
        super(color, filled, side, side);

    }

    public double getSide() {return this.side;}

    public void setSide(double side) {this.side = side;}

    @Override
    public void setLength(double side) {this.setSide(side);}

    @Override
    public void setWidth(double side) {this.setSide(side);}

    @Override
    public String toString()
    {
        return "A Square with side=" + this.getSide() + ", which is a subclass of " +
                super.toString();
    }
}
