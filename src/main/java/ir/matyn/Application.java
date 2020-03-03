package ir.matyn;

import ir.matyn.model.entity.ContactFormEntity;
import ir.matyn.repository.IContactFormDao;
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
    public CommandLineRunner demo(IContactFormDao repository) {
        String email = "gharehzadehali@gmail.com";
        return args -> {
            ContactFormEntity contactFormEntity1 = new ContactFormEntity();
            ContactFormEntity contactFormEntity2 = new ContactFormEntity();
            ContactFormEntity contactFormEntity3 = new ContactFormEntity();
            ContactFormEntity contactFormEntity4 = new ContactFormEntity();
            contactFormEntity1.setName("name1");
            contactFormEntity2.setName("name2");
            contactFormEntity3.setName("name3");
            contactFormEntity4.setName("name4");
            contactFormEntity1.setEmail(email);
            contactFormEntity2.setEmail(email);
            contactFormEntity3.setEmail(email);
            contactFormEntity4.setEmail(email);
            contactFormEntity1.setSubject("subject1");
            contactFormEntity2.setSubject("subject2");
            contactFormEntity3.setSubject("subject3");
            contactFormEntity4.setSubject("subject4");
            contactFormEntity1.setMessage("message1");
            contactFormEntity2.setMessage("message2");
            contactFormEntity3.setMessage("message3");
            contactFormEntity4.setMessage("message4");
            repository.save(contactFormEntity1);
            repository.save(contactFormEntity2);
            repository.save(contactFormEntity3);
            repository.save(contactFormEntity4);

        };
    }
}