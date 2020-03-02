package ir.matyn;

import ir.matyn.model.ContactFormEntity;
import ir.matyn.repository.IContactFormDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Bean
    public CommandLineRunner demo(IContactFormDao repository) {
        String email = "gharehzadehali@gmail.com";
        return args -> {
            repository.save(new ContactFormEntity("name1", email, "subject1", "message1"));
            repository.save(new ContactFormEntity("name2", email, "subject2", "message2"));
            repository.save(new ContactFormEntity("name3", email, "subject3", "message3"));
            repository.save(new ContactFormEntity("name4", email, "subject4", "message4"));

        };
    }
}