package eu.glowacki.utp.assignment01.solution;

import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;

public final class Student implements IAggregable<Student, Integer> , IDeeplyCloneable<Student> {
    private int grant;
    public Student(){

    }
    public Student (Integer grant){
        this.grant = grant;
    }
    public int getGrant(){
        return grant;
    }

    @Override
    public Integer aggregate(Integer intermediateResult) {
        if (intermediateResult==null){
            return grant;
        }else{
            return grant + intermediateResult;
        }
    }

    @Override
    public Student deepClone() {
        return new Student(grant);
    }
}
