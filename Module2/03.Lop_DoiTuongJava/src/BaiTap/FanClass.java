package BaiTap;

public class FanClass
{
    private final byte SLOW = 1;
    private final byte MEDIUM = 2;
    private final byte FAST = 3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public FanClass()
    {
        this.speed = SLOW;
        this.on = false;
        this.radius = 5;
        this.color = "blue";
    }

    public int getSpeed() {return this.speed;}

    public void setSpeed(int speed) {this.speed = speed;}

    public boolean getStatus() {return this.on;}

    public void setStatus(boolean status) {this.on = status;}

    public double getRadius() {return this.radius;}

    public void setRadius(double radius) {this.radius = radius;}

    public String getColor() {return this.color;}

    public void setColor(String color) {this.color = color;}

    public String toString()
    {
        if (this.on)
        {
            return "Fan speed: " + this.getSpeed() + " color: " + this.getColor()
                    + " radius: " + this.getRadius() + " fan is on";
        } else
        {
            return "Fan color: " + this.getColor() + " radius: " + this.getRadius()
                    + " fan is off";
        }
    }
}

class FanTest
{
    public static void main(String[] args)
    {
        FanClass fan1 = new FanClass();
        FanClass fan2 = new FanClass();
        fan1.setSpeed(3);
        fan1.setRadius(10);
        fan1.setColor("yellow");
        fan1.setStatus(true);
        System.out.println(fan1.toString());
        fan2.setSpeed(2);
        fan2.setRadius(5);
        System.out.println(fan2.toString());
    }
}
