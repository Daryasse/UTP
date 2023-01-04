import java.util.Random;

public class Request  extends Message{
    private static final Random random;
    static{
        random = new Random();
    }
    private final int p1;
    private final int p2;

    public Request (Requestor requestor){
        super(requestor, MessagePriority.getRandomPriority());
        p2 = random.nextInt();
        p1 = random.nextInt();
    }

    public int getP1() {
        return p1;
    }

    public int getP2() {
        return p2;
    }

    @Override
    public String toString() {
        return super.toString() + " <" + getP1() + "; " + getP2() + ">";
    }
}
