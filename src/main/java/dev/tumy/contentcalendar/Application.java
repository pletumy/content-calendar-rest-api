package dev.tumy.contentcalendar;

import dev.tumy.contentcalendar.config.ContentCalendarProperties;
import dev.tumy.contentcalendar.model.Content;
import dev.tumy.contentcalendar.model.Status;
import dev.tumy.contentcalendar.model.Type;
import dev.tumy.contentcalendar.repository.ContentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

//import java.util.Arrays;

@EnableConfigurationProperties(ContentCalendarProperties.class)
@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);

	}


}
