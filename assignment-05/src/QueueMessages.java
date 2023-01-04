import java.util.PriorityQueue;
import java.util.Queue;

public final class QueueMessages {
    private final Queue<Message> priorityQueue;

    public QueueMessages() {//
        priorityQueue = new PriorityQueue<>();
    }

    public synchronized void queueMessage(Message message) { //
        priorityQueue.offer(message);
    }

    public synchronized Request dequeueRequest() {
        Message message = priorityQueue.peek();
        if (message instanceof Request) {
            return (Request) priorityQueue.poll();
        }
        return null;
    }

    public synchronized Response dequeueResponse(Requestor requestor) {
        Message message = priorityQueue.peek();
        if (message instanceof Response && message.getRequestor() == requestor) {
            return (Response) priorityQueue.poll();
        }
        return null;
    }

}