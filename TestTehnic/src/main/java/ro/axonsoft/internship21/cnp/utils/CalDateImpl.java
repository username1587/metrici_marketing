package ro.axonsoft.internship21.cnp.utils;

public class CalDateImpl implements CalDate{

    String CNP;

    public CalDateImpl(String CNP) {
        this.CNP=CNP;
    }

    @Override
    public Short year() {
        String yearAsStr=CNP.substring(1,3);
        Short year=Short.parseShort(yearAsStr);

        Integer firstDigit=CNP.charAt(0)-'0';

        if (firstDigit.equals(1) || firstDigit.equals(2)){
            year=(short)(year+1900);
        }
        else if (firstDigit.equals(3) || firstDigit.equals(4)){
            year=(short)(year+1800);
        }
        else if (firstDigit.equals(5) || firstDigit.equals(6)) {
            year=(short)(year+2000);
        }
        else
            return -1;

        return year;
    }

    @Override
    public Byte month() {
        String monthAsStr=CNP.substring(3,5);
        Byte month=Byte.parseByte(monthAsStr);
        return month;
    }

    @Override
    public Byte day() {
        String dayAsStr=CNP.substring(5,7);
        Byte day=Byte.parseByte(dayAsStr);
        return day;
    }
}
