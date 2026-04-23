package com.pluralsight;

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
        inventory.put(6543, new Product(6543,"Bananas",2.49));
        inventory.put(7654, new Product(7654, "Apples", 3.19));
        inventory.put(8765, new Product(8765, "Oranges", 4.29));
        inventory.put(9871, new Product(9871, "Milk", 2.99));
        inventory.put(1982, new Product(1982, "Bread", 1.99));
        inventory.put(2193, new Product(2193, "Eggs", 3.49));
        inventory.put(3204, new Product(3204, "Cheese", 5.79));
        inventory.put(4315, new Product(4315, "Chicken Breast", 7.99));
        inventory.put(5426, new Product(5426, "Rice", 2.49));

        return inventory;

    }
}
