package ir.matyn.exception;

public class ContactFormNotFoundException extends RuntimeException {
    public ContactFormNotFoundException(Long id) {
        super("There is no ContactForm with " + id + " as its id.");
    }
}
