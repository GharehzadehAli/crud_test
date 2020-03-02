package ir.matyn.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@Table(name = "contact_form")
public class ContactFormEntity {
    @Id
    @GeneratedValue
    @Column(name = "contact_form_id")
    private long id;
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
        this.setId(id);
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


}
