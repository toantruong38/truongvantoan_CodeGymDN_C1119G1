package Controllers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FuncReadFileCSV
{
    public static void main(String url)
    {
        FileReader fr;
        BufferedReader br;

        ArrayList<String> title = new ArrayList<String>(20);
        ArrayList<String> content = new ArrayList<String>(40);
        try
        {
            fr = new FileReader(url);
            br = new BufferedReader(fr);
            String[] firstLine = br.readLine().split("\\n|(\\n\\,)|\\,");
            for (String i : firstLine)
            {
                title.add(i);
            }
            int ch;
            String oneByOne = "";
            while ((ch = br.read()) != -1)
            {
                oneByOne += (char) ch;
            }
            String[] data = oneByOne.split("\\n|(\\n\\,)|\\,");
            for (String i : data)
            {
                content.add(i);
            }
            try
            {
                int t = 0, c = 0;
                while (c < content.size())
                {
                    if (t == title.size()) {t = 0;}
                    System.out.print(title.get(t) + ": " + content.get(c) + "\n");
                    t++;
                    c++;
                }
            } catch (IndexOutOfBoundsException e)
            {
                e.printStackTrace();
            }
            br.close();
            fr.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}
