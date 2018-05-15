package interesting_tweets.listeners.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;


/**
 * Created by jorge on 29/03/18.
 *
 *
 */


@Component
public class EnglishListener {


    @Autowired
    private SimpMessageSendingOperations messagingTemplate;


    public void receiveMessage(String message) {

        System.out.println(message);
        messagingTemplate.convertAndSend("/queue/language/en",message);

    }
}
