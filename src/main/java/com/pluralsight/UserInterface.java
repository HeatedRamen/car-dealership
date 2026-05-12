package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
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
    public void processGetByPriceRequest() {
        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println("What is the minimum price for the vehicle?: ");
            double min = input.nextDouble();
            System.out.println("What is the maximum price for the vehicle?: ");
            double max = input.nextDouble();
            input.nextLine(); // Clear buffer

            if (max < min){
                System.out.println("Invalid Range. Try again.");
                continue;
            } else {
                displayVehicle(dealership.getVehicleByPrice(min, max));
                isValidInput = true;
            }
        }
    }

    public void processGetByMakeModelRequest() {
        System.out.println("What is the make of the vehicle?: ");
        String make = input.nextLine();
        System.out.println("What is the model of the vehicle? ");
        String model = input.nextLine();

        displayVehicle(dealership.getVehicleByMakeModel(make, model));

    }
    public void processGetByYearRequest() {

        boolean isValidInput = false;

        while (!isValidInput) {
            System.out.println("What is the minimum year for the vehicle?: ");
            int min = input.nextInt();
            System.out.println("What is the maximum year for the vehicle?: ");
            int max = input.nextInt();
            input.nextLine(); // Clear buffer

            if (max < min) {
                System.out.println("Invalid Range. Try again.");
                continue;
            } else {
                displayVehicle(dealership.getVehicleByYear(min, max));
                isValidInput = true;
            }
        }
    }
    public void processGetByColorRequest() {
        System.out.println("What is the color of the vehicle?: ");
        String color = input.nextLine();

        displayVehicle(dealership.getVehicleByColor(color));
    }

    public void processGetByMileageRequest() {

        boolean validInput = false;

        while (!validInput) {
            System.out.println("What is the minimum miles for the vehicle?: ");
            int min = input.nextInt();
            System.out.println("What is the maximum miles for the vehicle?: ");
            int max = input.nextInt();
            input.nextLine(); // Clear buffer

            if (max < min) {
                System.out.println("Invalid Range. Try again.");
                continue;
            } else {
                displayVehicle(dealership.getVehicleByMileage(min, max));
                validInput = true;
            }
        }
    }

    public void processGetByVehicleTypeRequest() {
        System.out.println("What is the type of the vehicle?: ");
        String vehicleType = input.nextLine();

        displayVehicle(dealership.getVehicleByType(vehicleType));
    }

    public void processAllVehicleRequest() {
        displayVehicle(dealership.getAllVehicle());
    }


    public void processAddVehicleRequest() {

        boolean isValidInput = false;

        while(!isValidInput) {
            System.out.println("What is the VIN of the vehicle?: ");
            String vin = input.nextLine();
            System.out.println("What is the year of the vehicle?: ");
            String year = input.nextLine();
            System.out.println("What is the make of the vehicle?: ");
            String make = input.nextLine();
            System.out.println("What is the model of the vehicle?: ");
            String model = input.nextLine();
            System.out.println("What is the vehicle type?: ");
            String vehicleType = input.nextLine();
            System.out.println("What is the color of the vehicle?: ");
            String color = input.nextLine();
            System.out.println("What is the mileage of the vehicle?: ");
            String mileage = input.nextLine();
            System.out.println("What is the price of the vehicle?: ");
            String price = input.nextLine();

            try{
                Vehicle newVehicle = new Vehicle(Integer.parseInt(vin), Integer.parseInt(year), make, model,
                                                vehicleType, color, Integer.parseInt(mileage), Double.parseDouble(price));
                dealership.addVehicle(newVehicle);
                isValidInput = true;

            } catch (Exception Parse){
                System.out.println("Invalid Input. Try Again");
            }
        }

    }
    public void processRemoveVehicleRequest() {
        System.out.println("Enter the VIN of the vehicle you want to remove: ");
        String vin = input.nextLine();

        boolean removeVehicle = false;
        for(Vehicle vehicle : dealership.getAllVehicle()){
            if (vehicle.getVin() == Integer.parseInt(vin)){
                dealership.removeVehicle(vehicle);
                removeVehicle = true;
                return;
            }
        }

        if (!removeVehicle){
            System.out.println("Vehicle not found");
        }
    }

    private void displayVehicle(List<Vehicle> filteredVehicles) {

        if (filteredVehicles.isEmpty()) {
            System.out.println("No vehicles matched this description.");
        } else {
            for (Vehicle vehicle : filteredVehicles) {
                System.out.println(vehicle);
            }
        }
    }
}
