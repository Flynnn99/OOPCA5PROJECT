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
        try {
            displayMainMenu();        // User Interface - Menu
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Program ending, Goodbye");
    }

    private void displayMainMenu() throws IOException
    {
        ProductDaoInterface IProductDao = new MySqlProductDao();
        PatronDaoInterface IPatronDao = new MySqlPatronDao();
        final String MENU_ITEMS = "\n*** MAIN MENU OF OPTIONS ***\n"
                +"\n** Drinks Menu **\n"
                + "1. View All Drinks\n"
                + "2. View Specific Drink Type\n"
                + "3. Delete Drink By Id\n"
                + "4. Add New Drink\n"
                +" 5. Filter By Type\n"
                +"\n** Patrons Menu **\n"
                + "6. View All Patrons\n"
                + "7. View Specific Patron\n"
                + "\n** Leaving the Bar **\n"
                + "8. Exit\n"
                + "Enter Option [1,8]";


        final int VIEWALLDRINKS = 1;
        final int SEARCHFORADRINK = 2;
        final int DELETEDRINKBYID = 3;
        final int ADDNEWDRINK = 4;
        final int FILTERBYTYPE = 5;
        final int VIEWALLPATRONS = 6;
        final int SEARCHFORPATRON = 7;
        final int EXIT = 8;

        Scanner keyboard = new Scanner(System.in);
        int option = 0;
        do {
            System.out.println("\n" + MENU_ITEMS);
            try {
                String usersInput = keyboard.nextLine();
                option = Integer.parseInt(usersInput);
                switch (option) {
                    case VIEWALLDRINKS:
                        System.out.println("Welcome to the Bar");
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
                        break;
                    case SEARCHFORADRINK:
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
                        break;
                    case DELETEDRINKBYID:
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
                        break;


                    case ADDNEWDRINK:
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

                        break;

                    case FILTERBYTYPE:
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
                        break;

                    case VIEWALLPATRONS:
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

                        break;

                    case SEARCHFORPATRON:
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







}
