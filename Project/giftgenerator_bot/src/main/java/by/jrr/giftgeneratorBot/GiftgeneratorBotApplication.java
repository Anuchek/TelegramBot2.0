package by.jrr.giftgeneratorBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class GiftgeneratorBotApplication {
	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(GiftgeneratorBotApplication.class, args);
	}
}
