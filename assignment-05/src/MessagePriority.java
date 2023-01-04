import java.util.Random;

public enum MessagePriority {
    HIGH("High priority"),
    NORMAL("Normal priority"),
    LOW("Low priority");

    private static final Random random = new Random();

    public static MessagePriority getRandomPriority(){
        MessagePriority[] values = MessagePriority.values();
        int index = random.nextInt(values.length);
        return values[index];
    }
    private String locName;

    MessagePriority(String locName){
        this.locName = locName;
    }

    public String getLocName(){
        return locName;
    }

    @Override
    public String toString() {
        return getLocName();
    }


}
