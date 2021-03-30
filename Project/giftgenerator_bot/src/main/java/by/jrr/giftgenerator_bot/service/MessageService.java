package by.jrr.giftgenerator_bot.service;

import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {

    public SendMessage onUpdateReceived(Update update) {

        SendMessage sendMessage = new SendMessage();
        GiftUser giftUser = new GiftUser();

        if (update != null){
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());

            if (message.hasText()){
                String magText = message.getText();

                if (magText.equals("/start"))
                    return sendMessage.setText("Start");

                ///----------------------------------------///

                else if (magText.equals("/generategift")) {
                    return sendMessage.setText("For whom do you want a gift?\n" +
                            "-man(/man)\n" +
                            "-woman(/woman)\n");
                }
                else if (magText.equals("/man")) {
                    giftUser.setGender('M');
                    return sendMessage.setText("Indicate who this person is for you\n" +
                            "-husband(/husband)\n" +
                            "-father(/father)\n" +
                            "-son(/son)\n");
                }
                else if (magText.equals("/husband")) {
                    giftUser.setRelationship("husband");
                    return sendMessage.setText("Loading...");
                }
                else if (magText.equals("/father")) {
                    giftUser.setRelationship("father");
                    return sendMessage.setText("Loading...");
                }
                else if (magText.equals("/son")) {
                    giftUser.setRelationship("son");
                    return sendMessage.setText("Loading...");
                }

                //

                else if (magText.equals("/woman")) {
                    giftUser.setGender('W');
                    return sendMessage.setText("Indicate who this person is for you\n" +
                            "-wife(/wife)\n" +
                            "-mother(/mother)\n" +
                            "-daughter(/daughter)\n");
                }
                else if (magText.equals("/wife")) {
                    giftUser.setRelationship("wife");
                    return sendMessage.setText("Loading...");
                }
                else if (magText.equals("/mother")) {
                    giftUser.setRelationship("mother");
                    return sendMessage.setText("Loading...");
                }
                else if (magText.equals("/daughter")) {
                    giftUser.setRelationship("daughter");
                    return sendMessage.setText("Loading...");
                }

                else if(magText.equals("/clean")) {
                    giftUser.setGender(null);
                    giftUser.setRelationship(null);
                    return sendMessage.setText("It is clean now");
                }

                ///----------------------------------------///

                else if (magText.equals("/support"))
                    return sendMessage.setText("Support");

                else if (magText.equals("/donate"))
                    return sendMessage.setText("Donate");

            }
        }
        return sendMessage.setText("Unknown message");
    }

}
