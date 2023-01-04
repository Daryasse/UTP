public abstract class Participant implements Runnable {
    private static final int SLEEP_TIME = 1000;
    //private static final int SLEEP_TIME = 0;
    private static int currentID = 0;

    public static int getCurrentID() {
        return currentID++;
    }
    private final int id;
    protected final QueueMessages queue;
    protected Participant(QueueMessages queue){
        this.id = getCurrentID();
        this.queue = queue;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return getClass().getName() + " (" + getId() + ")";
    }

    protected void sleep(){
        try{
            Thread.sleep(SLEEP_TIME);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

