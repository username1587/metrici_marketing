package ro.axonsoft.internship21.validatoare;

public interface Validator<T> {
    void validate(T entity) throws ValidationException;
}
