package by.jrr.giftgenerator_bot;

import by.jrr.giftgenerator_bot.config.Mapper;
import by.jrr.giftgenerator_bot.service.MessageService;
import by.jrr.giftgenerator_bot.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
public class GiftgeneratorBotApplicationTests {

	@Test
	void contextLoads() {
	}

}
