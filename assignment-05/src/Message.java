
import java.util.Comparator;
import java.util.Date;

public abstract class Message implements Comparable<Message>{
    public static int currentId = 0;
    private static final Comparator<Message> comparator;
    static {
        comparator = Comparator.comparing(Message::getPriority)
                .thenComparing(Message::getDateOfAdding)
                .thenComparing(Message::getId);
    }
    private synchronized static int getCurrentId(){
        return currentId++;
    }
    private final int id;
    private final Requestor requestor;
    private final Date dateOfAdding;
    private MessagePriority priority;

    protected Message(Requestor requestor, MessagePriority priority){
        id = getCurrentId();
        this.requestor = requestor;
        this.priority = priority;
        dateOfAdding = new Date();
    }

    public int getId() {
        return id;
    }

    public MessagePriority getPriority() {
        return priority;
    }

    public Requestor getRequestor() {
        return requestor;
    }

    public Date getDateOfAdding() {
        return dateOfAdding;
    }

    public final int compareTo(Message other){
        return comparator
                .compare(this, other);
    }
}
