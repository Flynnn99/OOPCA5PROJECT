package org.example.BusinessObject;

import org.example.Comparators.PatronAgeComparator;
import org.example.Comparators.ProductsNameComparator;
import org.example.Comparators.SortType;
import org.example.DAO.MySqlPatronDao;
import org.example.DAO.MySqlProductDao;
import org.example.DAO.PatronDaoInterface;
import org.example.DAO.ProductDaoInterface;
import org.example.DTO.Product;
import org.example.DTO.Patron;
import org.example.Exceptions.DaoException;

import java.io.IOException;
import java.util.*;

public class App
{

    public static void main(String[] args)
    {
        App app = new App();
        app.start();

    }

    public void start()
    {
        try
        {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");
    }



    //Menus for The App
    private void displayMainMenu() throws IOException
    {

        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"

                + "1. The Bar\n"
                + "2. The Patrons\n"
                + "3. Part one\n"
                + "\n** Leaving the Bar **\n"
                + "4. Exit\n"
                + "Enter Option [1,4]";


        final int DISPLAYBARMENU = 1;
        final int DISPLAYPATRONMENU = 2;
        final int PARTONE = 3;
        final int EXIT = 4;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {
                    case DISPLAYBARMENU:
                        displayBarMenu();
                        break;

                    case DISPLAYPATRONMENU:
                        displayPatronsMenu();
                        break;

                    case PARTONE:
                        displayPartOne();

                        break;

                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        System.out.println("Thanks for Visiting");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }

    private void displayBarMenu() throws IOException
    {
        final String MENU_ITEMS = "\n***Drinks Menu ***\n"

                + "1. View All Drinks\n"
                + "2. View Specific Drink Type\n"
                + "3. Delete Drink By Id\n"
                + "4. Add New Drink\n"
                + "5. Filter By Type\n"
                + "6. Exit\n"
                + "Enter Option [1,6]";

        final int VIEWALLDRINKS = 1;
        final int SEARCHFORADRINK = 2;
        final int DELETEDRINKBYID = 3;
        final int ADDNEWDRINK = 4;
        final int FILTERBYTYPE = 5;
        final int EXIT = 6;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case VIEWALLDRINKS:
                        displayAllProducts();

                        break;
                    case SEARCHFORADRINK:
                        displayFindProductsBy();
                        break;
                    case DELETEDRINKBYID:

                        deleteDrinkById();
                        break;


                    case ADDNEWDRINK:
                        displayAddNewProduct();

                        break;

                    case FILTERBYTYPE:

                        displayFindProductUsingFilter();
                        break;

                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }

    private void displayPatronsMenu() throws IOException
    {
        final String MENU_ITEMS = "\n*** Patrons Section***\n"

                + "1. View All Patrons\n"
                + "2. View Specific Patron\n"
                + "3. View Patron as a JSON String\n"
                + "4. View Patrons by Age as a JSON String\n"
                + "\n** Leaving the Patrons Section **\n"
                + "5. Exit\n"
                + "Enter Option [1,5]";

        final int VIEWALLPATRONS = 1;
        final int SEARCHFORPATRON = 2;
        final int FINDALLPATRONSJSON = 3;
        final int FINDPATRONBYAGEJSON = 4;
        final int EXIT = 5;



        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option)
                {


                    case VIEWALLPATRONS:

                        displayAllPatrons();
                        break;

                    case SEARCHFORPATRON:

                        displayFindPatronBy();
                        break;

                    case FINDALLPATRONSJSON:

                        displayPatronsUsingJson();
                        break;
                    case FINDPATRONBYAGEJSON:
                        displayPatronsAgeUsingJson();

                        break;

                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }


    //Functions for the App
    //Requirements 7-13

    //Requirement 7: FindAllProducts
    public void displayAllProducts()
    {
        ProductDaoInterface IProductDao = new MySqlProductDao();
        System.out.println("\nCall findAllProducts()");
        try
        {
            List<Product> products = IProductDao.findAllProducts();     // call a method in the DAO

            if (products.isEmpty())
                System.out.println("There are no Products");
            else
            {

                System.out.println("============================================================================");
                System.out.println("ID " + "\t\t" + "Beverage Name" + "\t" +
                        "Beverage Type" + "\t" + "%" + "\t\t" + "price £" + "\t\t");
                System.out.println("============================================================================");
                System.out.println();

                for (Product product : products) {
                    System.out.println(product.getProduct_Id() + "\t\t" + product.getName() + "  \t\t" + product.getProduct_Type() + "\t\t\t"
                            + product.getPercentage() + "\t\t  " + product.getPrice() + "\n");

                }
            }
        }catch( DaoException e )
        {
            e.printStackTrace();
        }
    }

    //Requirement 7.1 FindAllPatrons
    public void displayAllPatrons()
    {
        PatronDaoInterface IPatronDao = new MySqlPatronDao();
        System.out.println("\nCall findAllPatrons()");
        try
        {
            List<Patron> patrons = IPatronDao.findAllPatrons();     // call a method in the DAO

            if (patrons.isEmpty())
                System.out.println("There are no Patrons");
            else
            {
                System.out.println("============================================================================");
                System.out.println("ID" + "\t\t" + "Name" + "\t\t\t" +
                        "Age" + "\t");
                System.out.println("============================================================================");
                System.out.println();

                for (Patron patron : patrons) {
                    System.out.println(patron.getPatronId() + "\t\t" + patron.getPatronName() + "\t  \t\t" + patron.getPatronAge() + "\t\t\t");

                }
            }
        }catch( DaoException e )
        {
            e.printStackTrace();
        }
    }

    //Requirement 8 findProductByTypeAndPrice
    public void displayFindProductsBy()
    {
        ProductDaoInterface IProductDao = new MySqlProductDao();
        Scanner keyboard = new Scanner(System.in);

        try
        {
            System.out.println("\nCall: findProductByTypeAndPrice()");

            System.out.println("Enter Product Type");
            String productType = keyboard.nextLine();
            System.out.println("Enter Product Price");
            double price = keyboard.nextDouble();
            Product product1 = IProductDao.findProductByTypeAndPrice(productType, price);

            if( product1 != null ) // null returned if userid and password not valid
                System.out.println("Product Found: " + product1);
            else
                System.out.println("Product Not Found");


        }catch( DaoException e )
        {
            e.printStackTrace();
        }
    }

    //Requirement 8.1 findPatronByName
    public void displayFindPatronBy()
    {
        PatronDaoInterface IPatronDao = new MySqlPatronDao();
        Scanner keyboard = new Scanner(System.in);


        try
        {
            System.out.println("\nCall: findPatronByName()");

            System.out.println("Enter Patron Name");
            String patronName = keyboard.nextLine();

            Patron patron1 = IPatronDao.findPatronByName(patronName);

            if( patron1 != null ) // null returned if userid and password not valid
                System.out.println("Patron Found: " + patron1);
            else
                System.out.println("Patron Not Found");


        }catch( DaoException e )
        {
            e.printStackTrace();
        }
    }

    //Requirement 9 deleteProduct
    public void deleteDrinkById()
    {

        ProductDaoInterface IProductDao = new MySqlProductDao();
        Scanner keyboard = new Scanner(System.in);

        try
        {

            System.out.println("\nCall: DeleteBy()");

            System.out.println("Enter Product Id");
            int productId = keyboard.nextInt();
            System.out.println("");


            Product product1 = IProductDao.deleteBy(productId);
            System.out.println("product Deleted ");
        }catch( DaoException e )
        {
            e.printStackTrace();
        }
    }

    //Requirement 10 addNewEntity
    public void displayAddNewProduct()
    {
        ProductDaoInterface IProductDao = new MySqlProductDao();
        Scanner keyboard = new Scanner(System.in);

        try
        {
            System.out.println("\nCall: AddNewProduct()");


            System.out.println("\nEnter Product Name");
            String addProductName = keyboard.nextLine();

            System.out.println("Enter Product Type");
            String addProductType = keyboard.nextLine();

            System.out.println("Enter Drink Percentage");
            Double addProductPercentage = keyboard.nextDouble();

            System.out.println("Enter Product Price");
            Double addProductPrice = keyboard.nextDouble();

            System.out.println("Add Product ID");
            int addProductID = keyboard.nextInt();


            IProductDao.addNewProduct(addProductID, addProductName, addProductType,addProductPercentage,addProductPrice);

        }catch( DaoException e )
        {
            e.printStackTrace();
        }
    }

    //Requirement 11 findProductUsingFilter
    public void displayFindProductUsingFilter()
    {
        ProductDaoInterface IProductDao = new MySqlProductDao();
        Scanner keyboard = new Scanner(System.in);

        System.out.println("\nCall findProductsByType()");
        try
        {
            System.out.println("Enter Product Type");
            String product_type = keyboard.nextLine();

            List<Product> products = IProductDao.findProductByType(product_type);     // call a method in the DAO
            ProductsNameComparator nameComparator = new ProductsNameComparator();
            Collections.sort(products, nameComparator);



            if (products.isEmpty())
                System.out.println("There are no Products");
            else
            {

                System.out.println("============================================================================");
                System.out.println("ID " + "\t\t" + "Beverage Name" + "\t" +
                        "Beverage Type" + "\t" + "%" + "\t\t" + "price £" + "\t\t");
                System.out.println("============================================================================");
                System.out.println();

                for (Product product : products) {
                    System.out.println(product.getProduct_Id() + "\t\t" + product.getName() + "  \t\t" + product.getProduct_Type() + "\t\t\t"
                            + product.getPercentage() + "\t\t  " + product.getPrice() + "\n");

                }
            }
        }catch( DaoException e )
        {
            e.printStackTrace();
        }

    }

    //Requirement 12 findAllPatronsUsingJson
    public void displayPatronsUsingJson()
    {
        PatronDaoInterface IPatronDao = new MySqlPatronDao();

        try
        {
            System.out.println("\n FindAllPatronsJson");
            String patronsJsonString = IPatronDao.findAllPatronsJSON();

            if(patronsJsonString.equals("null"))
            {
                System.out.println("No Patrons");

            }
            else
            {
                System.out.println(patronsJsonString);
            }
        }catch(DaoException e)
        {
            e.printStackTrace();
        }
    }

    //Requirement 13 findPatronsByAgeJson
    public void displayPatronsAgeUsingJson()
    {
        PatronDaoInterface IPatronDao = new MySqlPatronDao();
        Scanner keyboard = new Scanner(System.in);

        try
        {
            System.out.println("\n FindAllPatronsJson");
            System.out.println("Enter Age of Patrons");
            int age = keyboard.nextInt();

            String patronsJsonString = IPatronDao.findAllPatronsByAge(age);

            if(patronsJsonString.equals("null"))
            {
                System.out.println("No Patrons");

            }
            else
            {
                System.out.println(patronsJsonString);
            }
        }catch(DaoException e)
        {
            e.printStackTrace();
        }
    }


    //Part One Functions and Reqs
    private void displayPartOne() throws IOException
    {
        final String MENU_ITEMS = "\n*** PART ONE MAIN MENU OF OPTIONS ***\n"
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
                switch (option)
                {


                    case BAR:
                        displayP1BarMenu();
                        break;

                    case RECEIPTS:

                        displayReceiptsMenu();
                        break;

                    case COI:

                        displayCOIMenu();
                        break;
                    case WAITINGLIST:
                        displayQueueMenu();

                        break;

                    case EXIT:
                        System.out.println("Exit Menu option chosen");
                        break;
                    default:
                        System.out.print("Invalid option - please enter number in range");
                        break;

                }
            } catch (InputMismatchException | NumberFormatException e)
            {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }

    //Menu Display

    private void displayP1BarMenu() {
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

}
