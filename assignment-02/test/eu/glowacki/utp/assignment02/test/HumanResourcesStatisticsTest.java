package eu.glowacki.utp.assignment02.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import eu.glowacki.utp.assignment02.employee.Trainee;
import eu.glowacki.utp.assignment02.employee.Worker;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import eu.glowacki.utp.assignment02.HumanResourcesStatistics;
import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;

public class HumanResourcesStatisticsTest {
	
	// Create a HR structure which resembles the below one:
	//
	// Director (an instance of Manager class (Director does not have a manager)
	//   |- Manager01
	//        |- Worker
	//        |- Worker
	//        |- Trainee
	//        |- ...
	//   |- Manager02
	//        |- ...
	//   |- ...
	//   |- Worker
	//   |- Worker
	//   |- Trainee

	
	private List<Employee> _allEmployees; // all employees ---  i.e. Workers, Trainees and their Managers and top Director (also an instance of Manager class)

	@Before
	public void before() {
		_allEmployees = new ArrayList<>();

		List<Employee> levelup = new ArrayList<>();

		//HIGHEST SALARY WITHOUT BONUS
		Manager director = new Manager("Jan","Jablik", LocalDate.of(1970,1,22),new BigDecimal(100000000),
				null, LocalDate.of(1991,5,6),new BigDecimal(100), levelup);
		_allEmployees.add(director);

		List<Employee> levelman1 = new ArrayList<>();

		//HIGHEST SALARY WITH BONUS  //SENIOR
		Manager manager1 = new Manager("Masha","Mac", LocalDate.of(1990,5,11),new BigDecimal(15000),
				director,LocalDate.of(2018,2,21),new BigDecimal(10000),levelman1);
		levelup.add(manager1);
		_allEmployees.add(manager1);

		Worker m1w1 = new Worker("Anna","Allina",LocalDate.of(1979,12,5),new BigDecimal(7500),
				manager1,LocalDate.of(1992,10,11),new BigDecimal(100));
		_allEmployees.add(m1w1);

		Worker m1w2 = new Worker("Adam","Abules",LocalDate.of(1985,10,18),new BigDecimal(3200),
				manager1,LocalDate.of(2007,11,1),new BigDecimal(100));
		_allEmployees.add(m1w2);

		Trainee m1t1 = new Trainee("Mark","Meleshko",LocalDate.of(2003,7,7),new BigDecimal(800),
				manager1,LocalDate.of(2007,11,1), 30);
		_allEmployees.add(m1t1);

		Trainee m1t2 = new Trainee("Molly","Monoro",LocalDate.of(2002,6,1),new BigDecimal(780),
				manager1,LocalDate.of(2020,8,1), 60);
		_allEmployees.add(m1t2);

		levelman1.add(m1w1);
		levelman1.add(m1w2);
		levelman1.add(m1t1);
		levelman1.add(m1t2);

		List<Employee> levelman2 = new ArrayList<>();

		Manager manager2 = new Manager("Vlad","Sergey", LocalDate.of(2000, 4, 30),new BigDecimal(12000),
				director,LocalDate.of(2016,7,4),new BigDecimal(100),levelman2);
		levelup.add(manager2);
		_allEmployees.add(manager2);

		Worker m2w1 = new Worker("Manda","Mandova",LocalDate.of(2000,1,28),new BigDecimal(2900),
				manager2,LocalDate.of(2019,6,17),new BigDecimal(100));
		_allEmployees.add(m2w1);

		Worker m2w2 = new Worker("Ira","Naiver",LocalDate.of(1998,2,4),new BigDecimal(900),
				manager2,LocalDate.of(2006,6,28),new BigDecimal(100));
		_allEmployees.add(m2w2);

		Worker m2w3 = new Worker("Alex","Anutina",LocalDate.of(1967,5,12),new BigDecimal(6355),
				manager2,LocalDate.of(2021,1,1),new BigDecimal(100));
		_allEmployees.add(m2w3);

		Trainee m2t1 = new Trainee("Jakub","Jagin",LocalDate.of(2003,7,7),new BigDecimal(800),
				manager2,LocalDate.of(2007,11,1), 90);
		_allEmployees.add(m2t1);

		Trainee m2t2 = new Trainee("Pasha","Pashkin",LocalDate.of(2008,3,3),new BigDecimal(200),
				manager2,LocalDate.of(2021,2,2), 60);
		_allEmployees.add(m2t2);

		Trainee m2t3 = new Trainee("Lera","Levkovskaya",LocalDate.of(1996,12,24),new BigDecimal(600),
				manager2,LocalDate.of(2020,2,1), 30);
		_allEmployees.add(m2t3);

		levelman2.add(m2w1);
		levelman2.add(m2w2);
		levelman2.add(m2w3);
		levelman2.add(m2t1);
		levelman2.add(m2t2);
		levelman2.add(m2t3);

		List<Employee> levelman3 = new ArrayList<>();

		Manager manager3 = new Manager("Vasya","Winner", LocalDate.of(1977,6,12),new BigDecimal(39000),
				director,LocalDate.of(2020,7,4),new BigDecimal(100),levelman3);
		levelup.add(manager3);
		_allEmployees.add(manager3);

		Worker m3w1 = new Worker("Sofa","Soneka",LocalDate.of(2001,9,11),new BigDecimal(2090),
				manager3,LocalDate.of(2019,6,17),new BigDecimal(100));
		_allEmployees.add(m3w1);

		Worker m3w2 = new Worker("Katya","Koshin",LocalDate.of(2009,2,12),new BigDecimal(100),
				manager3,LocalDate.of(2019,6,17),new BigDecimal(100));
		_allEmployees.add(m3w2);


		Worker m3w3 = new Worker("Balencia","Bash",LocalDate.of(1900,1,1),new BigDecimal(90),
				manager3,LocalDate.of(1992,9,9),new BigDecimal(100));
		_allEmployees.add(m3w3);

		Trainee m3t1 = new Trainee("Vikki","Vlasenko",LocalDate.of(1996,12,21),new BigDecimal(600),
				manager3,LocalDate.of(2020,2,1), 120);
		_allEmployees.add(m3t1);

		Trainee m3t2 = new Trainee("Barbara","Bossy",LocalDate.of(1966,8,3),new BigDecimal(100),
				manager3,LocalDate.of(2008,3,13), 60);
		_allEmployees.add(m3t2);

		Trainee m3t3 = new Trainee("Jura","Januk",LocalDate.of(2007,7,7),new BigDecimal(200),
				manager3,LocalDate.of(2021,10,3), 90);
		_allEmployees.add(m3t3);


		levelman3.add(m3w1);
		levelman3.add(m3w2);
		levelman3.add(m3w3);
		levelman3.add(m3t1);
		levelman3.add(m3t2);
		levelman3.add(m3t3);

		Worker dw1 = new Worker("Adam", "Rich", LocalDate.of(1990, 5, 23), new BigDecimal(500), director,
				LocalDate.of(2012, 6, 9), new BigDecimal(300));
		levelup.add(dw1);
		_allEmployees.add(dw1);
	}

	@Test
	public void payroll() {
		List<PayrollEntry> payroll = HumanResourcesStatistics.payroll(_allEmployees);
		Assert.assertEquals(100000100, payroll.get(0).getSalaryPlusBonus().intValue());
		Assert.assertEquals(200,payroll.get(payroll.size()-2).getSalaryPlusBonus().intValue());
	}

	@Test
	public void subordinatesPayroll() {
		Manager manager = (Manager) _allEmployees.get(1);
		List<PayrollEntry> payroll = HumanResourcesStatistics.subordinatesPayroll(manager);
		Assert.assertEquals(7600, payroll.get(0).getSalaryPlusBonus().intValue());
	}

	@Test
	public void bonusTotal() {
		BigDecimal totalBonus = HumanResourcesStatistics.bonusTotal(_allEmployees);
		Assert.assertEquals( totalBonus, new BigDecimal("11400"));
	}

	@Test
	public void longestSeniority() {
        Employee employee = HumanResourcesStatistics.longestSeniority(_allEmployees);
        Assert.assertEquals( "Jan", employee.getFirstName());
        Assert.assertEquals("Jablik", employee.getSurname() );

	}

	@Test
	public void maximalSalaryWithoutBonus() {
		BigDecimal maxSalary = HumanResourcesStatistics.MaximalSalaryWithoutBonus(_allEmployees);
		Assert.assertEquals(100000000,maxSalary.intValue());
	}

	@Test
	public void maximalSalaryIncludingBonus() {
		BigDecimal salary = HumanResourcesStatistics.maximalSalaryIncludingBonus(_allEmployees);
		Assert.assertEquals(100000100, salary.intValue());
	}

	@Test
	public void surnameStartsWithA() {
		Manager m = (Manager) _allEmployees.get(1);
		List<Employee> surnamesA = HumanResourcesStatistics.surnameStartsWithA(m);
		Assert.assertEquals(2,surnamesA.size());
	}

	@Test
	public void earnMoreThan1000() {
		List<Employee> earn1000 = HumanResourcesStatistics.earnMoreThan1000(_allEmployees);
		Assert.assertEquals(9,earn1000.size());
	}


	/// ...
	// rest of the methods specified in the assignment description
}