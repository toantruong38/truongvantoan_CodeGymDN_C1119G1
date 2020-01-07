package Libs;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class FuncWriteFileCSV
{
    private static BufferedWriter bufferedWriter;
    private static BufferedReader bufferedReader;

    public static ArrayList<Object> readFile(String url)
    {
        ArrayList<Object> formatted_data_by_line = new ArrayList<>();
        try
        {
            bufferedReader = new BufferedReader(new FileReader(url));

            int ch;
            String unformatted_data = "";
            while ((ch = bufferedReader.read()) != -1)
            {
                unformatted_data += ch;
            }
            bufferedReader.close();


            formatted_data_by_line.addAll(
                    Arrays.asList(unformatted_data.split("\\n"))
            );

        } catch (IOException e)
        {
            System.out.println("Error at \"FuncWriteFileCSV\" class, \"readFile\" function!");
        }
        return formatted_data_by_line;
    }

    public static void writeFile(String data, String url)
    {
        try
        {
            bufferedWriter = new BufferedWriter(new FileWriter(url));
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e)
        {
            System.out.printf("Error at %s class, %s function!", "FuncWriteFileCSV", "writeFile");
        }
    }
}
