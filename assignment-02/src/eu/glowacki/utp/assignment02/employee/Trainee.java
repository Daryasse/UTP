package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class Trainee extends Employee {

	private LocalDate startDay;
	private int apprenticeshipLength;
	// attributes:
	// * apprenticeship start date
	// * apprenticeship length (in days)
	
	public Trainee(String firstName, String secondName, LocalDate birthday, BigDecimal salary, Manager manager, LocalDate startDay,
	int apprenticeshipLength) {
		super(firstName, secondName, birthday, salary, manager);
		this.apprenticeshipLength = apprenticeshipLength;
		this.startDay = startDay;
	}

	public LocalDate getStartDay() {
		return startDay;
	}

	public int getApprenticeshipLength() {
		return apprenticeshipLength;
	}

	public void setApprenticeshipLength(int apprenticeshipLength) {
		this.apprenticeshipLength = apprenticeshipLength;
	}

}