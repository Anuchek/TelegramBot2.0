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
                    return sendMessage.setText("Hello! I am a bot for generating gifts. If you're ready, type /generate and we'll start");
                }
                else if (magText.equals("/support")) {
                    return sendMessage.setText("Contact information here");
                }
                else if (magText.equals("/donate")) {
                    return sendMessage.setText("Information needed to donate here");
                }
                else if (magText.equals("/help")) {
                    return sendMessage.setText("Type /support to see contact information. Type /donate to see donate iformation");
                }

            }
        }
        return sendMessage.setText("Can't recognize command. Type /help to see the list of commmands");
    }

}
