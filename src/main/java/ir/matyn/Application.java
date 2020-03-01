package ir.matyn;

import ir.matyn.model.ContactFormEntity;
import ir.matyn.repository.ContactFormDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(ContactFormDao repository) {
        return args -> {
            repository.save(new ContactFormEntity("name1", "email1", "subject1", "message1"));
            repository.save(new ContactFormEntity("name2", "email2", "subject2", "message2"));
            repository.save(new ContactFormEntity("name3", "email3", "subject3", "message3"));
            repository.save(new ContactFormEntity("name4", "email4", "subject4", "message4"));

        };
    }
}