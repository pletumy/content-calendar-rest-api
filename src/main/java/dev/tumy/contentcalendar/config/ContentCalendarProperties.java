package dev.tumy.contentcalendar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author TuMy
 */
@ConfigurationProperties(value = "cc")
public record ContentCalendarProperties(String welcomeMessage, String about) {
    //turn into properties

}
