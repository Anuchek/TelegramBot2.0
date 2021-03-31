package by.jrr.giftgeneratorBot.service;

import by.jrr.giftgeneratorBot.GiftgeneratorBotApplicationTests;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import java.io.File;
import java.io.IOException;


class MessageServiceTest extends GiftgeneratorBotApplicationTests {

    @Autowired
    TelegramBot telegramBot;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;

    @Test
    void onStartReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/start.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Type /generategift to start working with bot!");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void onSupportReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/support.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Contact information here: support@gmail.com");
        Assertions.assertEquals(expectedResult,actualResult);
    }
    @Test
    void onDonateReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/donate.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Donate.allert.com");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void onHelpReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/help.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Type /support to see contact information. Type /donate to see donate information");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    private SendMessage makeMessage(String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(724234813L);
        sendMessage.setText(text);
        return sendMessage;
    }
}