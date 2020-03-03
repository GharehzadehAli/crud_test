package ir.matyn.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contact_form")
public class ContactFormEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "subject", nullable = false)
    private String subject;
    
    @Column(name = "message", nullable = false)
    private String message;


}
