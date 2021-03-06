package ir.matyn.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING)//I gotta search this.
    private LocalDateTime timestamp;
    private int status;
    private String error;
}
