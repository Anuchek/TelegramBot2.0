package by.jrr.giftgeneratorBot;

import by.jrr.giftgeneratorBot.config.Mapper;
import by.jrr.giftgeneratorBot.service.MessageService;
import by.jrr.giftgeneratorBot.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
public class GiftgeneratorBotApplicationTests {

	@Test
	void contextLoads() {
	}

}
