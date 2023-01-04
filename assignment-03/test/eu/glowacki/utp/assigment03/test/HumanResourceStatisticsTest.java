package eu.glowacki.utp.assigment03.test;

import eu.glowacki.utp.assignment03.HumanResourceStatistics;
import eu.glowacki.utp.assignment03.employee.Employee;
import eu.glowacki.utp.assignment03.employee.Manager;
import eu.glowacki.utp.assignment03.employee.Trainee;
import eu.glowacki.utp.assignment03.employee.Worker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class HumanResourceStatisticsTest {
    List<Employee> _allEmployees;

    @Before
    public void before() {
        _allEmployees = new ArrayList<>();

        List<Employee> levelup = new ArrayList<>();

        Manager director = new Manager("Dashka", "Zaya", LocalDate.of(1970, 1, 22), new BigDecimal(100000000),
                null, LocalDate.of(1991, 5, 6), new BigDecimal(100), levelup);
        _allEmployees.add(director);

        List<Employee> levelman1 = new ArrayList<>();

        Manager manager1 = new Manager("Masha", "Kot", LocalDate.of(1990, 5, 11), new BigDecimal(15000),
                director, LocalDate.of(2020, 7, 21), new BigDecimal(10000), levelman1);
        levelup.add(manager1);
        _allEmployees.add(manager1);

        Worker m1w1 = new Worker("Anna", "Alisha", LocalDate.of(1979, 12, 5), new BigDecimal(7500),
                manager1, LocalDate.of(1992, 10, 11), new BigDecimal(100));
        _allEmployees.add(m1w1);

        Worker m1w2 = new Worker("Adam", "Abules", LocalDate.of(1985, 10, 18), new BigDecimal(3200),
                manager1, LocalDate.of(2007, 11, 1), new BigDecimal(100));
        _allEmployees.add(m1w2);

        Trainee m1t1 = new Trainee("Mark", "Meleshko", LocalDate.of(2003, 7, 7), new BigDecimal(800),
                manager1, LocalDate.of(2007, 11, 1), 30);
        _allEmployees.add(m1t1);

        Trainee m1t2 = new Trainee("Molly", "Monoro", LocalDate.of(2002, 6, 1), new BigDecimal(780),
                manager1, LocalDate.of(2020, 8, 1), 60);
        _allEmployees.add(m1t2);

        levelman1.add(m1w1);
        levelman1.add(m1w2);
        levelman1.add(m1t1);
        levelman1.add(m1t2);

        List<Employee> levelman2 = new ArrayList<>();

        Manager manager2 = new Manager("Vlad", "Sergey", LocalDate.of(2000, 4, 30), new BigDecimal(12000),
                director, LocalDate.of(2018, 7, 4), new BigDecimal(100), levelman2);
        levelup.add(manager2);
        _allEmployees.add(manager2);

        Worker m2w1 = new Worker("Manda", "Mandova", LocalDate.of(2000, 1, 28), new BigDecimal(2900),
                manager2, LocalDate.of(2019, 6, 17), new BigDecimal(100));
        _allEmployees.add(m2w1);

        Worker m2w2 = new Worker("Ira", "Naiver", LocalDate.of(1998, 2, 4), new BigDecimal(900),
                manager2, LocalDate.of(2006, 6, 28), new BigDecimal(100));
        _allEmployees.add(m2w2);

        Worker m2w3 = new Worker("Alex", "Anutina", LocalDate.of(1967, 5, 12), new BigDecimal(6355),
                manager2, LocalDate.of(2021, 1, 1), new BigDecimal(100));
        _allEmployees.add(m2w3);

        Trainee m2t1 = new Trainee("Jakub", "Jagin", LocalDate.of(2003, 7, 7), new BigDecimal(800),
                manager2, LocalDate.of(2007, 11, 1), 90);
        _allEmployees.add(m2t1);

        Trainee m2t2 = new Trainee("Pasha", "Pashkin", LocalDate.of(2008, 3, 3), new BigDecimal(200),
                manager2, LocalDate.of(2021, 2, 2), 60);
        _allEmployees.add(m2t2);

        Trainee m2t3 = new Trainee("Lera", "Levkovskaya", LocalDate.of(1996, 12, 24), new BigDecimal(600),
                manager2, LocalDate.of(2020, 2, 1), 30);
        _allEmployees.add(m2t3);

        levelman2.add(m2w1);
        levelman2.add(m2w2);
        levelman2.add(m2w3);
        levelman2.add(m2t1);
        levelman2.add(m2t2);
        levelman2.add(m2t3);

        List<Employee> levelman3 = new ArrayList<>();

        Manager manager3 = new Manager("Vasya", "Winner", LocalDate.of(1977, 6, 12), new BigDecimal(39000),
                director, LocalDate.of(2020, 7, 4), new BigDecimal(100), levelman3);
        levelup.add(manager3);
        _allEmployees.add(manager3);

        Worker m3w1 = new Worker("Sofa", "Soneka", LocalDate.of(2001, 9, 11), new BigDecimal(2090),
                manager3, LocalDate.of(2019, 6, 17), new BigDecimal(100));
        _allEmployees.add(m3w1);

        Worker m3w2 = new Worker("Katya", "Koshin", LocalDate.of(2009, 2, 12), new BigDecimal(100),
                manager3, LocalDate.of(2019, 6, 17), new BigDecimal(100));
        _allEmployees.add(m3w2);


        Worker m3w3 = new Worker("Balencia", "Bash", LocalDate.of(1900, 1, 1), new BigDecimal(90),
                manager3, LocalDate.of(1992, 9, 9), new BigDecimal(100));
        _allEmployees.add(m3w3);

        Trainee m3t1 = new Trainee("Vikki", "Vlasenko", LocalDate.of(1996, 12, 21), new BigDecimal(600),
                manager3, LocalDate.of(2020, 2, 1), 120);
        _allEmployees.add(m3t1);

        Trainee m3t2 = new Trainee("Barbara", "Bossy", LocalDate.of(1966, 8, 3), new BigDecimal(100),
                manager3, LocalDate.of(2008, 3, 13), 60);
        _allEmployees.add(m3t2);

        Trainee m3t3 = new Trainee("Jura", "Januk", LocalDate.of(2007, 7, 7), new BigDecimal(200),
                manager3, LocalDate.of(2021, 10, 3), 90);
        _allEmployees.add(m3t3);

        levelman3.add(m3w1);
        levelman3.add(m3w2);
        levelman3.add(m3w3);
        levelman3.add(m3t1);
        levelman3.add(m3t2);
        levelman3.add(m3t3);

    }

    @Test
    public void olderThanAndEarnMore() {
        List<Employee> result = HumanResourceStatistics.olderThanAndEarnMore(_allEmployees, _allEmployees.get(0));
        Assert.assertEquals(3, result.size());
        Assert.assertEquals(_allEmployees.get(9).getFirstName(), result.get(0).getFirstName());
    }

    @Test
    public void practiceLengthLongerThan() {
        List<Trainee> result = HumanResourceStatistics.practiceLengthLongerThan(_allEmployees, 90);
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void seniorityLongerThan() {
        List<Worker> result = HumanResourceStatistics.seniorityLongerThan(_allEmployees, 30);
        Assert.assertEquals(6, result.size());
        Assert.assertEquals("Anna", result.get(1).getFirstName());
        Assert.assertEquals(new BigDecimal(300), result.get(2).getBonus());
    }

    @Test
    public void seniorityBetweenOneAndThreeYears() {
        List<Worker> result = HumanResourceStatistics.seniorityBetweenOneAndThreeYears(_allEmployees);
        Assert.assertEquals(4, result.size());
        Assert.assertEquals(new BigDecimal(2900).multiply(new BigDecimal(1.10)), result.get(1).getSalary());
        Assert.assertEquals("Sofa", result.get(2).getFirstName());
    }

    @Test
    public void seniorityLongerThan2() {
        List<Worker> result = HumanResourceStatistics.seniorityLongerThan(_allEmployees, _allEmployees.get(9));
        Assert.assertEquals(6, result.size());
        Assert.assertEquals("Manda", result.get(1).getFirstName());
        Assert.assertEquals(_allEmployees.get(9).getSalary(), result.get(1).getSalary());
    }

    @Test
    public void seniorityBetweenTwoAndFourYearsAndAgeGreaterThan() {
        List<Worker> result = HumanResourceStatistics.seniorityBetweenTwoAndFourYearsAndAgeGreaterThan(_allEmployees, 20);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("Vlad", result.get(0).getFirstName());
    }
}