package eu.glowacki.utp.assignment02;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

import eu.glowacki.utp.assignment02.employee.Employee;
import eu.glowacki.utp.assignment02.employee.Manager;
import eu.glowacki.utp.assignment02.employee.Worker;
import eu.glowacki.utp.assignment02.payroll.PayrollEntry;

public final class HumanResourcesStatistics {

    public static List<PayrollEntry> payroll(List<Employee> employees) {
        if (employees.isEmpty()) {
            return null;
        }
        List<PayrollEntry> payRoll = employees
                .stream()
                .map(employee -> new PayrollEntry(employee, employee.getSalary(), employee instanceof Worker ?
                        ((Worker) employee).getBonus() : new BigDecimal(0)))
                .collect(Collectors.toList());
        return payRoll;

    }

    // payroll for all subordinates
    public static List<PayrollEntry> subordinatesPayroll(Manager manager) {
        return payroll(manager.getAllSubordinates());
    }

    public static BigDecimal bonusTotal(List<Employee> employees) {
        if (employees.isEmpty()) {
            return null;
        } else {
            BigDecimal totalBonus = employees
                    .stream()
                    .filter(p -> p instanceof Worker)
                    .map(p -> ((Worker) p).getBonus())
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            return totalBonus;
        }
    }

    // rest of the methods specified in the assignment description


    public static Employee longestSeniority(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        long maximum = employees
                .stream()
                .filter(emp -> emp instanceof Worker)
                .map(emp -> ((Worker) emp).amountOfDays())
                .reduce(Long.valueOf(0), (maximumDay, day) -> {
                    if (maximumDay < day) {
                        return day;
                    } else {
                        return maximumDay;
                    }
                });

        Employee longest = employees
                .stream()
                .filter(emp -> emp instanceof Worker && ((Worker) emp).amountOfDays() == maximum)
                .collect(Collectors.toList())
                .get(0);

        return longest;
    }

    public static BigDecimal MaximalSalaryWithoutBonus(List<Employee> employees) {
        if (employees == null) {
            return null;
        }

        BigDecimal maximumWithoutBonus = employees
                .stream()
                .map(p -> p.getSalary())
                .reduce(BigDecimal.valueOf(0),
                        (maxSal, sal) -> {
                            if (maxSal.doubleValue() < sal.doubleValue()) {
                                return sal;
                            } else {
                                return maxSal;
                            }
                        });
        return maximumWithoutBonus;
    }

    public static BigDecimal maximalSalaryIncludingBonus(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        BigDecimal maximumWithBonus = employees
                .stream()
                .map(emp -> emp instanceof Worker ? ((Worker)emp).getBonus().add(emp.getSalary()) :
                        new BigDecimal(0).add(emp.getSalary()))
                .reduce( BigDecimal.valueOf(0),
                        (maxSal, sal) -> {
                            if (maxSal.doubleValue() < sal.doubleValue()) {
                                return sal;
                            } else {
                                return maxSal;
                            }
                        });
        return maximumWithBonus;
    }

    public static List<Employee> surnameStartsWithA(Manager manager) {
        if (manager.getSubordinates() == null) {
            return null;
        }
        List<Employee> employeesA = manager
                .getSubordinates()
                .stream()
                .filter(emp -> emp.getSurname().startsWith("A"))
                .collect(Collectors.toList());
        return employeesA;
    }

    public static List<Employee> earnMoreThan1000(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        List<Employee> employees1000 = employees
                .stream()
                .filter(emp -> emp.getSalary().doubleValue() > new BigDecimal(1000).doubleValue())
                .collect(Collectors.toList());
        return employees1000;
    }



    /**
     * samples for functional processing in Java
     */
    public static List<Short> getAges(List<Employee> employees) {
        if (employees == null) {
            return null;
        }
        List<Short> ages = employees //
                .stream() //
                .map(emp -> emp.getAge()) //
                .collect(Collectors.toList());
        return ages;
    }

    public static void printAges(List<Employee> employees) {
        if (employees == null) {
            return;
        }
        employees //
                .stream() //
                .map(emp -> (int) emp.getAge()) //
                .forEach(age -> System.out.print(age + ", "));
    }


    public static short getAverageAgeInline(List<Employee> employees) {
        if (employees == null) {
            return 0;
        }
        int employeeTotalAge = employees //
                .stream() //
                .filter(emp -> emp.getFirstName().startsWith("A") && emp.getAge() > 20) //
                .map(emp -> (int) emp.getAge()) //
                .reduce(0, //
                        (total, age) -> total + age);

        long filteredEmployeesCount = employees //
                .stream() //
                .filter(emp -> emp.getFirstName().startsWith("A") && emp.getAge() > 20) //
                .count();

        return (short) (employeeTotalAge / filteredEmployeesCount);
    }

    public static short getAverageAgeMethodReference(List<Employee> employees) {
        if (employees == null) {
            return 0;
        }
        int employeeTotalAge = employees //
                .stream() //
                .map(emp -> (int) emp.getAge()) //
                .reduce(0, HumanResourcesStatistics::totalAge);
        return (short) (employeeTotalAge / employees.size());
    }

    public static short getMaxAgeInline(List<Employee> employees) {
        short employeeMaxAge = employees //
                .stream() //
                .map(emp -> emp.getAge()) //
                .reduce((short) 0, //
                        (maxAge, age) -> {
                            if (maxAge < age) {
                                return age;
                            } else {
                                return maxAge;
                            }
                        });
        return employeeMaxAge;
    }

    public static short getMaxAgeMethodReference(List<Employee> employees) {
        short employeeMaxAge = employees //
                .stream() //
                .map(emp -> emp.getAge()) //
                .reduce((short) 0, HumanResourcesStatistics::maxAge);
        return employeeMaxAge;
    }

    private static int totalAge(int totalAge, int age) {
        return totalAge + age;
    }

    private static short maxAge(short maxAge, short age) {
        if (maxAge < age) {
            return age;
        } else {
            return maxAge;
        }
    }
}