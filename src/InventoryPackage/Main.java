package InventoryPackage;



import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<products> productList = dbHandler.getDataFromDB("steve@gmail.com");

            // Print all products
            for (products product : productList) {
                System.out.println(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
