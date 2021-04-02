package ro.axonsoft.internship21.pay;

import java.io.Serializable;

public class PayErrorImpl implements PayError, Serializable {

    Integer line;
    Integer type;

    public PayErrorImpl(Integer line, Integer type) {
        this.line = line;
        this.type = type;
    }

    @Override
    public Integer line() {
        return line;
    }

    @Override
    public Integer type() {
        return type;
    }
}
