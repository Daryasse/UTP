public class Requestor extends Participant {
    private final QueueMessages responseQueue;

    public Requestor (QueueMessages queue){
        super(queue);
        this.responseQueue = new QueueMessages();
    }
    @Override
    public void run() {
        System.out.println("running " + this);
        while(true){
            queueRequest();
            boolean responseReceived = false;
            while (!responseReceived) {
                Response response = dequeueResponse();
                if (response != null) {
                    consumeResponse(response);
                    responseReceived = true;
                }
                sleep();
            }
        }
    }

    public QueueMessages getResponseQueue() {
        return responseQueue;
    }
    private void queueRequest(){
        Request request = createRequest();
        queue.queueMessage(request);
    }
    private Request createRequest(){
        return new Request(this);
    }
    private Response dequeueResponse(){
        return queue.dequeueResponse(this);
   }
   private void consumeResponse (Response response){
       System.out.println("response: "+ response + "is received");
   }
}

