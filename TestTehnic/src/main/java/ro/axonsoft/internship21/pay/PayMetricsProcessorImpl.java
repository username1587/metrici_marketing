package ro.axonsoft.internship21.pay;

import ro.axonsoft.internship21.Repo;

import java.io.*;
import java.util.List;

public class PayMetricsProcessorImpl implements PayMetricsProcessor {

    @Override
    public void process(InputStream paymentsInputStream, OutputStream metricsOutputStream) throws IOException {
        // load input stream into an object
        List<String> obj=null;
        try{
            obj=(List<String>)(Repo.ConvertInputStreamToObj(paymentsInputStream));
        }
        catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }

        // call payMetricsConstructor
        PayMetrics payMetrics = new PayMetricsImpl(obj);

        // serialize object and put it in file
        WriteObjectToFile(payMetrics, metricsOutputStream);
    }

    private void WriteObjectToFile(Object serObj, OutputStream outputStream) {
        try {
//            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(outputStream);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
