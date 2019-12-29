import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamDemo
{
    public static void main(String[] args) throws IOException
    {
        FileOutputStream fos = new FileOutputStream("test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        String inputContent = "Another test content\nNewLine";
        byte[] b;
        //char[] c;
        int length = inputContent.length();
        for (int i = 0; i < length; i++)
        {
            bos.write((byte) inputContent.charAt(i));
        }
        bos.flush();
        bos.close();
        fos.close();
    }
}
