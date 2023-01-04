package eu.glowacki.utp.assignment01.solution;

import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;

public final class Employee implements IAggregable<Employee, Integer>, IDeeplyCloneable<Employee> {
    private int salary;

    public Employee(){
    }
    public Employee(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    @Override
    public Integer aggregate(Integer intermediateResult) {
        if (intermediateResult==null){
            return salary;
        }else{
            return salary + intermediateResult;
        }
    }

    @Override
    public Employee deepClone() {
        return new Employee(salary);
    }
}
