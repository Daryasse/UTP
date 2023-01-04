package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.function.BiPredicate;

public class Trainee extends Employee {

    // (assignment 02)
    // attributes:
    // * practice start date
    // * practice length (in days)

    private LocalDate startDay;
    private int apprenticeshipLength;

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

    // (assignment 03)
    BiPredicate<Integer, Integer> isShorter = (a1, a2) -> a1 < a2;
    BiPredicate<Integer, Integer> isLonger = (a1, a2) -> a1 > a2 ;

    // * practice length is shorter than given number of days
    public boolean apprenticeIsShorter(int number) {
        return isShorter.test(apprenticeshipLength, number);
    }
    // * practice length is longer than given number of days
    public boolean apprenticeIsLonger(int number) {
        return isLonger.test(apprenticeshipLength, number);
    }

}