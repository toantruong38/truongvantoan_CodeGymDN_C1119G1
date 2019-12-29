import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamDemo
{
    public static void main(String[] args) throws IOException
    {
        FileInputStream fis = new FileInputStream("test.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        if (bis.markSupported())
        {
            bis.mark(bis.available());
        }
        int ch;
        while ((ch = bis.read()) != -1)
        {
            System.out.print((char) ch);
        }
        bis.close();
        fis.close();
    }
}
