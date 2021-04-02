package ro.axonsoft.internship21.cnp;

import ro.axonsoft.internship21.cnp.utils.Judet;
import ro.axonsoft.internship21.cnp.utils.Sex;


/**
 * clasa care ruleaza teste pentru clasa CnpParts
 */
public class TestCnpPartsImpl {

    public static void testSex(){
        CnpParts cnpParts=new CnpPartsImpl("1000000000000");
        assert (cnpParts.sex()== Sex.M);
        CnpParts cnpParts2=new CnpPartsImpl("6000000000000");
        assert (cnpParts2.sex()== Sex.F);
        CnpParts cnpParts3=new CnpPartsImpl("9000000000000");
        assert (cnpParts3.sex()== Sex.U);

//        assert (false);
    }

    public static void testForeigner(){
        CnpParts cnpParts=new CnpPartsImpl("1000000000000");
        assert (cnpParts.foreigner().equals(false));
        CnpParts cnpParts2=new CnpPartsImpl("6000000000000");
        assert (cnpParts2.foreigner().equals(false));
        CnpParts cnpParts3=new CnpPartsImpl("9000000000000");
        assert (cnpParts3.foreigner().equals(true));

//        assert (false);
    }

    public static void testBirthDate(){
        {
            CnpParts cnpParts=new CnpPartsImpl("1990607000000");
            assert (cnpParts.birthDate().year().equals((short)1999));
            assert (cnpParts.birthDate().month().equals((byte)6));
            assert (cnpParts.birthDate().day().equals((byte)7));
        }
        {
            CnpParts cnpParts=new CnpPartsImpl("2990607000000");
            assert (cnpParts.birthDate().year().equals((short)1999));
            assert (cnpParts.birthDate().month().equals((byte)6));
            assert (cnpParts.birthDate().day().equals((byte)7));
        }
        {
            CnpParts cnpParts=new CnpPartsImpl("3990112000000");
            assert (cnpParts.birthDate().year().equals((short)1899));
            assert (cnpParts.birthDate().month().equals((byte)1));
            assert (cnpParts.birthDate().day().equals((byte)12));
        }
        {
            CnpParts cnpParts=new CnpPartsImpl("4990607000000");
            assert (cnpParts.birthDate().year().equals((short)1899));
            assert (cnpParts.birthDate().month().equals((byte)6));
            assert (cnpParts.birthDate().day().equals((byte)7));
        }
        {
            CnpParts cnpParts=new CnpPartsImpl("5990602000000");
            assert (cnpParts.birthDate().year().equals((short)2099));
            assert (cnpParts.birthDate().month().equals((byte)6));
            assert (cnpParts.birthDate().day().equals((byte)2));
        }
        {
            CnpParts cnpParts=new CnpPartsImpl("6990811000000");
            assert (cnpParts.birthDate().year().equals((short)2099));
            assert (cnpParts.birthDate().month().equals((byte)8));
            assert (cnpParts.birthDate().day().equals((byte)11));
        }
    }

    public static void testOrderNumber(){
        CnpParts cnpParts=new CnpPartsImpl("0000000001230");
        assert (cnpParts.orderNumber().equals((short)123));
        CnpParts cnpParts2=new CnpPartsImpl("6000000004560");
        assert (cnpParts2.orderNumber().equals((short)456));
        CnpParts cnpParts3=new CnpPartsImpl("9123400000000");
        assert (cnpParts3.orderNumber().equals((short)0));

//        assert (false);
    }

    public static void testJudet(){
        CnpParts cnpParts=new CnpPartsImpl("1930107189436");
        assert (cnpParts.judet().equals(Judet.GJ));
        CnpParts cnpParts2=new CnpPartsImpl("1960608409971");
        assert (cnpParts2.judet().equals(Judet.BU));

//        assert (false);
    }

    public static void main(String[] args){
        testSex();
        testForeigner();
        testBirthDate();
        testOrderNumber();
        testJudet();
        System.out.println("teste CnpPartsImpl trecute !");
    }
}
