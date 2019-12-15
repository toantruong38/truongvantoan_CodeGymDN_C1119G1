package BaiTap;

class TestPoint
{
    public static void main(String[] args)
    {
        Point point = new Point(3, 4);
        System.out.println(point);
        for (float i : point.getXY())
        {
            System.out.print(i + "\t");
        }
        MovablePoint movablePoint = new MovablePoint();
        movablePoint.setSpeed(3, 5);
        movablePoint.setXY(5, 6);
        System.out.println(movablePoint.move());
    }
}

public class Point
{
    private float x;
    private float y;

    public Point()
    {
        this.x = 0f;
        this.y = 0f;
    }

    public Point(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX() {return this.x;}

    public void setX(float x) {this.x = x;}

    public float getY() {return this.y;}

    public void setY(float y) {this.y = y;}

    public float[] getXY()
    {
        return new float[]{this.getX(), this.getY()};
    }

    public void setXY(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString()
    {
        return "(" + this.getX() + "," + this.getY() + ")";
    }
}

class MovablePoint extends Point
{
    private float xSpeed;
    private float ySpeed;

    public MovablePoint()
    {
        super();
        this.xSpeed = 0f;
        this.ySpeed = 0f;
    }

    public MovablePoint(float xSpeed, float ySpeed)
    {
        super();
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(float x, float y, float xSpeed, float ySpeed)
    {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {return this.xSpeed;}

    public void setxSpeed(float xSpeed) {this.xSpeed = xSpeed;}

    public float getySpeed() {return this.ySpeed;}

    public void setySpeed(float ySpeed) {this.ySpeed = ySpeed;}

    public float[] getSpeed()
    {
        return new float[]{this.getxSpeed(), this.getySpeed()};
    }

    public void setSpeed(float xSpeed, float ySpeed)
    {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public String toString()
    {
        return super.toString() + ",speed=(" + this.getxSpeed() + ","
                + this.getySpeed() + ")";
    }

    public MovablePoint move()
    {
        this.setX(this.getX() + this.getxSpeed());
        this.setY(this.getY() + this.getySpeed());
        return this;
    }
}
