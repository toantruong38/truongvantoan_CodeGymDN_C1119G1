package ThucHanh;

public class Rectangle extends Shape implements Resizeable
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

    @Override
    public void resize(double percent)
    {
        this.setLength(this.getLength() * percent / 100);
        this.setWidth(this.getWidth() * percent / 100);
    }
}
