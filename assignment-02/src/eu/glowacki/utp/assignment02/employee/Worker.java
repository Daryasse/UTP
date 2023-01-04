package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Worker extends Employee {
	private static LocalDate employmentDate;

	private BigDecimal bonus;

	// attributes
	// * employment date
	// * bonus
	
	public Worker(String firstName, String secondName, LocalDate birthday, BigDecimal salary, Manager manager,
				  LocalDate employmentDate, BigDecimal bonus) {
		super(firstName, secondName, birthday, salary, manager);
		this.employmentDate = employmentDate;
		this.bonus = bonus;
	}
	public BigDecimal getBonus(){
		return bonus;
	}
	public static LocalDate getEmploymentDate(){
		return employmentDate;
	}
	public void setBonus(BigDecimal _bonus) {
		bonus = _bonus;
	}
	public long amountOfDays(){
		return ChronoUnit.DAYS.between(getEmploymentDate(), LocalDate.now());
	}
}