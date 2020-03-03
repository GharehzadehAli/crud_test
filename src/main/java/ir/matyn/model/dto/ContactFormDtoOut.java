package ir.matyn.model.dto;

import lombok.Data;

@Data
public class ContactFormDtoOut {
    private long id;

    private String name;

    private String email;

    private String subject;

    private String message;


}
