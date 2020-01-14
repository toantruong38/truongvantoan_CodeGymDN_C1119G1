import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapDemo
{
    public static void main(String[] args)
    {
        Map<String, Student> studentMap = new HashMap<>();

        Student toan = new Student();
        toan.setStudentName("TOan");

        Student phong = new Student();
        phong.setStudentName("Phong");

        Student huy = new Student();
        huy.setStudentName("Huy");

        studentMap.put("001", toan);
        studentMap.put("002", huy);
        studentMap.put("003", phong);


        Iterator myStudents = studentMap.values().iterator();

        while (myStudents.hasNext())
        {
            System.out.println(((Student) myStudents.next()).getStudentName());
        }
    }
}
