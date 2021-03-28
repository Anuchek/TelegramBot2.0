package by.jrr.giftgenerator_bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {

    public SendMessage onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();

        if (update != null){
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());

            if (message != null && message.hasText()){
                String magText = message.getText();

                if (magText.equals("/start")) {
                    return sendMessage.setText("Start");
                }
                else if (magText.equals("/support")) {
                    return sendMessage.setText("Support");
                }
                else if (magText.equals("/donate")) {
                    return sendMessage.setText("Donate");
                }
            }
        }
        return sendMessage.setText("Unknown message");
    }

}
