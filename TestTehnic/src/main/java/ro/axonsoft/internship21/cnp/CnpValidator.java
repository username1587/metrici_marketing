package ro.axonsoft.internship21.cnp;

import ro.axonsoft.internship21.validatoare.CnpException;

public interface CnpValidator {

        /**
         * Valideza CNP-ul primit ca parametru si returneaza partile componente ale
         * acestuia.
         *
         * @param cnp
         *            CNP-ul de validat
         * @return partile componente ale CNP-ului
         * @throws CnpException
         *             daca CNP-ul nu este valid
         */
        void validateCnp(String cnp) throws CnpException;

}
