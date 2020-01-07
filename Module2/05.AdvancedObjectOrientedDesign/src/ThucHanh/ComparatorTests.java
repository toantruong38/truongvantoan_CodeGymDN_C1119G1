package ThucHanh;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparatorTests
{
    public static void main(String[] args)
    {
        ArrayList<Circle> circles = new ArrayList<>();
        for (int i = 0; i < 5; i++)
        {
            circles.add(new Circle());
            circles.get(i).setRadius(Math.floor(Math.random() * 10 + 1));
        }
        for (Circle circle : circles)
        {
            System.out.printf(circle.getRadius() + "\t");
        }
        System.out.println("Sorting");

        Collections.sort(circles, new SortByRadius());

        for (Circle circle : circles)
        {
            System.out.printf(circle.getRadius() + "\t");
        }
    }

}

class SortByRadius implements Comparator<Circle>
{

    @Override
    public int compare(Circle o1, Circle o2)
    {
        return (int) (o1.getRadius() - o2.getRadius());
    }
}
