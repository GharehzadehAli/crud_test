package ir.matyn.model;

import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "contactForm")
public class ContactForm extends BaseEntity{


    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "subject")
    private String subject;
    @Column(name = "message")
    private String message;

    public ContactForm() {
    }

    public ContactForm(String name, String email, String subject, String message) {
        this.name=name;
        this.email=email;
        this.subject=subject;
        this.message=message;
    }





    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "ContactForm{" +
                "id=" + this.getId() +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", subject='" + subject + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

}
