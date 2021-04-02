package ro.axonsoft.internship21.validatoare;

//import ro.axonsoft.internship21.models.Line;

public class LineValidator implements Validator<String> {
    @Override
    public void validate(String entity) throws ValidationException {
        String[] args=entity.split(";");

        if (args.length!=2)
            throw new ValidationException("invalid no args");

        try{
            Double.parseDouble(args[1]);
        }
        catch (NumberFormatException ex){
            throw new ValidationException("number is not parsable");
        }
    }
}
