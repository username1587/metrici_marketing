package ro.axonsoft.internship21.pay;

import ro.axonsoft.internship21.cnp.CnpParts;
import ro.axonsoft.internship21.cnp.CnpPartsImpl;
import ro.axonsoft.internship21.cnp.CnpValidator;
import ro.axonsoft.internship21.cnp.CnpValidatorImpl;
import ro.axonsoft.internship21.models.LineDTO;
import ro.axonsoft.internship21.cnp.utils.CalDate;
import ro.axonsoft.internship21.cnp.utils.Judet;
import ro.axonsoft.internship21.validatoare.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PayMetricsImpl implements PayMetrics, Serializable {
    private Integer _foreigners;
    private Integer _paymentsByMinors;
    private Integer _bigPayments;
    private Integer _smallPayments;
    private BigDecimal _totalAmountCapitalCity;
    private Set<PayError> _errors;

    private BigDecimal totalPaymentAmount;
    private Integer numberOfPayments;

    public PayMetricsImpl(List<String> lines){
        _foreigners=0;
        _paymentsByMinors=0;
        _bigPayments=0;
        _smallPayments=0;
        _totalAmountCapitalCity=BigDecimal.ZERO;
        _errors=new HashSet<>();

        totalPaymentAmount=BigDecimal.ZERO;
        numberOfPayments=0;


        Validator<String> lineValidator=new LineValidator();
        Validator<Double> paymentValidator=new PaymentValidator();
        CnpValidator cnpValidator=new CnpValidatorImpl();

        int line=0;
        for (String lineDTOStr : lines){
            line++;

            try{
                lineValidator.validate(lineDTOStr);
            }
            catch (ValidationException ex){
                _errors.add(new PayErrorImpl(line,1));
                continue;
            }

            String[] args=lineDTOStr.split(";");

            LineDTO lineDTO=new LineDTO(args[0],Double.parseDouble(args[1]));

            try{
                cnpValidator.validateCnp(lineDTO.getCnp()); // TODO aici ar trebui sa schimb sa folosesc valoarea de return
            }
            catch (ValidationException ex){
                _errors.add(new PayErrorImpl(line,2));
                continue;
            }

            try{
                paymentValidator.validate(lineDTO.getPayment());
            }
            catch (ValidationException ex){
                _errors.add(new PayErrorImpl(line,3));
                continue;
            }

            CnpParts cnpParts=new CnpPartsImpl(lineDTO.getCnp());
            if (cnpParts.foreigner())
                _foreigners++;

            if (getAgeFromBirthDate(cnpParts.birthDate())<18)
                _paymentsByMinors+=lineDTO.getPayment().intValue();

            if (lineDTO.getPayment()>5000)
                _bigPayments++;

            if (lineDTO.getPayment()<=5000)
                _smallPayments++;

            if (cnpParts.judet().equals(Judet.BU))
                _totalAmountCapitalCity=_totalAmountCapitalCity.add(BigDecimal.valueOf(lineDTO.getPayment()));

            totalPaymentAmount=totalPaymentAmount.add(BigDecimal.valueOf(lineDTO.getPayment()));
            numberOfPayments++;
        }
    }

    private int getAgeFromBirthDate(CalDate birthDate){     // TODO sa testez asta
        LocalDate l = LocalDate.of(birthDate.year(), birthDate.month(), birthDate.day());
        LocalDate now = LocalDate.now();
        Period diff = Period.between(l, now);
        return diff.getYears();
    }

    @Override
    public Integer foreigners() {
        return _foreigners;
    }

    @Override
    public Integer paymentsByMinors() {
        return _paymentsByMinors;
    }

    @Override
    public Integer bigPayments() {
        return _bigPayments;
    }

    @Override
    public Integer smallPayments() {
        return _smallPayments;
    }

    @Override
    public BigDecimal averagePaymentAmount() {
        return totalPaymentAmount.divide(BigDecimal.valueOf(numberOfPayments));
    }

    @Override
    public BigDecimal totalAmountCapitalCity() {
        return _totalAmountCapitalCity;
    }

    @Override
    public Set<PayError> errors() {
        return _errors;
    }


    @Override
    public String toString() {
        return "PayMetricsImpl{" +
                "_foreigners=" + _foreigners +
                ", _paymentsByMinors=" + _paymentsByMinors +
                ", _bigPayments=" + _bigPayments +
                ", _smallPayments=" + _smallPayments +
                ", _totalAmountCapitalCity=" + _totalAmountCapitalCity +
                ", _errors=" + _errors +
                ", totalPaymentAmount=" + totalPaymentAmount +
                ", numberOfPayments=" + numberOfPayments +
                '}';
    }
}
