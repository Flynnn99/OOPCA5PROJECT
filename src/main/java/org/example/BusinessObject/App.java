package org.example.BusinessObject;

import org.example.DAO.MySqlPatronDao;
import org.example.DAO.MySqlProductDao;
import org.example.DAO.PatronDaoInterface;
import org.example.DAO.ProductDaoInterface;
import org.example.DTO.Product;
import org.example.DTO.Patron;
import org.example.Exceptions.DaoException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

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
                + "1. View All Drinks\n"
                + "2. Search for a drink based on Type\n"
                + "3. View All Patrons\n"
                + "4. View Patron based on Name\n"
                + "5. Exit\n"
                + "Enter Option [1,5]";


        final int VIEWALLDRINKS = 1;
        final int SEARCHFORADRINK = 2;
        final int VIEWALLPATRONS = 3;
        final int SEARCHFORPATRON = 4;
        final int EXIT = 5;

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
                                for (Product product : products)
                                    System.out.println("Product: " + product.toString());
                            }
                        }catch( DaoException e )
                        {
                            e.printStackTrace();
                        }
                        break;
                    case SEARCHFORADRINK:
                        try
                        {
                            System.out.println("\nCall: findProductByNameAndType()");

                            System.out.println("Enter Product Name");
                            String productName = keyboard.nextLine();
                            System.out.println("Enter Product Type");

                            String productType = keyboard.nextLine();
                            Product product1 = IProductDao.findProductByNameAndType(productName, productType);

                            if( product1 != null ) // null returned if userid and password not valid
                                System.out.println("Product Found: " + product1);
                            else
                                System.out.println("Product Not Found");


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
                                for (Patron patron : patrons)
                                    System.out.println("Patrons: " + patron.toString());
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
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.print("Invalid option - please enter number in range");
            }
        } while (option != EXIT);
    }






}
