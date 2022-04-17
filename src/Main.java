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



        String[] options2 = {
                "1- Add plane ",
                "2- Print all planes ",
                "3- Sort by distance",
                "4- Calculate total capacity and carrying",
                "5- Find plane by fuel input range",
                "6- Back",

        };



        String[] options1 = {
                "1- Create Aircompany ",
                "2- Write information ",
                "3- Read information",
                "4- Exit",

        };

        int option=1;

        while (option !=5) {
            printMenu(options1);

            option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    System.out.println("Please enter company name: ");
                    String nick = scanner.nextLine();
                    if (nick.equals("")) throw new ScannerException("String can not be empty!");
                    AirCompany Aircompany = new AirCompany(nick);
                    menu(options2,scanner,Aircompany);
                    break;

                case 2: WriteObject.serialize( Aircompany );

                    break;

                case 3:
                    AirCompany Aircompany = ReadObject.deserialze("test");
                    System.out.println(Aircompany);

                    break;
                case 4:
                    exit(0);

            }

        }



        scanner.close();// закрытие потока


    }

    private static void menu(String[] options2,Scanner scanner, AirCompany Aircompany) throws ScannerException {


            boolean flag=true;
            int option;

            while (flag) {
                printMenu(options2);

                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:  System.out.println(" Enter plane name: ");
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

                        break;
                    case 2: Aircompany.printAllPlanes(Aircompany);

                        break;

                    case 3:
                        Comparator MaxDistanceComparator = new DistanceComparator();
                        Collections.sort(Aircompany.getPlanesList(), MaxDistanceComparator);

                        break;
                    case 4:
                        Aircompany.calculateCC(Aircompany);
                        break;
                    case 5:
                        Aircompany.findByFuelInput(scanner,Aircompany);
                        break;
                    case 8:
                        flag=false;
                        break;

                }

            }



    }


}