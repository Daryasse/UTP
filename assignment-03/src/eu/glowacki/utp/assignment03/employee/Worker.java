package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Worker extends Employee {

    private LocalDate employmentDate;

    private BigDecimal bonus;

    public Worker(String firstName, String secondName, LocalDate birthday, BigDecimal salary, Manager manager,
                  LocalDate employmentDate, BigDecimal bonus) {
        super(firstName, secondName, birthday, salary, manager);
        this.employmentDate = employmentDate;
        this.bonus = bonus;
    }
    public BigDecimal getBonus(){
        return bonus;
    }
    public LocalDate getEmploymentDate(){
        return employmentDate;
    }
    public void setBonus(BigDecimal _bonus) {
        bonus = _bonus;
    }
    public long amountOfDays(){
        return ChronoUnit.DAYS.between(getEmploymentDate(), LocalDate.now());
    }
    public long amountOfMonths(){
        return ChronoUnit.MONTHS.between(getEmploymentDate(), LocalDate.now());
    }
    public long amountOfYears(){
        return ChronoUnit.YEARS.between(getEmploymentDate(), LocalDate.now());
    }

	// (assignment 03)
	// attributes:
	// * has bonus
	//
static Worker h1 = new Worker("gin", "gun", LocalDate.of(1990,10,20),
            new BigDecimal(3466),null, LocalDate.of(2012,9,3), new BigDecimal(300) );
    Function<LocalDate, Long> seniorityInYears = (empDate) -> ChronoUnit.YEARS.between(empDate, LocalDate.now());
    Function<LocalDate, Long> seniorityInMonths = (empDate) -> ChronoUnit.MONTHS.between(empDate, LocalDate.now());

    // methods:
	// * seniority is longer than given number of years (seniority - sta�)
    Comparator<Long> bySeniority = Comparator.naturalOrder();
    public boolean seniorityLongerInYears (long number){
        return bySeniority.compare(seniorityInYears.apply(this.getEmploymentDate()), number)>0;
    }
	// * seniority is longer than given number of months
    public boolean seniorityLongerInMonths (long number){
        return bySeniority.compare(seniorityInMonths.apply(this.getEmploymentDate()), number)>0;
    }
	// * has bonus greater than given amount of money
    Predicate<Integer> isGreater = (n) -> {return n > 0;};
    public boolean bonusIsGreater (BigDecimal amount){
        int result = bonus.compareTo(amount);
        return isGreater.test(result);
    }

}