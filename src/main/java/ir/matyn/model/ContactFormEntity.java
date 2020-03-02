package ir.matyn.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "contactForm")
public class ContactFormEntity extends BaseEntity {

    @NotBlank(message = "Please Enter A Name")
    @Size(min = 3, max = 20)
    @Column(name = "name", nullable = false)
    private String name;
    @NotBlank(message = "Please Enter An Email")
    @Email
    @Column(name = "email", nullable = false)
    private String email;
    @NotBlank(message = "Please Enter A Subject")
    @Size(min = 3, max = 20)
    @Column(name = "subject", nullable = false)
    private String subject;
    @NotBlank(message = "Please Enter A Message")
    @Size(min = 3, max = 50)
    @Column(name = "message", nullable = false)
    private String message;

    public ContactFormEntity() {
    }

    public ContactFormEntity(long id, String name, String email, String subject, String message) {
        super.setId(id);
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
    }

    public ContactFormEntity(String name, String email, String subject, String message) {
        this.name = name;
        this.email = email;
        this.subject = subject;
        this.message = message;
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
