package org.example.Multithreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.List;

import com.google.gson.Gson;
import org.example.DAO.MySqlProductDao;

import org.example.DAO.ProductDaoInterface;
import org.example.DTO.Product;
import org.example.Exceptions.DaoException;


public class Server
{
    public static void main(String[] args)
    {
        Server server = new Server();
        ProductDaoInterface IProductDao = new MySqlProductDao();

        server.start();
    }

    public void start()
    {
        try
        {
            ProductDaoInterface IProductDao = new MySqlProductDao();

            ServerSocket ss = new ServerSocket(8080);  // set up ServerSocket to listen for connections on port 8080

            System.out.println("Server: Server started. Listening for connections on port 8080...");

            int clientNumber = 0;  // a number for clients that the server allocates as clients connect

            while (true)    // loop continuously to accept new client connections
            {
                Socket socket = ss.accept();    // listen (and wait) for a connection, accept the connection,
                // and open a new socket to communicate with the client
                clientNumber++;

                System.out.println("Server: Client " + clientNumber + " has connected.");

                System.out.println("Server: Port# of remote client: " + socket.getPort());
                System.out.println("Server: Port# of this server: " + socket.getLocalPort());

                Thread t = new Thread(new ClientHandler(socket, clientNumber, IProductDao)); // create a new ClientHandler for the client,
                t.start();                                                  // and run it in its own thread

                System.out.println("Server: ClientHandler started in thread for client " + clientNumber + ". ");
                System.out.println("Server: Listening for further connections...");
            }
        } catch (IOException e)
        {
            System.out.println("Server: IOException: " + e);
        }
        System.out.println("Server: Server exiting, Goodbye!");
    }

    public class ClientHandler implements Runnable   // each ClientHandler communicates with one Client
    {
        BufferedReader socketReader;
        PrintWriter socketWriter;
        Socket socket;
        ProductDaoInterface daoProducts;
        int clientNumber;

        public ClientHandler(Socket clientSocket, int clientNumber, ProductDaoInterface daoProducts)
        {
            try
            {
                InputStreamReader isReader = new InputStreamReader(clientSocket.getInputStream());
                this.socketReader = new BufferedReader(isReader);

                OutputStream os = clientSocket.getOutputStream();
                this.socketWriter = new PrintWriter(os, true); // true => auto flush socket buffer

                this.clientNumber = clientNumber;  // ID number that we are assigning to this client

                this.socket = clientSocket;  // store socket ref for closing

                this.daoProducts = daoProducts;

            } catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }

        @Override
        public void run()
        {
            String message;
            try
            {
                ProductDaoInterface IProductDao = new MySqlProductDao();
                Gson gson = new Gson();
                while ((message = socketReader.readLine()) != null)
                {
                    System.out.println("Server: (ClientHandler): Read command from client " + clientNumber + ": " + message);

                    if (message.startsWith("Time"))
                    {
                        LocalTime time =  LocalTime.now();
                        socketWriter.println(time);  // sends current time to client
                    }
                    else if(message.startsWith("displayById"))
                    {

                        String[] tokens = message.split(" ");
                        int num = Integer.parseInt(tokens[1]);
                        String product = IProductDao.findProductIdByJSON(num);
                        socketWriter.println(product);
                    }
                    else if (message.startsWith("findAllProducts"))
                    {

                        String productsJsonString = IProductDao.findAllProductsJSON();
                        socketWriter.println(productsJsonString);


                         // send message to client
                    }
                    else if(message.startsWith("add"))
                    {
                        message = socketReader.readLine();
                        String tokens = message.substring(4);
                        System.out.println(message);

                        Product product = gson.fromJson(tokens, Product.class);
                        System.out.println("product" + product);
                        IProductDao.addNewProduct(product.getName(), product.getProduct_Type(), product.getPercentage(), product.getPrice());

                    }
                    else if(message.startsWith("deleteBy"))
                    {
                        String[] tokens = message.split(" ");
                        int num = Integer.parseInt(tokens[1]);
                        Product product = IProductDao.deleteBy(num);
                        socketWriter.println("deleted");

                    }
                    else if(message.startsWith("summary"))
                    {

                        double totalPrice =0;
                       // int amountOfDrinks = 0;
                        double avgPrice = 0;
                        int size = IProductDao.findAllProducts().size();

                        for(int j = 0; j<size; j++)
                        {
                            totalPrice += IProductDao.findAllProducts().get(j).getPrice();
                            //amountOfDrinks ++;
                        }

                        avgPrice = totalPrice/size;

                        //socketWriter.print(size);
                        socketWriter.println(avgPrice);






                    }
                    else
                    {
                        socketWriter.println("I'm sorry I don't understand :(");
                    }
                }

                socket.close();

            } catch (IOException | DaoException ex)
            {
                ex.printStackTrace();
            }
            System.out.println("Server: (ClientHandler): Handler for Client " + clientNumber + " is terminating .....");
        }
    }

}
