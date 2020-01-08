package ThucHanh;

public class Circle extends Shape implements Resizeable
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

    @Override
    public void resize(double percent)
    {
        this.setRadius(this.getRadius() * percent / 100);
    }
}
