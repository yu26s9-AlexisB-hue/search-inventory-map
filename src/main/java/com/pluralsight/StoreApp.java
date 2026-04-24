package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class StoreApp {

    public static void main(String[] args){

        HashMap<String, Product> inventory;
        inventory = getInventory();

        System.out.println("The current list: ");
        for(Product p : inventory.values()){
            System.out.printf("id: %d %s - Price: $%.2f%n", p.getId(),p.getName(),p.getPrice());

        }


        Scanner scanner = new Scanner(System.in);
        System.out.print("What item name are you interested in? ");
        String name = scanner.nextLine();

        //searches through the products
        Product matchedProduct = inventory.get(name);
        if (matchedProduct == null){
            System.out.println("We don't carry that product");
            return;
        }
        System.out.printf("We carry %s and the price is $%.2f", matchedProduct.getId(), matchedProduct.getPrice());
    }

    private static HashMap<String, Product> getInventory(){
        HashMap<String, Product> result = new HashMap<String, Product>();

        try{
            BufferedReader reader = new BufferedReader(new FileReader("Inventory.csv"));

            String line;

            //Creating a loop for the file
            while ((line = reader.readLine()) != null){
                Product p = new Product(line);
                //Update the information into the HashMap.
                result.put(p.getName(), p);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

//        result.put(12345, new Product(12345, "Roller Blades", 57.43));
//        result.put(23456, new Product(23456, "Skateboard", 42.99));

        return result;
    }


//    private static HashMap<Integer, Product>loadInventory (){
//        HashMap<Integer, Product> inventory = new HashMap<>();
//        try{
//            BufferedReader reader = new BufferedReader(new FileReader("Inventory.csv"));
//
//            String line;
//
//            while ((line = reader.readLine()) != null){
//
//                Product p = new Product(line);
//
//                //Add new lines
//
//               // inventory.put(new Product(String, line));
//
//
//                // print out the full list
//            //    System.out.printf("%d %s %.2f\n", p.getId(), p.getName(), p.getPrice());
//
//            }
//            reader.close();
//
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//        return inventory;
//
//    }
}
