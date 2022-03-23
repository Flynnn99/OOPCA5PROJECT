package org.example.BusinessObject;

import org.example.DTO.Patron;
import org.example.Comparators.PatronAgeComparator;
import org.example.DTO.Product;
import org.example.Comparators.SortType;

import java.io.IOException;
import java.util.*;

/**
 * Michael Flynn
 */
public class App {
    public static void main(String[] args) {
        App app = new App();

        app.start();
    }

    public void start() {
        try {
            displayMenu();        // User Interface - Menu
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");
    }


    //ArrayLists
    public void initializeProductsArrayList(List list) {
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

    public void initializePatronsArrayList(List list) {
        list.add(new Patron(1, "Claire", 25));
        list.add(new Patron(2, "Grimes", 32));
        list.add(new Patron(3, "Sammy", 54));
        list.add(new Patron(4, "Domhnall", 50));
        list.add(new Patron(5, "Aine", 31));
        list.add(new Patron(6, "Bernie", 29));
        list.add(new Patron(7, "James", 80));
        list.add(new Patron(8, "Emma", 30));
        list.add(new Patron(9, "Jack", 22));
        list.add(new Patron(10, "Freydis", 23));
    }

    public void displayProductsArrayList(List<Product> pub) {
        System.out.println("============================================================================");
        System.out.println("ID " + "\t\t" + "Beverage Name" + "\t" +
                "Beverage Type" + "\t" + "%" + "\t\t" + "price £" + "\t\t");
        System.out.println("============================================================================");
        System.out.println();

        for (Product items : pub) {
            System.out.println(items.getProduct_Id() + "\t\t" + items.getName() + "  \t\t" + items.getProduct_Type() + "\t\t\t"
                    + items.getPercentage() + "\t\t  " + items.getPrice() + "\n");

        }

    }

    public void displayPatronsArrayList(List<Patron> pub) {
        System.out.println("============================================================================");
        System.out.println("ID " + "\t\t" + "Name" + "\t\t\t" +
                "Age" + "\t");
        System.out.println("============================================================================");
        System.out.println();

        for (Patron items : pub) {
            System.out.println(items.getPatronId() + "\t\t" + items.getPatronName() + "\t  \t\t" + items.getPatronAge() + "\t\t\t");

        }

    }

    //HashMaps
    public void initializeHashMap(Map bill) {
        String name = "Grimes";
        Product product = new Product(1, "Carlsberg", "Beer  ", 4.5, 5);
        bill.put(name, product);

        String name1 = "Claire";
        product = new Product(13, "Smirnoff", "Vodka ", 45, 4.00);
        bill.put(name1, product);

        String name2 = "Sammy";
        product = new Product(5, "Smthwcks", "RedAle", 5, 5);
        bill.put(name2, product);

        String name3 = "Domhnall";
        product = new Product(4, "Guinness", "Stout ", 5, 5.50);
        bill.put(name3, product);

        String name4 = "Aine";
        product = new Product(6, "Magners", "Cider ", 4, 4.50);
        bill.put(name4, product);

        String name5 = "Bernie";
        product = new Product(11, "Macallan", "Scotch", 50, 45);
        bill.put(name5, product);

        String name6 = "James";
        product = new Product(8, "Powers", "Whisky", 45, 4.00);
        bill.put(name6, product);

        String name7 = "Emma";
        product = new Product(2, "Peroni", "Beer  ", 4.5, 5);
        bill.put(name7, product);

        String name8 = "Jack";
        product = new Product(9, "Jack D", "Bourbon", 45, 3.60);
        bill.put(name8, product);

        String name9 = "Freydis";
        product = new Product(12, "SoComfort", "Bourbon", 4, 4.50);
        bill.put(name9, product);


    }

    public void displayHashMap(Map<Patron, Product> bill) {

    }

    //TreeMaps
    public void initializeTreeMap(Map products) {

        products.put("Denmark", new Product(1, "Carlsberg", "Beer  ", 4.5, 5));
        products.put("Naples, Italy", new Product(2, "Peroni", "Beer  ", 4.5, 5));
        products.put("Rome, Italy", new Product(3, "Moretti", "Beer  ", 4.5, 5));
        products.put("St.James Gate Ireland", new Product(4, "Guinness", "Stout ", 5, 5.50));
        products.put("Kilkenny, Ireland", new Product(5, "Smthwcks", "RedAle", 5, 5));
        products.put("Ireland", new Product(6, "Magners", "Cider ", 4, 4.50));
        products.put("Dublin, Ireland", new Product(7, "Jameson", "Whisky", 45, 3.80));
        products.put("Northern Ireland", new Product(8, "Bushmills", "Whisky", 45, 4.00));
        products.put("America", new Product(9, "Jack D", "Bourbon", 45, 3.60));
        products.put("Scotland", new Product(10, "Jhny W", "Scotch", 35, 5));

        System.out.println(products);
        System.out.println();
    }


    //Queue
    public void initializeQueue(Queue queue)
    {
        queue.add(new Patron(1, "Claire", 25));
        queue.add(new Patron(2, "Grimes", 32));
        queue.add(new Patron(3, "Sammy", 54));
        queue.add(new Patron(4, "Domhnall", 50));
        queue.add(new Patron(5, "Aine", 31));

        queue.remove();

        System.out.println(queue);

        queue.add(new Patron(6, "Bernie", 29));
        queue.add(new Patron(7, "James", 80));
        queue.add(new Patron(8, "Emma", 30));
        queue.add(new Patron(9, "Jack", 22));
        queue.add(new Patron(10, "Freydis", 23));

        System.out.println(queue);

        Iterator<Patron> iter = queue.iterator();
        while(iter.hasNext())
        {
            System.out.println(queue.remove());
        }
    }

    public void initializePQueue(Queue queue)
    {
        queue.add(new Patron(1, "Claire", 25));
        queue.add(new Patron(2, "Grimes", 32));
        queue.add(new Patron(3, "Sammy", 54));
        queue.add(new Patron(4, "Domhnall", 50));
        queue.add(new Patron(5, "Aine", 31));
        queue.add(new Patron(6, "Bernie", 29));
        queue.add(new Patron(7, "James", 80));
        queue.add(new Patron(8, "Emma", 30));
        queue.add(new Patron(9, "Jack", 22));
        queue.add(new Patron(10, "Freydis", 23));
    }

    private void displayMenu() throws IOException {
        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. The Bar\n"
                + "2. Receipts\n"
                + "3. Drinks Country of Origin\n"
                + "4. Customer Waiting List\n"
                + "5. Exit\n"
                + "Enter Option [1,5]";


        final int BAR = 1;
        final int RECEIPTS = 2;
        final int COI = 3;
        final int WAITINGLIST = 4;
        final int EXIT = 5;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case BAR:
                        System.out.println("Welcome to the Bar");
                        displayBarMenu();

                        break;
                    case RECEIPTS:
                        displayReceiptsMenu();
                        break;
                    case COI:
                        displayCOIMenu();
                        break;
                    case WAITINGLIST:
                        displayQueueMenu();
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        System.out.println("Thanks for Visiting");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }

    //Menu Display
    private void displayBarMenu() {
        final String MENU_ITEMS = "\n*** BAR OPTIONS ***\n"
                + "1. The Drinks\n"
                + "2. The Patrons\n"
                + "3. Exit\n"
                + "Enter Option [1,3]";

        final int DRINKS = 1;
        final int PATRONS = 2;
        final int EXIT = 3;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {


                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);


                switch (option) {
                    case DRINKS:
                        ArrayList<Product> pub = new ArrayList();
                        initializeProductsArrayList(pub);
                        displayProductsArrayList(pub);
                        break;

                    case PATRONS:
                        ArrayList<Patron> patron = new ArrayList();
                        initializePatronsArrayList(patron);
                        displayPatronsArrayList(patron);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }



    private void displayQueueMenu() {

        final String MENU_ITEMS = "\n*** Queue ***\n"
                + "1. View Queue AGE ORDER \n"


                + "2. EXIT "
                + "Enter Option [1,2]";

        final int VIEWBYAGE = 1;
        final int EXIT = 2;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);






                switch (option)
                {
                    case VIEWBYAGE:
                        Queue<Patron> queue = new PriorityQueue<Patron>( new PatronAgeComparator(SortType.Ascending));
                        initializePQueue(queue);
                        displayQueue(queue);
                        break;


                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);

    }

    private void displayReceiptsMenu()
    {
        final String MENU_ITEMS = "\n*** Receipts ***\n"
                + "1. View Receipt By Name(KEY)\n"
                + "2. View ALL\n"
                + "3. Exit\n"
                + "Enter Option [1,3]";

        final int KEY = 1;
        final int ALL = 2;
        final int EXIT = 3;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);


                switch (option) {
                    case KEY:
                        System.out.println("Recent Purchases if you are not authorised please leave");

                        Map<String, Product> bill = new HashMap();
                        initializeHashMap(bill);

                        System.out.println("please enter your key");
                        String key = keyboard.nextLine();

                        Product product = bill.get(key);
                        System.out.println(key + "  Ordered::  " + product);
                        break;

                    case ALL:
                        System.out.println("all bills");
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }
    private void displayCOIMenu() {
        final String MENU_ITEMS = "\n*** Country of Origin ***\n"
                + "1. View Country of Origin\n"
                + "2. Exit\n"
                + "Enter Option [1,2]";

        final int COI = 1;
        final int EXIT = 2;


        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);


                switch (option)
                {
                    case COI:
                        System.out.println("Recent Purchases if you are not authorised please leave");

                        System.out.println("TreeMaps");
                        System.out.println("Drinks country of Origin");
                        Map<String, Product> products = new TreeMap();
                        initializeTreeMap(products);
                        break;
                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }

    public static void displayQueue(Queue<Patron> patrons)
    {
        for (Patron s: patrons) { System.out.println(s); }
    }

}










