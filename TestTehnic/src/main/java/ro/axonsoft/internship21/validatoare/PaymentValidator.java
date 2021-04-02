package ro.axonsoft.internship21.validatoare;

//import ro.axonsoft.internship21.models.Payment;

public class PaymentValidator implements Validator<Double>{
    @Override
    public void validate(Double entity) throws ValidationException {
        if (entity<0)
            throw new ValidationException("invalid payment");
    }
}
