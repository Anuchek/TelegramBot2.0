package by.jrr.giftGeneratorBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class GiftGeneratorBotApplication {
	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(GiftGeneratorBotApplication.class, args);
	}
}
