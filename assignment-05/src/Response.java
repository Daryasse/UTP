public class Response extends Message{
    private final int res;
    public Response(Request request){
        super(request.getRequestor(), request.getPriority());
        res = request.getP1() + request.getP2();
    }

    public int getRes() {
        return res;
    }

    @Override
    public String toString() {
        return super.toString() + " <" + res + "> ";
    }
}
