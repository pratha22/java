package com.example.pb.social_media.greetings;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	
	private MessageSource messageSource;
	
	public GreetingsController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	
	@GetMapping ("/getwish")
	public String getWish() {
		
		Locale locale = LocaleContextHolder.getLocale();
		System.out.println("Pratha ============ "+ locale.getDisplayName());
		return messageSource.getMessage("good.morning.message", null, "Default Message", locale );

	}

}
