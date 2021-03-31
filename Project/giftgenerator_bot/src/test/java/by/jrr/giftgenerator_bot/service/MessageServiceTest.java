package by.jrr.giftgenerator_bot.service;

import by.jrr.giftgenerator_bot.GiftgeneratorBotApplicationTests;
import by.jrr.giftgenerator_bot.config.Mapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class MessageServiceTest extends GiftgeneratorBotApplicationTests {

    @Autowired
    TelegramBot telegramBot;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    MessageService messageService;

    //@Test
    void onStartReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/start.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Hi! I`m a GiftGenerator bot. I can help you to choose present! Type /generategift to begin!\n\n " +
                "All type commands: \n" +
                "/start - to start working with bot\n" +
                "/generategift\n" +
                "/support - support\n" +
                "/donate - to donate us\n" +
                "/reset - reset parametrs");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    //@Test
    void onSupportReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/support.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Contact information here: support@gmail.com");
        Assertions.assertEquals(expectedResult,actualResult);
    }
    //@Test
    void onDonateReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/donate.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Donate.allert.com");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    //@Test
    void onHelpReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/help.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Donate.allert.com");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    private SendMessage makeMessage(String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(724234813L);
        sendMessage.setText(text);
        return sendMessage;
    }
}