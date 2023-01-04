package eu.glowacki.utp.assignment03.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Manager extends Worker {

    private List<Employee> subordinates;
    private List<Employee> allSubordinates;


    public Manager(String firstName, String secondName, LocalDate birthday, BigDecimal salary, Manager manager,
                   LocalDate employmentDate, BigDecimal bonus, List<Employee> subordinates) {
        super(firstName, secondName, birthday, salary, manager, employmentDate, bonus);
        this.subordinates = subordinates;
        this.allSubordinates = findAllSubordinates();
    }


    public List<Employee> getAllSubordinates() {
        List<Employee> list = new ArrayList<>();
        list.addAll(subordinates);

        for (Employee e : subordinates) {
            if (e instanceof Manager) {
                list.addAll(((Manager) e).subordinates);
            }
        }
        return list;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void addToAllSubordinates(Employee _subordinate) {
        allSubordinates.add(_subordinate);
    }

    public void addToSubordinates(Employee subordinate) {
        for (int i = 0; i < this.subordinates.size(); i++) {
            if (this.subordinates.get(i) != subordinate) {
                this.subordinates.add(subordinate);
                addToAllSubordinates(subordinate);
            }
        }
    }

    public List<Employee> findAllSubordinates() {
        for (int i = 0; i < this.subordinates.size(); i++) {
            allSubordinates.add(subordinates.get(i));
            if (this.subordinates.get(i) instanceof Manager) {
                allSubordinates.addAll(((Manager) subordinates.get(i)).getSubordinates());
            }
        }
        return allSubordinates;
    }
	
	// (assignment 02)
	// attributes:
	// * subordinates (a list of immediate subordinates)
	// * all subordinates (a list of subordinates in all hierarchy)
}