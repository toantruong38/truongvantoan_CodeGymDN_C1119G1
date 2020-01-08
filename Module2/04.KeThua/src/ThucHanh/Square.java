package ThucHanh;

public class Square extends Rectangle implements Resizeable
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

    @Override
    public void resize(double percent)
    {
        this.setSide(this.getSide() * percent / 100);
    }
}
