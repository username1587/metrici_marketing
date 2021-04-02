package ro.axonsoft.internship21.cnp;

import ro.axonsoft.internship21.cnp.utils.CalDate;
import ro.axonsoft.internship21.cnp.utils.Judet;
import ro.axonsoft.internship21.cnp.utils.Sex;

public interface CnpParts {
    /**
     * Sexul determinat pe baza primei cifrei din CNP.
     */
    Sex sex();

    /**
     * Posesorul CNP-ului este cetatean strain?
     *
     * @return {@code true} daca este cetatean strain, {@code false} in caz
     *         contrar
     */
    Boolean foreigner();

    /**
     * Judetul.
     */
    Judet judet();

    /**
     * Data nasterii.
     */
    CalDate birthDate();

    /**
     * Numarul de ordine.
     */
    Short orderNumber();
}
