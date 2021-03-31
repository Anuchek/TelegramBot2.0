package by.jrr.giftgenerator_bot.service;

import by.jrr.giftgenerator_bot.DataBase.DataBaseImitator;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@Service
public class MessageService {
    int i = 0;
    SendMessage sendMessage = new SendMessage();
    DataBaseImitator dataBaseImitator = new DataBaseImitator();
    GiftUser giftUser = new GiftUser();
    public SendMessage onUpdateReceived(Update update) {
        if (update != null){
            Message message = update.getMessage();
            sendMessage.setChatId(message.getChatId());

            if (message.hasText()){
                String magText = message.getText();

                if (magText.equals("/support")) {
                    return sendMessage.setText("Contact information here: support@gmail.com");
                }
                else if (magText.equals("/donate")) {
                    return sendMessage.setText("Donate.allert.com");
                }

                else if (magText.equals("/help")) {
                    return sendMessage.setText("Type /support to see contact information. Type /donate to see donate iformation");
                }

              
                else if(magText.equals("/reset")) {
                    giftUser.setGender(null);
                    giftUser.setRelationship(null);
                    i = 0;
                    return sendMessage.setText("It is clean now \nUse /generategift one more time!");
                }
                else if (magText.equals("/generategift")) {
                    return sendMessage.setText("For whom do you want a gift?\n" +
                            "-man(/man)\n" +
                            "-woman(/woman)\n");
                }
                else if (magText.equals("/man")) {
                    giftUser.setGender("male");
                    return sendMessage.setText("Indicate who this person is for you\n" +
                            "-husband(/husband)\n" +
                            "-father(/father)\n" +
                            "-son(/son)\n");
                }
                else if (magText.equals("/husband")) {
                    if(giftUser.getGender() == null){
                        return sendMessage.setText("You need to choose gender first\n" +
                                "Plz choose between /man and /woman");
                    }
                    giftUser.setRelationship("husband");
                    return sendMessage.setText("All preparation`s been done! Write /present to see our suggestions!");
                }
                else if (magText.equals("/father")) {
                    if(giftUser.getGender() == null){
                        return sendMessage.setText("You need to choose gender first\n" +
                                "Plz choose between /man and /woman");
                    }
                    giftUser.setRelationship("father");
                    return sendMessage.setText("All preparation`s been done! Write /present to see our suggestions!");
                }
                else if (magText.equals("/son")) {
                    if(giftUser.getGender() == null){
                        return sendMessage.setText("You need to choose gender first\n" +
                                "Plz choose between /man and /woman");
                    }
                    giftUser.setRelationship("son");
                    return sendMessage.setText("All preparation`s been done! Write /present to see our suggestions!");
                }
                else if (magText.equals("/woman")) {
                    giftUser.setGender("female");
                    return sendMessage.setText("Indicate who this person is for you\n" +
                            "-wife(/wife)\n" +
                            "-mother(/mother)\n" +
                            "-daughter(/daughter)\n");
                }
                else if (magText.equals("/wife")) {
                    if(giftUser.getGender() == null){
                        return sendMessage.setText("You need to choose gender first\n" +
                                "Plz choose between /man and /woman");
                    }
                    giftUser.setRelationship("wife");
                    return sendMessage.setText("All preparation`s been done! Write /present to see our suggestions!");
                }
                else if (magText.equals("/mother")) {
                    if(giftUser.getGender() == null){
                        return sendMessage.setText("You need to choose gender first\n" +
                                "Plz choose between /man and /woman");
                    }
                    giftUser.setRelationship("mother");
                    return sendMessage.setText("All preparation`s been done! Write /present to see our suggestions!");
                }
                else if (magText.equals("/daughter")) {
                    if(giftUser.getGender() == null){
                        return sendMessage.setText("You need to choose gender first\n" +
                                "Plz choose between /man and /woman");
                    }
                    giftUser.setRelationship("daughter");
                    return sendMessage.setText("All preparation`s been done! Write /present to see our suggestions!");
                }
                else if (magText.equals("/present")) {
                    if (giftUser.getGender() != null && giftUser.getRelationship() != null){
                        return getPresent(update, giftUser.getGender(),giftUser.getRelationship());
                    } return sendMessage.setText("Before using command /present you firstly need to use /generategift command!");
                }
                else if (magText.equals("/next")) {
                    return getNextPresent(update, giftUser.getGender(),giftUser.getRelationship());
                }
            }
        }
        return sendMessage.setText("Can't recognize command. Type /help to see the list of commmands");
    }
    public SendMessage getPresent(Update update, String gender, String relation){
        Message message = update.getMessage();
        sendMessage.setChatId(message.getChatId());
        return sendMessage.setText(dataBaseImitator.switcher(gender, relation).get(i) + "\n---------------------------------------------------" +
                "\nDon`t like it? Click /next to see other variants!");
    }

    public SendMessage getNextPresent(Update update, String gender, String relation){
        Message message = update.getMessage();
        sendMessage.setChatId(message.getChatId());
        if (i < dataBaseImitator.switcher(gender, relation).size() - 1){
            i++;
            return sendMessage.setText(dataBaseImitator.switcher(gender, relation).get(i) + "\n---------------------------------------------------" +
                    "\nDon`t like it? Click /next to see other variants!");
        } else {
            return sendMessage.setText("That's all for now(( \n Type /reset to try find present for someone else");
        }
    }
}
