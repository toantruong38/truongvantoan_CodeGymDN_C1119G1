package BaiTap;

class TestPoint2DClass
{
    public static void main(String[] args)
    {
        System.out.println(new Point2DClass(3, 5));
        System.out.println(new Point3DClass());
        Point3DClass point3DClass = new Point3DClass();
        point3DClass.setXYZ(3, 5, 7);
        for (float i : point3DClass.getXYZ())
        {
            System.out.print(i);
        }
    }
}

public class Point2DClass
{
    private float x;
    private float y;

    public Point2DClass()
    {
        this.x = 0f;
        this.y = 0f;
    }

    public Point2DClass(float x, float y)
    {
        this.x = x;
        this.y = y;
    }

    public float getX()
    {
        return this.x;
    }

    public void setX(float x)
    {
        this.x = x;
    }

    public float getY()
    {
        return this.y;
    }

    public void setY(float y)
    {
        this.y = y;
    }

    public float[] getXY()
    {
        return new float[]{x, y};
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

class Point3DClass extends Point2DClass
{
    private float z;

    public Point3DClass()
    {
        super();
        this.z = 0f;
    }

    public Point3DClass(float x, float y, float z)
    {
        super(x, y);
        this.z = z;
    }

    public float getZ() {return this.z;}

    public void setZ(float z) {this.z = z;}

    public float[] getXYZ()
    {
        return new float[]{this.getX(), this.getY(), this.getZ()};
    }

    public void setXYZ(float x, float y, float z)
    {
        super.setXY(x, y);
        this.z = z;
    }

    @Override
    public String toString()
    {
        return "(" + this.getX() + "," + this.getY() + "," + this.getZ() + ")";
    }
}
