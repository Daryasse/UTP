package lists;

import java.util.Random;

public enum academicDegree {
    BD("Bachelor's Degree"),
    MD("Master's Degree"),
    DD("Doctoral degree PhD");

private String degree;

    academicDegree(String degree) {
        this.degree = degree;
    }

    public String getDegree() {
        return degree;
    }

    private static Random random = new Random();

    public static academicDegree getRandomDegree(){
        academicDegree [] degrees = academicDegree.values();
        int number = random.nextInt(degrees.length);
        return degrees[number];
    }
}
