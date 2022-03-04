package org.example;

import java.util.*;

/**
 * Michael Flynn
 *
 */
public class App {
    public static void main(String[] args)
    {
        App app = new App();

        app.start();
    }

    public void start()
    {
        System.out.println("Nikes short for Nichael!");
        System.out.println("Nichaels Pub est 1999");
        System.out.println("\n");

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello and Welcome to Nichaels Pub");
        System.out.println();
        System.out.println("Menu Options");
        System.out.println("1, Select One of you wish to view our products\n");
        System.out.println("2, Select Two (is for bills but only authorised personnel get to view that right...)\n");
        System.out.println("3, Select Three to view the country of Origin for our products\n");

        int option;


        do {

            System.out.println("Please select what you like");
            String usersInput = keyboard.nextLine();
            option = Integer.parseInt(usersInput);

            if (option == 1) {
                System.out.println("Our Products");
                ArrayList<Product> pub = new ArrayList();
                ArrayList<Patron> patron = new ArrayList();

                initializeProductsArrayList(pub);
                initializePatronsArrayList(patron);
                displayProductsArrayList(pub);

            } else if (option == 2) {
                System.out.println("Recent Purchases if you are not authorised please leave");

                Map<String, Product> bill = new HashMap();
                initializeHashMap(bill);

                System.out.println("please enter your key");
                String key = keyboard.nextLine();

                Product product = bill.get(key);
                System.out.println(key + "  Ordered::  " + product);

            } else if (option == 3) {
                System.out.println("TreeMaps");
                System.out.println("Drinks country of Origin");
                Map<String, Product> products = new TreeMap();
                initializeTreeMap(products);
            } else {
                System.out.println("Au Revoir");
            }
        }while(option!=4);

    }

    //ArrayLists
    public void initializeProductsArrayList(List list)
    {
        list.add(new Product(1, "Carlsberg", "Beer  ", 4.5, 5));
        list.add(new Product(2, "Peroni", "Beer  ", 4.5, 5));
        list.add(new Product(3, "Moretti", "Beer  ", 4.5, 5));
        list.add(new Product(4, "Guinness", "Stout ", 5, 5.50));
        list.add(new Product(5, "Smthwcks", "RedAle", 5, 5));
        list.add(new Product(6, "Magners", "Cider ", 4, 4.50));

        list.add(new Product(7, "Jameson", "Whisky", 45, 3.80));
        list.add(new Product(8, "Powers", "Whisky", 45, 4.00));
        list.add(new Product(9, "Jack D", "Bourbon", 45, 3.60));
        list.add(new Product(10, "Jhny W", "Scotch", 35, 5));
        list.add(new Product(11, "Macallan", "Scotch", 50, 45));
        list.add(new Product(12, "SoComfort", "Bourbon", 4, 4.50));

        list.add(new Product(13, "Smirnoff", "Vodka ", 45, 4.00));
        list.add(new Product(14, "GreyGoose", "Vodka ", 45, 5.50));

    }

    public void initializePatronsArrayList(List list)
    {
        list.add(new Patron(1, "Claire",25));
        list.add(new Patron(2, "Grimes",32));
        list.add(new Patron(3, "Sammy", 54));
        list.add(new Patron(4, "Domhnall",50));
        list.add(new Patron(5, "Aine", 31));
        list.add(new Patron(6, "Bernie", 29));
        list.add(new Patron(7, "James", 80));
        list.add(new Patron(8, "Emma", 30));
        list.add(new Patron(9, "Jack", 22));
        list.add(new Patron(10, "Freydis", 23));
    }

    public void displayProductsArrayList(List<Product> pub)
    {
        System.out.println("============================================================================");
        System.out.println("ID " +"\t\t" + "Beverage Name" + "\t" +
                "Beverage Type" + "\t" + "%" + "\t\t" + "price £" + "\t\t");
        System.out.println("============================================================================");
        System.out.println();

        for(Product items : pub)
        {
            System.out.println(items.getProduct_Id() + "\t\t" + items.getName() + "  \t\t" + items.getProduct_Type() + "\t\t\t"
                    + items.getPercentage() + "\t\t  " + items.getPrice() + "\n");

        }

    }

    //HashMaps
    public void initializeHashMap(Map bill)
    {
        String name =  "Grimes";
        Product product =  new Product(1, "Carlsberg", "Beer  ", 4.5, 5);
        bill.put(name,product);

        String name1 = "Claire";
        product = new Product(13, "Smirnoff", "Vodka ", 45, 4.00);
        bill.put(name1,product);

        String name2 = "Sammy";
        product = new Product(5, "Smthwcks", "RedAle", 5, 5);
        bill.put(name2,product);

        String name3 = "Domhnall";
        product =new Product(4, "Guinness", "Stout ", 5, 5.50);
        bill.put(name3,product);

        String name4 = "Aine";
        product = new Product(6, "Magners", "Cider ", 4, 4.50);
        bill.put(name4,product);

        String name5 = "Bernie";
        product = new Product(11, "Macallan", "Scotch", 50, 45);
        bill.put(name5,product);

        String name6 = "James";
        product = new Product(8, "Powers", "Whisky", 45, 4.00);
        bill.put(name6, product);

        String name7 = "Emma";
        product = new Product(2, "Peroni", "Beer  ", 4.5, 5) ;
        bill.put(name7, product);

        String name8 = "Jack";
        product = new Product(9, "Jack D", "Bourbon", 45, 3.60);
        bill.put(name8,product);

        String name9 = "Freydis";
        product = new Product(12, "SoComfort", "Bourbon", 4, 4.50);
        bill.put(name9,product);


    }

    public void displayHashMap(Map<Patron, Product> bill)
    {

    }

    //TreeMaps
    public void initializeTreeMap(Map products)
    {

        products.put("Denmark",new Product(1, "Carlsberg", "Beer  ", 4.5, 5));
        products.put("Naples, Italy",new Product(2, "Peroni", "Beer  ", 4.5, 5));
        products.put("Rome, Italy",new Product(3, "Moretti", "Beer  ", 4.5, 5));
        products.put("St.James Gate Ireland", new Product(4, "Guinness", "Stout ", 5, 5.50));
        products.put("Kilkenny, Ireland", new Product(5, "Smthwcks", "RedAle", 5, 5));
        products.put("Ireland",new Product(6, "Magners", "Cider ", 4, 4.50));
        products.put("Dublin, Ireland",new Product(7, "Jameson", "Whisky", 45, 3.80));
        products.put("Northern Ireland",new Product(8, "Bushmills", "Whisky", 45, 4.00));
        products.put("America",new Product(9, "Jack D", "Bourbon", 45, 3.60));
        products.put("Scotland",new Product(10, "Jhny W", "Scotch", 35, 5));

        System.out.println(products);
        System.out.println();
    }
}




