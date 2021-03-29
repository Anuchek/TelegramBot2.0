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

    @Test
    void onStartReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/start.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Hello! I am a bot for generating gifts. If you're ready, type /generate and we'll start");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void onSupportReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/support.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Contact information here");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void onDonateReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/donate.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Information needed to donate here");
        Assertions.assertEquals(expectedResult,actualResult);
    }


    @Test
    void onHelpReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/help.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Type /support to see contact information. Type /donate to see donate iformation");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    private SendMessage makeMessage(String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(724234813L);
        sendMessage.setText(text);
        return sendMessage;
    }
}