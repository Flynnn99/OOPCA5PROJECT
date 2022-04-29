package org.example.Multithreads;

import com.google.gson.Gson;
import org.example.DAO.MySqlProductDao;
import org.example.DAO.ProductDaoInterface;
import org.example.DTO.Product;
import org.example.Exceptions.DaoException;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Client
{
    public static void main(String[] args)
    {
        Client client = new Client();
        client.start();
    }

    public void start()
    {
        Scanner in = new Scanner(System.in);
        Gson gson = new Gson();
        try {
            Socket socket = new Socket("localhost", 8080);  // connect to server socket
            System.out.println("Client: Port# of this client : " + socket.getLocalPort());
            System.out.println("Client: Port# of Server :" + socket.getPort() );

            ProductDaoInterface IProductDao = new MySqlProductDao();

            System.out.println("Client message: The Client is running and has connected to the server");

            displayMenu();
            String command = in.nextLine();

            OutputStream os = socket.getOutputStream();
            PrintWriter socketWriter = new PrintWriter(os, true);   // true => auto flush buffers

            socketWriter.println(command);

            Scanner socketReader = new Scanner(socket.getInputStream());  // wait for, and retrieve the reply

            boolean contLooping = true;
            while(contLooping ==true)
            {

                if (command.startsWith("Time"))   //we expect the server to return a time
                {
                    String timeString = socketReader.nextLine();
                    System.out.println("Client message: Response from server Time: " + timeString);
                }
                else if(command.startsWith("displayById"))
                {
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");

                }
                else if(command.startsWith("findAllProducts"))
                {
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");

                }
                else if(command.startsWith("add"))
                {
                    System.out.println("Enter Product Name");
                    String productName = in.nextLine();

                    System.out.println("Enter Product Type");
                    String productType = in.nextLine();

                    System.out.println("Enter Product Percentage");
                    Double productPercentage = in.nextDouble();

                    System.out.println("Enter Product Price ");
                    Double productPrice = in.nextDouble();


                    Product product = new Product(productName, productType, productPercentage, productPrice);
                    String productJson = gson.toJson(product);
                    System.out.println(product);
                    command = command + " " + productJson;


                    socketWriter.println(command);



                    socketWriter.println(command);
                    String input= socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");


                }
                else if(command.startsWith("deleteBy"))
                {
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }
                else if(command.startsWith("summary"))
                {
                    //int amount = socketReader.nextInt();
                    double price = socketReader.nextDouble();


                    //System.out.println("Amount of Drinks for Sale: " + amount);
                    System.out.printf("Average Price of Drinks  £%6.2f ", price );
                    System.out.println();


                }

                else                            // the user has entered the Echo command or an invalid command
                {
                    String input = socketReader.nextLine();
                    System.out.println("Client message: Response from server: \"" + input + "\"");
                }

                System.out.println("Please enter next command");
                command = in.nextLine();
                socketWriter.println(command);

            }

            socketWriter.close();
            socketReader.close();
            socket.close();

        } catch (IOException |InputMismatchException e)
        {
            System.out.println("Client message: IOException: "+e);
        }
    }

    public void displayMenu()
    {
        System.out.println("\n*** MAIN MENU OF OPTIONS ***\n"
                + "1. Display Entity By ID -- displayById\n"
                + "2. Display All Entities -- findAllProducts\n"
                + "3. Add An Entities --- add\n"
                + "4. Delete An Entity By ID --- deleteBy\n"
                + "5. Summary --- summary\n"
                + "6. Exit\n");

        System.out.println("Please enter a command:  (\"Time\" to get time\n>");
    }
}