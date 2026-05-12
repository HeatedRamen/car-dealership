package com.pluralsight;

import java.io.*;


public class DealershipFileManager {

    public Dealership getDealership(){

        try {
            BufferedReader bufReader = new BufferedReader(new FileReader("inventory.csv"));
            Dealership dealership = new Dealership();

            convertHeader(bufReader.readLine(), dealership);

            String line = bufReader.readLine();
            while (line != null){
                convertVehicle(line, dealership);
                bufReader.readLine();
            }

            return dealership;
        }
        catch (Exception IOException){
            System.out.println("File not found!");
            return null;
        }
    }

    public void convertHeader(String headerLine, Dealership dealership){
        String[] parsedHeader = headerLine.split("\\|");

        dealership.setName(parsedHeader[0]);
        dealership.setAddress(parsedHeader[1]);
        dealership.setPhone(parsedHeader[2]);
    }

    public void convertVehicle(String line, Dealership dealership){
        String[] parsedLine = line.split("\\|");

        dealership.addVehicle(new Vehicle(Integer.parseInt(parsedLine[0]), Integer.parseInt(parsedLine[1]), parsedLine[2], parsedLine[3],
                parsedLine[4], parsedLine[5], Integer.parseInt(parsedLine[6]), Double.parseDouble(parsedLine[7])));
    }

    public void saveDealership(Dealership dealership){

        try{
            BufferedWriter bufWriter = new BufferedWriter(new FileWriter("inventory.csv"));
            bufWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());

            for (Vehicle vehicle : dealership.getAllVehicle()){
                bufWriter.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                                    vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" + vehicle.getColor() + "|" +
                                    vehicle.getOdometer() + "|" + vehicle.getPrice());
            }
        }
        catch (Exception IOException){
            System.out.println("File not found!");
        }
    }

}
