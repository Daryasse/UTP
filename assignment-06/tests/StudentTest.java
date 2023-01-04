import extents.Students;
import generators.GeneratorOfDates;
import generators.GeneratorOfPesel;
import lists.Nationality;
import lists.Person;
import lists.Student;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class StudentTest {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
            Date[] dates = new Date[6];
            for (int i = 0; i < dates.length; i++) {
                dates[i] = GeneratorOfDates.generateDate();
            }
            Student stu1b = new Student(GeneratorOfPesel.generatePesel(dates[0]), "Сипович","Яна", dates[0], Nationality.Belarussian, Student.generateStudentBookNumber());
            students.add(stu1b);
            Student stu2b = new Student(GeneratorOfPesel.generatePesel(dates[1]), "Бондаренко","Олег", dates[1], Nationality.Belarussian, Student.generateStudentBookNumber());
            students.add(stu2b);
            Student stu3b = new Student(GeneratorOfPesel.generatePesel(dates[2]), "Зупор","Дарья", dates[2], Nationality.Belarussian, Student.generateStudentBookNumber());
            students.add(stu3b);
            Student stu4a = new Student(GeneratorOfPesel.generatePesel(dates[3]), "Smith","Mark", dates[3], Nationality.British, Student.generateStudentBookNumber());
            students.add(stu4a);
            Student stu5a = new Student(GeneratorOfPesel.generatePesel(dates[4]), "Willy","Van", dates[4], Nationality.British, Student.generateStudentBookNumber());
            students.add(stu5a);
            Student stu6b = new Student(GeneratorOfPesel.generatePesel(dates[5]), "Чегиевич","Василий", dates[5], Nationality.Belarussian, Student.generateStudentBookNumber());
            students.add(stu6b);
        }

    @Test
    public void test() {
        List<Person> belarStu = Students.filterByNationality(Nationality.Belarussian);
        for (int i = 0; i < belarStu.size(); i++) {
            System.out.println(belarStu.get(i));
        }
        Assert.assertEquals(4, belarStu.size());
    }
}