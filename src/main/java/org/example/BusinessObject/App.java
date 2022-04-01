package org.example.BusinessObject;

import org.example.Comparators.ProductsNameComparator;
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
                + "\n** Leaving the Bar **\n"
                + "3. Exit\n"
                + "Enter Option [1,3]";


        final int DISPLAYBARMENU = 1;
        final int DISPLAYPATRONMENU = 2;
        final int EXIT = 3;

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


            Product product1 = IProductDao.addNewProduct(addProductID, addProductName, addProductType,addProductPercentage,addProductPrice);

            if( product1 != null ) // null returned if userid and password not valid
                System.out.println("Product Found: " + product1);
            else
                System.out.println("Product Not Found");


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


}
