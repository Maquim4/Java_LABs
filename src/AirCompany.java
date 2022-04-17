import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.util.Scanner;

public class AirCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nick;
    private List<Plane> planesList = new ArrayList<Plane>();

    public AirCompany(String nick) {

        this.nick=nick;

    }

    public String getNick() {
        return nick;
    }


    public List<Plane> getPlanesList() {
        return planesList;
    }

    public void setPlanesList(List<Plane> planesList) {
        this.planesList = planesList;
    }

    public void addPlane (Plane plane){

        planesList.add(plane);
    }

    public static void calculateCC (AirCompany Aircompany) {
        double sum=0;
        for(Plane plane : Aircompany.getPlanesList()) {
            sum=sum+ plane.getCapacity();
        }
        System.out.println("Total capacity: " + sum);
        sum=0;
        for(Plane plane : Aircompany.getPlanesList()) {
            sum=sum+ plane.getCarrying();
        }
        System.out.println("Total carrying: " + sum);


    }

    public static void findByFuelInput (Scanner scanner, AirCompany Aircompany) {
        System.out.println("Enter left and right limits: ");
        double x=scanner.nextDouble();
        double y=scanner.nextDouble();
        for(Plane plane : Aircompany.getPlanesList()) {
            if (plane.getFuelInput()>=x && plane.getFuelInput()<=y)
                System.out.println(plane.toString());


        }

    }

    public static void printAllPlanes(AirCompany Aircompany) {
        System.out.println("Our planes :");
        for(Plane plane: Aircompany.getPlanesList()){

            System.out.println(plane.toString());
        }
    }







}