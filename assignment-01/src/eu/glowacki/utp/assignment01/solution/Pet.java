package eu.glowacki.utp.assignment01.solution;

import eu.glowacki.utp.assignment01.IAggregable;
import eu.glowacki.utp.assignment01.IDeeplyCloneable;

public final class Pet implements IAggregable<Pet, String>, IDeeplyCloneable<Pet> {
    private String name;
    public Pet(){

    }
    public Pet (String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    @Override
    public String aggregate(String intermediateResult) {
        if (intermediateResult == null){
            return name;
        }else{
            return name + intermediateResult;
        }
    }

    @Override
    public Pet deepClone() {
        return new Pet(name);
    }
}
