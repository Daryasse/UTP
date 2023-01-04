
import generators.GeneratorOfDates;
import generators.GeneratorOfPesel;
import lists.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class generator {
    private static int studentsNumber = 100;
    private static int studentsGroupsNumber = 12;
    private static int departmentsNumber = 3;
    private static int subjectsNumber = 10;
    private static int teachersNumber = 10;
    private static List<Teacher> teachers = new ArrayList<Teacher>();
    private static List <Student> students = new ArrayList<Student>();
    private static List<Department> departments = new ArrayList<Department>();
    private static List <StudentGroup> studentsGroupList;
    private static List <Subject> subjects;
    private static Random random = new Random();


    public static Student createStudents(int i) throws Exception {
        Student s = null;
        Date birthdate = GeneratorOfDates.generateDate();
        s = new Student(GeneratorOfPesel.generatePesel(birthdate), "SSurname-"+i, "SFirstName-"+i, birthdate, Nationality.random(), Student.generateStudentBookNumber());
        return s;
    }

    public static Teacher createTeachers(int i)throws Exception{
        Teacher t = null;
        Date birthdate = GeneratorOfDates.generateDate();
        t = new Teacher(GeneratorOfPesel.generatePesel(birthdate), "TSurname-"+i, "TFirstName-"+i, birthdate, Nationality.random(), academicDegree.getRandomDegree(), GeneratorOfDates.generateDate());
        return t;
    }

    public static Department createDepartments(int i){
        Department dep =  new Department("dName"+i, teachers);
        return dep;
    }

    public static StudentGroup createStudentGroups(int ii)throws Exception{
        int max = 8;
        students = listStudents();
        StudentGroup s = null;
        for (int i = 0; i < max; i++){
            s =  new StudentGroup("StudentGroupName"+ii, students.subList(i*max, i*max+max));
        }
        max = 10;
        for (int i = 8; i < max; i++){
            s =  new StudentGroup("StudentGroupName"+ii, students.subList(i*max, i*max+max));
        }
        return s;
    }

    public static Subject createSubject(int ii)throws Exception{
        Subject subj = null;
        teachers = listTeachers();
        departments = listDepartment();
        students = listStudents();
        int max = 10;
        for (int i = 0 ; i < max; i++)
            subj = new Subject("SubjName"+ii, departments.get(random.nextInt(departments.size())), teachers.get(random.nextInt(teachers.size())), students.subList(i*max, i*max+max));

        return subj;
    }

    public static List <Department> listDepartment(){
        for (int i = 0; i < departmentsNumber; i++){
            departments.add(createDepartments(i));
        }
        return departments;
    }


    public static List <Student> listStudents() throws Exception{
        for (int i = 0; i < studentsNumber; i++){
            students.add(createStudents(i));
        }
        return students;
    }

    public static List <Teacher> listTeachers()throws Exception{
        for (int i = 0; i < teachersNumber; i++){
            teachers.add(createTeachers(i));
        }
        return teachers;
    }

    public static List <StudentGroup> groupList()throws Exception{
        studentsGroupList = new ArrayList<StudentGroup>();
        for (int i = 0; i < studentsGroupsNumber; i++){
            studentsGroupList.add(createStudentGroups(i));
        }
        return studentsGroupList;
    }

    public static List <Subject> subjectList()throws Exception{
        subjects = new ArrayList<Subject>();

        for (int i = 0; i < subjectsNumber; i++){
            subjects.add(createSubject(i));
        }
        return subjects;
    }
    @Test
    public  void teachersList()throws Exception{
        teachers = generator.listTeachers();
        Assert.assertNotNull(teachers);
        Assert.assertEquals(10, teachers.size());
    }

    @Test
    public  void studentsList()throws Exception{
        students = generator.listStudents();
        Assert.assertNotNull(students);
        Assert.assertEquals(100, students.size());
    }

    @Test
    public void departmentList(){
        departments = listDepartment();
        Assert.assertNotNull(departments);
        Assert.assertEquals(3, departments.size());
    }
    @Test
    public void studentGrouplist()throws Exception{
        studentsGroupList = groupList();
        Assert.assertNotNull(studentsGroupList);
        Assert.assertEquals(12, studentsGroupList.size());
    }
    @Test
    public void listOfSubject()throws Exception{
        subjects = subjectList();
        Assert.assertNotNull(subjects);
        Assert.assertEquals(10, subjects.size());
    }

}
