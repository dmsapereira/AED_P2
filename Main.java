import bikeManagement.BikeManagement;
import bikeManagement.BikeManagementClass;
import bikeManagement.PickUp;
import bikeManagement.parks.Park;
import bikeManagement.users.User;
import dataStructures.Iterator;
import dataStructures.Queue;
import exceptions.CustomException;

import java.io.*;
import java.util.Scanner;

enum Command {
    ADDUSER(), REMOVEUSER(), GETUSERINFO(), ADDPARK(), ADDBIKE(), REMOVEBIKE(), GETPARKINFO(), PICKUP(), PICKDOWN(), CHARGEUSER(), BIKEPICKUPS(), USERPICKUPS(), PARKEDBIKE(), LISTDELAYED(), FAVORITEPARKS(), XS();

    String input;

    Command() {}
}

public class Main {
     private static final String LIST_FORMAT = "%s %s %s %d %d %d\n";
     private static final String USER_INFO_FORMAT = "%s: %s, %s, %s, %s, %s, %s\n";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BikeManagement system = load();
        processCommand(in, system);
        save(system);
        System.out.println("Gravando e terminando...");
        System.out.println();
    }

    private static Command readCommand(Scanner in) {
        String input = in.next().toUpperCase();
        return Command.valueOf(input.toUpperCase());
    }

    private static void processCommand(Scanner in, BikeManagement system) {
        Command input = readCommand(in);
        while (!input.equals(Command.XS)) {
            switch (input) {
                case ADDUSER:
                    commandAddUser(in, system);
                    break;
                case REMOVEUSER:
                    commandRemoveUser(in, system);
                    break;
                case GETUSERINFO:
                    commandGetUserInfo(in, system);
                    break;
                case ADDPARK:
                    commandAddPark(in, system);
                    break;
                case ADDBIKE:
                    commandAddBike(in, system);
                    break;
                case REMOVEBIKE:
                    commandRemoveBike(in, system);
                    break;
                case GETPARKINFO:
                    commandGetParkInfo(in, system);
                    break;
                case PICKUP:
                    commandPickup(in, system);
                    break;
                case PICKDOWN:
                    commandPickdown(in, system);
                    break;
                case CHARGEUSER:
                    commandChargeUser(in, system);
                    break;
                case BIKEPICKUPS:
                    commandBikePickups(in, system);
                    break;
                case USERPICKUPS:
                    commandUserPickups(in, system);
                    break;
                case PARKEDBIKE:
                    commandParkedBike(in, system);
                    break;
                case LISTDELAYED:
                    commandListDelayed(in, system);
                    break;
                case FAVORITEPARKS:
                    commandFavoriteParks(in, system);
                    break;
                case XS:
                    break;
            }
            System.out.println();
            input = readCommand(in);
        }
    }

    private static void save(BikeManagement system) {
        try {
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream("savefile"));
            file.writeObject(system);
            file.flush();
            file.close();
        } catch (IOException e) {
            System.out.println("Ficheiro nao foi encontrado.");
        }
    }

    private static BikeManagement load() {
        BikeManagement management;
        try {
            ObjectInputStream file = new ObjectInputStream((new FileInputStream("savefile")));
            management = (BikeManagement) file.readObject();
            file.close();
        } catch (IOException | ClassNotFoundException e) {
            management = new BikeManagementClass();
        }
        return management;
    }

    private static void commandFavoriteParks(Scanner in, BikeManagement system) {
        Park park;
        in.nextLine();
        try {
            park = system.favoriteParks();
            if (park.getPickups() == 0)
                System.out.println("Nao foram efetuados pickups.");
            else
                System.out.println(park.getName() + ": " + park.getAddress() + ", " + park.getPickups());
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandListDelayed(Scanner in, BikeManagement system) {
        System.out.println("Nao se registaram atrasos.");
    }

    private static void commandParkedBike(Scanner in, BikeManagement system) {
        String idBike = in.next();
        String idPark = in.next();
        in.nextLine();
        try {
            if (system.parkedBike(idBike, idPark))
                System.out.println("Bicicleta estacionada no parque.");
            else
                System.out.println("Bicicleta nao esta em parque.");
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void printBikePickups(Iterator<PickUp> itera) {
        PickUp current;
        if (!itera.hasNext())
            System.out.println("Nao foram efetuados pickups.");
        else {
            while (itera.hasNext()) {
                current = itera.next();
                System.out.printf(LIST_FORMAT, current.getUser().getUserId(), current.getInitialPark().getParkId(), current.getFinalPark().getParkId(), current.getDuration(), current.getDelay(), current.getCost());
            }
        }
    }
    private static void printUserPickups(Iterator<PickUp> itera) {
        PickUp current;
        if (!itera.hasNext())
            System.out.println("Nao foram efetuados pickups.");
        else {
            while (itera.hasNext()) {
                current = itera.next();
                System.out.printf(LIST_FORMAT, current.getBike().getBikeId(), current.getInitialPark().getParkId(), current.getFinalPark().getParkId(), current.getDuration(), current.getDelay(), current.getCost());
            }
        }
    }

    private static void commandUserPickups(Scanner in, BikeManagement system) {
        String idUser = in.next();
        in.nextLine();
        try {
            printUserPickups(system.listUserPickups(idUser));
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandBikePickups(Scanner in, BikeManagement system) {
        String idBike = in.next();
        in.nextLine();
        try {
            printBikePickups(system.listBikePickups(idBike));
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandChargeUser(Scanner in, BikeManagement system) {
        User user;
        String idUser = in.next();
        int amount = in.nextInt();
        in.nextLine();
        try {
            user = system.chargeUser(idUser, amount);
            System.out.println("Saldo: " + user.getBalance() + " euros");
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandPickdown(Scanner in, BikeManagement system) {
        User user;
        String idBike = in.next();
        String idPark = in.next();
        int duration = in.nextInt();
        in.nextLine();
        try {
            user = system.pickDown(idBike, idPark, duration);
            System.out.println("Pickdown com sucesso: " + user.getBalance() + " euros, " + user.getPoints() + " pontos");
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandPickup(Scanner in, BikeManagement system) {
        String idBike = in.next();
        String idUser = in.next();
        in.nextLine();
        try {
            system.pickUp(idBike, idUser);
            System.out.println("PickUp com sucesso.");
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandGetParkInfo(Scanner in, BikeManagement system) {
        Queue<String> info;
        String idPark = in.next();
        in.nextLine();
        try {
            info = system.getParkInfo(idPark);
            System.out.println(info.dequeue() + ": " + info.dequeue() + ", " + info.dequeue());
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandRemoveBike(Scanner in, BikeManagement system) {
        String idBike = in.next();
        in.nextLine();
        try {
            system.removeBike(idBike);
            System.out.println("Bicicleta removida com sucesso.");
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandAddBike(Scanner in, BikeManagement system) {
        String idBike = in.next();
        String idPark = in.next();
        String plate = in.nextLine().trim();
        try {
            system.addBike(idBike, idPark, plate);
            System.out.println("Bicicleta adicionada com sucesso.");
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandAddPark(Scanner in, BikeManagement system) {
        String idPark = in.next();
        String name = in.nextLine().trim();
        String address = in.nextLine().trim();
        try {
            system.addPark(idPark, name, address);
            System.out.println("Parque adicionado com sucesso.");
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandGetUserInfo(Scanner in, BikeManagement system) {
        Queue<String> info;
        String idUser = in.next();
        in.nextLine();
        try {
            info = system.getUserInfo(idUser);
            System.out.printf(USER_INFO_FORMAT, info.dequeue(), info.dequeue(), info.dequeue(), info.dequeue(), info.dequeue(), info.dequeue(), info.dequeue());
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandRemoveUser(Scanner in, BikeManagement system) {
        String idUser = in.next();
        in.nextLine();
        try {
            system.removeUser(idUser);
            System.out.println("Utilizador removido com sucesso.");
        } catch (CustomException e) {
            System.out.println(e);
        }
    }

    private static void commandAddUser(Scanner in, BikeManagement system) {
        String idUser = in.next();
        String nif = in.next();
        String email = in.next();
        String phone = in.next();
        String name = in.nextLine().trim();
        String address = in.nextLine();
        try {
            system.addUser(idUser, nif, email, phone, name, address);
            System.out.println("Insercao de utilizador com sucesso.");
        } catch (CustomException e) {
            System.out.println(e);
        }
    }
}
