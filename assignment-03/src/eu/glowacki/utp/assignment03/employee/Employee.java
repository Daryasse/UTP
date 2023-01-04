package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.Predicate;

public abstract class Employee extends Person {

    // (assignment 02)
    // attributes:
    // * salary
    // * manager (empty if at top of hierarchy)

    private BigDecimal salary;
    private Manager manager;

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

	// (assignment 03)
	// methods:
	// * salary is greater than given amount of money
    Predicate<Integer> isGreater = (n) -> {return n > 0;};
    Predicate<Integer> isLess = (n) -> {return n < 0;};

    public boolean salaryGreaterThanNumber (BigDecimal number){
        int result = salary.compareTo(number);
        return isGreater.test(result);
    }

	// * salary is less than given amount of money
    public boolean salaryLessThanNumber (BigDecimal number){
        int result = salary.compareTo(number);
        return isLess.test(result);
    }

	// * compare salary with other employee salary
    public boolean salaryLessThanEmpN (Employee emplN){
        int result = salary.compareTo(emplN.getSalary());
        return isLess.test(result);
    }

}