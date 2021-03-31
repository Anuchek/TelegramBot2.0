package by.jrr.giftGeneratorBot;

import by.jrr.giftGeneratorBot.config.Mapper;
import by.jrr.giftGeneratorBot.service.MessageService;
import by.jrr.giftGeneratorBot.service.TelegramBot;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TelegramBot.class, Mapper.class, MessageService.class})
public class GiftGeneratorBotApplicationTests {

	@Test
	void contextLoads() {
	}

}
