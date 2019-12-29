import java.util.ArrayList;

public class ArrLDemo
{
    public static void main(String[] args)
    {
        ArrayList<String> arrL = new ArrayList<String>();
        arrL.add("First");
        System.out.println(arrL);
        try
        {
            arrL.add("Second");
        } catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        System.out.println(arrL);
        String test = "toan,huy";
        for (String i : test.split(","))
        {
            System.out.println(i);
        }
        System.out.print("size " + arrL.size());
        test = "toan,huy\ntuan";
        String[] result = test.split("\\n|(\\n\\,)|\\,");
        for (String i : result)
        {
            System.out.println(i);
        }
        //System.out.print("test "+arrL.get(arrL.size()));
        String serviceName = "Villa vip";
        String regexp = "^[A-Z][a-z]*($|([\\s][A-Z][a-z]*)+$)";
        System.out.println(serviceName.matches(regexp));
    }
}
