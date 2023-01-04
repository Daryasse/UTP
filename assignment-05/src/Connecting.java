public class Connecting extends Participant{
    public Connecting(QueueMessages queue){
        super(queue);
    }

    @Override
    public void run() {
        while (true){
            Request request = queue.dequeueRequest();
            if (request != null){
                connectRequest(request);
            }
            sleep();
        }
    }

    private void connectRequest(Request request) {
        System.out.println("request: " + request + " is added");
        Response response = createResponse (request);
        queue.queueMessage(response);
    }

    private Response createResponse(Request request) {
        return new Response(request);
    }
}
