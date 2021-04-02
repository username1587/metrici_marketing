package ro.axonsoft.internship21.cnp;

import ro.axonsoft.internship21.cnp.utils.CalDate;
import ro.axonsoft.internship21.cnp.utils.CalDateImpl;
import ro.axonsoft.internship21.cnp.utils.Judet;
import ro.axonsoft.internship21.cnp.utils.Sex;

public class CnpPartsImpl implements CnpParts{

    String cnpAsString;

    public CnpPartsImpl(String cnpAsString) {
        this.cnpAsString=cnpAsString;
    }

    @Override
    public Sex sex() {
        Integer firstDigit=cnpAsString.charAt(0)-'0';

        if(firstDigit.equals(9))
            return Sex.U;
        if (firstDigit%2==1)
            return Sex.M;
        return Sex.F;
    }

    @Override
    public Boolean foreigner() {
        Integer firstDigit=cnpAsString.charAt(0)-'0';

        return firstDigit.equals(9);
    }

    @Override
    public Judet judet() {
        String judetAsStr=cnpAsString.substring(7,9);
        if (judetAsStr.equals("01"))
            return Judet.AB;
        else if (judetAsStr.equals("12"))
            return Judet.CJ;
        else if (judetAsStr.equals("18"))
            return Judet.GJ;
        else if (judetAsStr.equals("40"))
            return Judet.BU;
        return Judet.None;
    }

    @Override
    public CalDate birthDate() {
        CalDate calDate=new CalDateImpl(cnpAsString);
        return calDate;
    }

    @Override
    public Short orderNumber() {
        return Short.parseShort(cnpAsString.substring(9,12));
    }
}
