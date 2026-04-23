package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class StoreApp {
    public static HashMap<Integer, Product> inventory = new HashMap<Integer, Product>();
    public static void main(String[] args){

        //loading in the method
        loadInventory();

        Scanner scanner = new Scanner(System.in);
        System.out.print("What item # are you interested in? ");
        int id = scanner.nextInt();

        //searches through the products
        Product matchedProduct = inventory.get(id);
        if (matchedProduct == null){
            System.out.println("We don't carry that product");
            return;
        }
        System.out.printf("We carry %s and the price is $%.2f", matchedProduct.getName(), matchedProduct.getPrice());
    }

    private static HashMap<Integer, Product>loadInventory (){
        HashMap<Integer, Product>inventory = new HashMap<>();
        try{
            BufferedReader reader = new BufferedReader(new FileReader("Inventory.csv"));

            String line;
            while ((line = reader.readLine())!= null){

                Product p = new Product(line);

                //Add to the global inventory
                inventory.put(p.getId(), p);


                // print out the full list
                System.out.printf("%d %s %.2f\n", p.getId(), p.getName(), p.getPrice());

            }
            reader.close();


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inventory;

    }
}
