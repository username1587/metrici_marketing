package ro.axonsoft.internship21;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Repository care incarca datele dintr un fisier in memorie
 */
public class Repo {

    /**
     *
     * @param obj
     * @return InputStream of obj
     * @throws IOException
     */
    public static InputStream ConvertObjectToInputStream(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);

        oos.writeObject(obj);

        oos.flush();
        oos.close();

        InputStream is = new ByteArrayInputStream(baos.toByteArray());

        return is;
    }

    /**
     *
     * @param is
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static Object ConvertInputStreamToObj(InputStream is) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(is);
        Object object = ois.readObject();
        return object;
    }

    /**
     *
     * @param fileName = file path
     * @return list of lines in string
     */
    public static List<String> LoadFileAsListOfStrings(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.equals(""))
                    continue;       // skip empty lines
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return lines;
    }
}
