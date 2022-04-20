import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.io.File;

import static java.lang.System.exit;

public class Main {

    public static void printMenu(String[] options) {
        for (String option : options) {
            System.out.println(option);
        }
        System.out.print("Choose your option : ");
    }

    public static void main(String[] args) throws ScannerException {
        File file = new File("test");
        Scanner scanner = new Scanner(System.in);



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
                "2- Print all companies ",
                "3- Read information ",
                "4- add information ",
                "5- Exit",

        };


        AirCompany [] Aircompanies = new AirCompany[2];


        int option=1;
        while (option !=5) {
            printMenu(options1);
            try {

                option = scanner.nextInt();
                scanner.nextLine();
                switch (option) {
                    case 1:

                        System.out.println("Please enter company name: ");
                        String nick1 = scanner.nextLine();
                        if (nick1.equals("")) throw new ScannerException("String can not be empty!");
                        Aircompanies[0] = new AirCompany(nick1);
                        menu(options2, scanner, Aircompanies[0]);

                      /*  System.out.println("Please enter company name: ");
                        String nick2 = scanner.nextLine();
                        if (nick2.equals("")) throw new ScannerException("String can not be empty!");
                        Aircompanies[1] = new AirCompany(nick2);
                        menu(options2, scanner, Aircompanies[1]);
                        break;*/


                    case 2:

                        System.out.println(Aircompanies[0].toString());
                        System.out.println("Our planes :");
                        for (Plane plane : Aircompanies[0].getPlanesList()) {

                            System.out.println(plane.toString());
                        }

                   /* System.out.println(Aircompanies[1].toString());
                    System.out.println("Our planes :");
                    for(Plane plane: Aircompanies[1].getPlanesList()){

                        System.out.println(plane.toString());
                    }*/

                        WriteObject.serialize(Aircompanies[0]);
                        // WriteObject.serialize( Aircompanies[1] );

                        break;

                    case 3:
                        Aircompanies[0] = ReadObject.deserialize("test");
                        System.out.println(Aircompanies[0]);
                        for (Plane plane : Aircompanies[0].getPlanesList()) {

                            System.out.println(plane.toString());
                        }
                        /*Aircompanies[1] = ReadObject.deserialize("test");
                        System.out.println(Aircompanies[1]);
                        for (Plane plane : Aircompanies[1].getPlanesList()) {

                            System.out.println(plane.toString());
                        }*/

                        break;
                    case 4:
                        menu(options2, scanner, Aircompanies[0]);
                        WriteObject.serialize(Aircompanies[0]);
                       break;
                    case 5:
                        exit(0);

                }
            }catch(Exception e){
                System.out.println(" something went wrong, tap any key");
                scanner.nextLine();
            }

        }
        scanner.close();


    }

    private static void menu(String[] options2,Scanner scanner, AirCompany Aircompany) throws ScannerException {


            boolean flag=true;
            int option;

            while (flag) {
                printMenu(options2);
                try {

                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            System.out.println(" Enter plane name: ");
                            String name = scanner.nextLine();
                            if (name.equals("")) throw new ScannerException("String can not be empty!");

                            System.out.println(" Enter capacity:  ");
                            int capacity = scanner.nextInt();
                            if (capacity < 0) throw new ScannerException("Value cannot be less than zero");

                            System.out.println(" Enter carrying:  ");
                            double carrying = scanner.nextDouble();
                            if (carrying < 0) throw new ScannerException("Value cannot be less than zero");

                            System.out.println(" Enter distance:  ");
                            double distance = scanner.nextDouble();
                            if (distance < 0) throw new ScannerException("Value cannot be less than zero");

                            System.out.println(" Enter fuelInput: ");
                            double fuelInput = scanner.nextDouble();
                            if (fuelInput < 0) throw new ScannerException("Value cannot be less than zero");

                            Plane plane = new Plane(name, capacity, carrying, distance, fuelInput);
                            Aircompany.addPlane(plane);
                            System.out.println(plane.toString());
                            break;

                        case 2:
                            Aircompany.printAllPlanes(Aircompany);

                            break;

                        case 3:
                            Comparator MaxDistanceComparator = new DistanceComparator();
                            Collections.sort(Aircompany.getPlanesList(), MaxDistanceComparator);

                            break;
                        case 4:
                            Aircompany.calculateCC(Aircompany);
                            break;
                        case 5:
                            Aircompany.findByFuelInput(scanner, Aircompany);
                            break;
                        case 6:
                            flag = false;
                            break;

                    }
                }catch(Exception e){
                    System.out.println(" something went wrong, tap any key");
                    scanner.nextLine();
                }

            }



    }
    public boolean isFileEmpty(File file) {
        return file.length() == 0;
    }



}