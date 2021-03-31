package by.jrr.giftgeneratorbot;

import by.jrr.giftgeneratorbot.config.Mapper;
import by.jrr.giftgeneratorbot.service.MessageService;
import by.jrr.giftgeneratorbot.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
public class GiftGeneratorBotApplicationTests {

	@Test
	void contextLoads() {
	}
}
