package by.jrr.giftgenerator_bot.service;

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

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
class MessageServiceTest {

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
        SendMessage expectedResult = makeMessage("Start");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void onSupportReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/support.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Support");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void onDonateReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/donate.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Donate");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    @Test
    void onUnknownReceived() throws IOException {
        Update update = objectMapper.readValue(new File("src/test/resources/unknown.json"), Update.class);
        SendMessage actualResult = messageService.onUpdateReceived(update);
        SendMessage expectedResult = makeMessage("Unknown message");
        Assertions.assertEquals(expectedResult,actualResult);
    }

    private SendMessage makeMessage(String text){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(724234813L);
        sendMessage.setText(text);
        return sendMessage;
    }
}