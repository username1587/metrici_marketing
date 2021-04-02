package ro.axonsoft.internship21.validatoare;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }
}
