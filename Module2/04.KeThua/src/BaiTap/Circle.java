package BaiTap;

class TestCircle
{
    public static void main(String[] args)
    {
        Cylinder cylinder = new Cylinder(13, 5);
        System.out.println(cylinder);
    }
}

public class Circle
{
    private String color;
    private double radius;

    public Circle()
    {
        this.radius = 1;
        this.color = "Red";
    }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public Circle(double radius, String color)
    {
        this.radius = radius;
        this.color = color;
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

    public String getColor() {return this.color;}

    public void setColor(String color) {this.color = color;}

    @Override
    public String toString()
    {
        return "Hi, im Circle. My radius is: " + this.getRadius() +
                "my color is: " + this.getColor() +
                ", my Area is: " + this.getArea() +
                ", my perimeter is: " + this.getPerimeter();
    }
}

class Cylinder extends Circle
{
    //private double radius;
    private double height;
    //private String color;

    public Cylinder()
    {
        super();
        this.height = 0;
    }

    public Cylinder(double radius, double height)
    {
        super(radius);
        //this.radius = radius;
        this.height = height;
    }

    public Cylinder(double radius, double height, String color)
    {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {return this.height;}

    public void setHeight(double height) {this.height = height;}

    public double getValue()
    {
        return super.getArea() * this.getHeight();
    }

    @Override
    public String toString()
    {
        return "Hi, im Cylinder. My radius is: " + this.getRadius() +
                "my color is: " + this.getColor() +
                ",my value is: " + this.getValue();
    }
}
