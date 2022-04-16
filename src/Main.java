import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import static java.lang.System.exit;

public class Main {

    static AirCompany Aircompany;
    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void main(String[] args) throws ScannerException {
        Scanner scanner = new Scanner(System.in);// класс Scanner для ввода данных из консоли

        System.out.println("Please enter company name: ");

        String nick = scanner.nextLine();
        if (nick.equals("")) throw new ScannerException("String can not be empty!");


        Aircompany = new AirCompany(nick);

        String[] options = {"1- Add plane ",
                "2- Print all planes ",
                "3- Sort by distance",
                "4- Calculate total capacity and carrying",
                "5- Find plane by fuel input range",
                "6- Exit",

        };

        int option = 1;

        while (option != 6) {
            printMenu(options);

                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:addPlane(scanner);

                        break;
                    case 2: printAllPlanes();

                        break;

                    case 3:
                        Comparator MaxDistanceComparator = new DistanceComparator();
                        Collections.sort(Aircompany.getPlanesList(), MaxDistanceComparator);

                        break;
                    case 4:
                        calculateCC();
                        break;
                    case 5:
                        findByFuelInput(scanner);
                        break;
                    case 6:
                        exit(0);

                }

        }
        scanner.close();// закрытие потока


    }
    // options
    private static void addPlane (Scanner scanner) throws ScannerException {

        System.out.println(" Enter plane name: ");
        String name = scanner.nextLine();
        if (name.equals("")) throw new ScannerException("String can not be empty!");

        System.out.println(" Enter capacity:  ");
        int capacity = scanner.nextInt();
        if (capacity<0) throw new ScannerException("Value cannot be less than zero");

        System.out.println(" Enter carrying:  ");
        double carrying = scanner.nextDouble();
        if (carrying<0) throw new ScannerException("Value cannot be less than zero");

        System.out.println(" Enter distance:  ");
        double distance = scanner.nextDouble();
        if (distance<0) throw new ScannerException("Value cannot be less than zero");

        System.out.println(" Enter fuelInput: ");
        double fuelInput = scanner.nextDouble();
        if (fuelInput<0) throw new ScannerException("Value cannot be less than zero");

        Plane plane = new Plane(name,capacity,carrying,distance,fuelInput);

        Aircompany.addPlane(plane);

        System.out.println(plane.toString());

    }

    private static void printAllPlanes() {
        System.out.println("Our planes :");
        for(Plane plane: Aircompany.getPlanesList()){

            System.out.println(plane.toString());
        }
    }


    private static void calculateCC() {
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

    private static void findByFuelInput (Scanner scanner) {
        System.out.println("Enter left and right limits: ");
        double x=scanner.nextDouble();
        double y=scanner.nextDouble();
        for(Plane plane : Aircompany.getPlanesList()) {
            if (plane.getFuelInput()>=x && plane.getFuelInput()<=y)
                System.out.println(plane.toString());


        }

    }



}