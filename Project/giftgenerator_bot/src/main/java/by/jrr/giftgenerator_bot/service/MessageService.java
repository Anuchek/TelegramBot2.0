package by.jrr.giftgenerator_bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {

    public String onUpdateReceived(Update update) {
        if (update != null){
            Message message = update.getMessage();

            if (message != null && message.hasText()){
                String magText = message.getText();

                if (magText.equals("/start")) {
                    return "Start";
                }
                else if (magText.equals("/support")) {
                    return "Support";
                }
                else if (magText.equals("/donate")) {
                    return "Donate";
                }
            }
        }
        return "Unknown message";
    }

}
