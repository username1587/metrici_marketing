package ro.axonsoft.internship21;

import ro.axonsoft.internship21.pay.PayMetricsProcessor;
import ro.axonsoft.internship21.pay.PayMetricsProcessorImpl;
import ro.axonsoft.internship21.validatoare.*;

import java.io.*;
import java.util.List;

public class Main {

    /**
     * Main principal care ruleaza aplicatia si executa cerinta data
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        String inputFileName="data/inputFile.txt";
        String outputFileName="data/outputFile.txt";

        Repo repo=new Repo();

        List<String> lines=repo.LoadFileAsListOfStrings(inputFileName);

        PayMetricsProcessor payMetricsProcessor=new PayMetricsProcessorImpl();

        InputStream paymentsInputStream=repo.ConvertObjectToInputStream(lines);

        OutputStream metricsOutputStream=new FileOutputStream(outputFileName);

        payMetricsProcessor.process(paymentsInputStream,metricsOutputStream);

        System.out.println("gata programu");
    }

}
