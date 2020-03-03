package ir.matyn.exception;

import lombok.Data;

import java.util.List;

@Data
public class ValidationErrorResponse {
    //General error message about nature of error
    private String message;
    //Specific errors in API request processing
    private List<String> details;

    public ValidationErrorResponse(String message, List<String> details) {
        this.message = message;
        this.details = details;
    }

}
