package ro.axonsoft.internship21.models;

import java.io.Serializable;

/**
 * obiect care contine un CNP si o Suma
 */
public class LineDTO implements Serializable {
    String cnp;
    Double payment;

    //#region auto generated

    public LineDTO(String cnp, Double payment) {
        this.cnp = cnp;
        this.payment = payment;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    //#endregion
}
