package condimentdao;

import entity.Condiment;

import java.util.ArrayList;
import java.util.List;

public class ListCondiments
{
    private static List<Condiment> condiments;
    static {
        condiments=new ArrayList<>();

        condiments.add(new Condiment("Lettuce"));
        condiments.add(new Condiment("Tomato"));
        condiments.add(new Condiment("Mustard"));
        condiments.add(new Condiment("Sprouts"));
    }

    public static ArrayList<Condiment> getCondiments(){
        ArrayList<Condiment> cdms=new ArrayList<>();
        for(Condiment c:condiments)
        {
            cdms.add(c);
        }
        return cdms;
    }
}
