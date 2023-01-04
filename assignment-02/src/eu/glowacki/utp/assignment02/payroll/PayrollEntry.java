package eu.glowacki.utp.assignment02.payroll;

import java.math.BigDecimal;

import eu.glowacki.utp.assignment02.employee.Employee;

public final class PayrollEntry {

	private final Employee _employee;
	private BigDecimal _salaryPlusBonus;
	
	public PayrollEntry(Employee employee, BigDecimal salary, BigDecimal bonus) {
		_employee = employee;
		if ((!salary.equals(null)) && (bonus!=null) ) {
			_salaryPlusBonus = salary.add(bonus); // validate whether salary and bonus are not null
		}
	}

	public BigDecimal getSalaryPlusBonus() {
		return _salaryPlusBonus;
	}
}