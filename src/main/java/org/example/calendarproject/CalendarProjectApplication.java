package org.example.calendarproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class CalendarProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(CalendarProjectApplication.class, args);
    }

}
