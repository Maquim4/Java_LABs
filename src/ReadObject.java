import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObject {


    public static AirCompany deserialze(String filename) {

        AirCompany Aircompany = null;

        FileInputStream fin = null;
        ObjectInputStream ois = null;

        try {

            fin = new FileInputStream(filename);
            ois = new ObjectInputStream(fin);
            Aircompany = (AirCompany) ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {

            if (fin != null) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

        return Aircompany;

    }

    public AirCompany deserialzeJDK7(String filename) {

        AirCompany Aircompany = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {

            Aircompany = (AirCompany) ois.readObject();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return Aircompany;

    }

}