package eu.glowacki.utp.assignment02.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public abstract class Employee extends Person {
  private BigDecimal salary;
  private Manager manager;
	//
	// attributes:
	// * salary (use BigDecimal type for representing currency values)
	// * manager (empty if at top of hierarchy)
	
	protected Employee(String firstName, String secondName, LocalDate birthday, BigDecimal salary, Manager manager) {
		super(firstName, secondName, birthday);
		this.salary = salary;
		this.manager = manager;
	}
	public BigDecimal getSalary(){
		return salary;
	}
	 public Manager getManager(){
		return manager;
	 }
	public void setSalary(BigDecimal _salary) {
		salary = _salary;
	}
	public void setManager(Manager _manager) {
		manager = _manager;
	}


}