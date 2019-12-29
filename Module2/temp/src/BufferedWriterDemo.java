import java.io.*;

public class BufferedWriterDemo
{
    public static void main(String[] args)
    {
        FileWriter fw;
        FileReader fr;
        BufferedWriter
                bw;
        BufferedReader br;
        try
        {
            fr = new FileReader("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Villa.csv");
            //fw=new FileWriter("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Villa.csv");

            br = new BufferedReader(fr);
            //bw=new BufferedWriter(fw);
            br.readLine();
            int ch;
            String output = "";
            while ((ch = br.read()) != -1)
            {
                System.out.print((char) ch);
            }
//            bw.write("new line\n");
//            bw.flush();
            System.out.print(output);

        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
