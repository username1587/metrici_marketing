package ro.axonsoft.internship21.cnp;

import ro.axonsoft.internship21.cnp.from_github.CNPUtils;
import ro.axonsoft.internship21.validatoare.CnpException;

public class CnpValidatorImpl implements CnpValidator{
    @Override
    public void validateCnp(String cnp) throws CnpException {

        if (!CNPUtils.isValidCNP(cnp))
            throw new CnpException("CNP invalid !");

    }

}
