package ir.matyn.model.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class ContactFormDtoOut {
    @NotBlank(message = "Please Enter An Id")
    private long id;
    @NotBlank(message = "Please Enter A Name")
    @Size(min = 3, max = 20)
    private String name;
    @NotBlank(message = "Please Enter A Email")
    @Email
    private String email;
    @NotBlank(message = "Please Enter A Subject")
    @Size(min = 3, max = 20)
    private String subject;
    @NotBlank(message = "Please Enter A Message")
    @Size(min = 3, max = 20)
    private String message;


}
