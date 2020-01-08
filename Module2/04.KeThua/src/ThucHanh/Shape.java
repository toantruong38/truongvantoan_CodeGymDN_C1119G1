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






