package ir.matyn.exception;

//Can not find the right exception to catch.
public class ContactFormsNotFoundException extends RuntimeException {
    public ContactFormsNotFoundException() {
        super("there is no data to delete");

    }
}
