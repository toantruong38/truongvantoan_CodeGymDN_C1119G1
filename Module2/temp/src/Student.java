import java.util.Arrays;
import java.util.Comparator;

public class Student implements Comparable<Student>
{
    private String studentName;
    private int studentScore;

    public Student() {}

    public String getStudentName() {return this.studentName;}

    public void setStudentName(String name)
    {
        this.studentName = name;
    }

    public int getStudentScore() {return this.studentScore;}

    public void setStudentScore(int score)
    {
        this.studentScore = score;
    }

    @Override
    public int compareTo(Student o)
    {
        return this.getStudentName().compareTo(o.getStudentName());
    }

    static class SortByScore implements Comparator<Student>
    {

        @Override
        public int compare(Student o1, Student o2)
        {
            return o1.getStudentScore() - o2.getStudentScore();
        }
    }
}

class StudentSortTest
{
    public static void main(String[] args)
    {
        Student[] students = new Student[5];
        for (int i = 0; i < 5; i++)
        {
            students[i] = new Student();
            students[i].setStudentScore((int) Math.floor(Math.random() * 10 + 1));
        }
        //Unsorted
        for (Student student : students)
        {
            System.out.println(student.getStudentScore());
        }
        //sorting

        Arrays.sort(students, new Student.SortByScore());
        System.out.println("Sorting...");
        for (Student student : students)
        {
            System.out.println(student.getStudentScore());
        }
    }
}
