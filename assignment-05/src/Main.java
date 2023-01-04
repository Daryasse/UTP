import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main{
    private static int conNumber = 5;
    private static int requestorNumber = 5;

    public static void main(String[] args) {
        QueueMessages queue = new QueueMessages();
        List<Connecting> connectings = participants(queue, conNumber, Connecting::new);
        List<Requestor> requestors = participants(queue, requestorNumber, Requestor::new);
        begin(connectings);
        begin(requestors);
    }

        private static<PParticipant extends Participant> List<PParticipant> participants
            (QueueMessages queue, int participantsNumber, Function<QueueMessages, PParticipant> create)
    {
        List<PParticipant> participants = new ArrayList<>();
        for (int i = 0; i < participantsNumber; i++){
            PParticipant participant = create.apply (queue);
            participants.add(participant);
        }
        return participants;
    }
    private static <PParticipant extends Participant> void begin(List<PParticipant> participants){
        participants
                .stream()
                .forEach(Main::begin);
    }
    private static <PParticipant extends Participant> void begin(PParticipant participant){
        new Thread(participant)
                .start();
    }
}
