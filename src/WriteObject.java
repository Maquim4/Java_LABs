import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class WriteObject {


    public static void serialize(AirCompany Aircompany) {

        FileOutputStream fout = null;
        ObjectOutputStream oos = null;

        try {

            fout = new FileOutputStream("test");
            oos = new ObjectOutputStream(fout);
            oos.writeObject(Aircompany);

            System.out.println("Done");

        } catch (Exception ex) {

            ex.printStackTrace();

        } finally {

            if (fout != null) {
                try {
                    fout.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    public void serializeJDK7(AirCompany Aircompany) {

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test"))) {

            oos.writeObject(Aircompany);
            System.out.println("Done");

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
