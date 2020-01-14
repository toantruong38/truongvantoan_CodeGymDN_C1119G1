import java.util.TreeSet;

public class TreeSetDemo
{
    public static void main(String[] args)
    {
        TreeSet<String> treeSet = new TreeSet<>();

        treeSet.add("A");
        treeSet.add("a");
        treeSet.add("z");
        treeSet.add("h");
        treeSet.add("j");

        for (String item : treeSet)
        {
            System.out.println(item);
        }

        TreeSet<Student> students = new TreeSet<>();
        Student toan = new Student();
        toan.setStudentName("Toan");
        Student huy = new Student();
        huy.setStudentName("Huy");
        Student phong = new Student();
        phong.setStudentName("Phong");

        students.add(toan);
        students.add(huy);
        students.add(phong);

        for (Student item : students)
        {
            System.out.println(item.getStudentName());
        }
    }
}
