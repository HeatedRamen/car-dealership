package com.pluralsight;

import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    static Scanner input = new Scanner(System.in);

    UserInterface() {
        dealership = new Dealership();
    }

    public void display() {
        init();

        boolean isRunning = true;

        while (isRunning) {
            displayHome();
            isRunning = runHomeMenuChoice(promptUser());
        }
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public void displayHome() {
        System.out.println("""
                ==============================================
                                Dealership Menu
                ==============================================
                                1. Search Vehicles
                                2. Add Vehicle
                                3. Remove Vehicle
                                4. Exit App
                ==============================================""");
    }

    public String promptUser() {
        System.out.println("Enter in your choice:");
        return input.nextLine();
    }

    public boolean runHomeMenuChoice(String userChoice) {
        switch (userChoice) {
            case "1":
                runSearchMenu();
                return true;
            case "2":
                processAddVehicleRequest();
                return true;
            case "3":
                processRemoveVehicleRequest();
                return true;
            case "4":
                return false;
            default:
                System.out.println("Enter a valid option");
                return true;
        }
    }

    public void runSearchMenu(){
        displaySearchMenu();
        runSearchMenuChoice(promptUser());
    }

    public void displaySearchMenu(){
        System.out.println("""
                ================================================
                                 Search Options
                ================================================
                                    1. Price
                                    2. Make / Model
                                    3. Year
                                    4. Color
                                    5. Mileage
                                    6. Vehicle Type
                                    7. Display All Vehicles
                ================================================""");
    }

    public void runSearchMenuChoice(String userChoice){
        switch (userChoice){
            case "1" -> processGetByPriceRequest();
            case "2" -> processGetByMakeModelRequest();
            case "3" -> processGetByYearRequest();
            case "4" -> processGetByColorRequest();
            case "5" -> processGetByMileageRequest();
            case "6" -> processGetByVehicleTypeRequest();
            case "7" -> processAllVehicleRequest();
            default -> System.out.println("Enter a valid option");
        }
    }
    public void processGetByPriceRequest() {}
    public void processGetByMakeModelRequest() {}
    public void processGetByYearRequest() {}
    public void processGetByColorRequest() {}
    public void processGetByMileageRequest() {}
    public void processGetByVehicleTypeRequest() {}
    public void processAllVehicleRequest() {
        for (Vehicle vehicle : dealership.getAllVehicle()){
            displayVehicle(vehicle);
        }
    }
    public void processAddVehicleRequest() {}
    public void processRemoveVehicleRequest() {}

    private void displayVehicle(Vehicle vehicle) {
        System.out.println(vehicle);
    }

}
