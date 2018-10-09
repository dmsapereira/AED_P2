import bikeManagement.BikeManagement;

import java.util.Scanner;

enum Command {
    ADD_USER("ADDUSER"), REMOVE_USER("REMOVEUSER"), GET_USER_INFO("GETUSERINFO"), ADD_PARK("ADDPARK"), ADD_BIKE("ADDBIKE"), REMOVE_BIKE("REMOVEBIKE"), GET_PARK_INFO("GETPARNKINFO"), PICKUP("PICKUP"), PICKDOWN("PICKDOWN"), CHARGE_USER("CHARGEUSER"), BIKE_PICKUPS("BIKEPICKUPS"), USER_PICKUPS("USERPICKUPS"), PARKED_BIKE("PARKEDBIKE"), LIST_DELAYED("LISTDELAYED"), FAVORITE_PARKS("FAVORITEPARKS"), XS("XS");

    String input;
     Command(String command){
        input=command;
    }

    String getInput(){
         return input;
    }
}

public class Main {
    public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    }

    private static Command readCommand(Scanner in){
        String input=in.next().toUpperCase();
        return Command.valueOf(input);
    }

    private static void processCommand(Scanner in, BikeManagement system){
        Command input=readCommand(in);
        switch(input){
            case ADD_USER:

            case REMOVE_USER:
                break;
            case GET_USER_INFO:
                break;
            case ADD_PARK:
                break;
            case ADD_BIKE:
                break;
            case REMOVE_BIKE:
                break;
            case GET_PARK_INFO:
                break;
            case PICKUP:
                break;
            case PICKDOWN:
                break;
            case CHARGE_USER:
                break;
            case BIKE_PICKUPS:
                break;
            case USER_PICKUPS:
                break;
            case PARKED_BIKE:
                break;
            case LIST_DELAYED:
                break;
            case FAVORITE_PARKS:
                break;
            case XS:
                break;
        }
    }
}
