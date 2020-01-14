package Controllers;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

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


            //sort here

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

    public static void sortMe() throws IOException
    {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("C:\\Users\\Admin" +
                "\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data" +
                "\\Customer.csv"));
        int ch;
        String output = "";
        while ((ch = bufferedInputStream.read()) != -1)
        {
            output += (char) ch;
        }
        //System.out.println(output);
        String[] strings = output.split("\\n");
        ArrayList<String> title = new ArrayList<>();
        String[] titleArr = strings[0].split(",");
        title.addAll(Arrays.asList(titleArr));
        String[][] e_strings = new String[strings.length][];
        for (int i = 0; i < e_strings.length; i++)
        {
            e_strings[i] = strings[i].split(",");
        }
        //Find name index
        int name_index = -1;
        for (int i = 0; i < e_strings[0].length; i++)
        {
            if (e_strings[0][i].equals("fullName"))
            {
                name_index = i;
                break;
            }
        }
        //Find birth index;
        int birth_index = -1;
        for (int i = 0; i < e_strings[0].length; i++)
        {
            if (e_strings[0][i].equals("birth"))
            {
                birth_index = i;
                break;
            }
        }


        if (name_index != -1 && birth_index != -1)
        {
            for (int i = 1; i < e_strings.length - 1; i++)
            {
                if (e_strings[i][name_index].compareTo(e_strings[i + 1][name_index]) < 0)
                {
                    String temp = strings[i];
                    strings[i] = strings[i + 1];
                    strings[i + 1] = temp;
                    i = 1;
                } else if (e_strings[i][name_index].compareTo(e_strings[i + 1][name_index]) == 0)
                {
                    String[] curStr = e_strings[i][birth_index].split("/");
                    String[] forStr = e_strings[i + 1][birth_index].split("/");
                    int[] curArr = new int[curStr.length];
                    int[] forArr = new int[forStr.length];
                    for (int g = 0; g < curArr.length; g++)
                    {
                        curArr[g] = Integer.valueOf(curStr[g]);
                        forArr[g] = Integer.valueOf(forStr[g]);
                    }
                    for (int h = curArr.length - 1; h >= 0; h--)
                    {
                        if (curArr[h] > forArr[h])
                        {
                            String temp = strings[i];
                            strings[i] = strings[i + 1];
                            strings[i + 1] = temp;
                            i = 1;
                        }
                    }
                }
            }
        } else
        {
            System.out.println("Something wring with the \"Customer.csv\" file");
        }
        ArrayList<String> resultArrL = new ArrayList<>();
        for (int i = 1; i < strings.length; i++)
        {
            String[] temp = strings[i].split("\\n|(\\n\\,)|\\,");
            for (String e : temp)
            {
                resultArrL.add(e);
            }
        }
        try
        {
            int t = 0, c = 0;
            while (c < resultArrL.size())
            {
                if (t == title.size()) {t = 0;}
                System.out.print(title.get(t) + ": " + resultArrL.get(c) + "\n");
                t++;
                c++;
            }
        } catch (IndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }

        bufferedInputStream.close();

    }
}
