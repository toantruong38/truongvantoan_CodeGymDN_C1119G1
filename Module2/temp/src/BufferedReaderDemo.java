import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo
{
    public static void main(String[] args) throws IOException
    {
        FileReader fr = new FileReader("C:\\Users\\Admin\\Downloads\\Documents\\CodeGym\\truongvantoan_CodeGymDN_C1119G1\\Module2\\CaseStudy\\src\\Data\\Villa.csv");
        BufferedReader br = new BufferedReader(fr);
        //BufferedInputStream bis=new BufferedInputStream(new FileInputStream("test.txt"));
        String firstLine = br.readLine();
        int ch;
        while ((ch = br.read()) != -1)
        {
            System.out.print((char) ch);
        }
        //System.out.print(firstLine);
        br.close();
        fr.close();
    }
}
