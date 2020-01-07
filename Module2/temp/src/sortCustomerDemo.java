import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class sortCustomerDemo
{
    public static void main(String[] args) throws IOException
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
        System.out.println(output);
        String[] strings = output.split("\\n");
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
        for (String e : strings)
        {
            System.out.println(e);
        }
    }
}
