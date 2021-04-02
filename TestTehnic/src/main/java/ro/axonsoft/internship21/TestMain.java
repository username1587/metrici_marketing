package ro.axonsoft.internship21;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class TestMain {
    /**
     * main folosit pentru afisarea datelor dintr-un fisier (pentru a verifica
     * corectitudinea datelor scrise folosind clasa Main)
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {


        String inputFileName = "data/outputFile.txt";

        Object obj = TestMain.ReadObjectFromFile(inputFileName);

        System.out.println(obj);
    }

    private static Object ReadObjectFromFile(String filepath) {

        try {

            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object obj = objectIn.readObject();

            System.out.println("The Object has been read from the file");
            objectIn.close();
            return obj;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
