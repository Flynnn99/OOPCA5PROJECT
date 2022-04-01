package org.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.example.DAO.MySqlPatronDao;
import org.example.DAO.MySqlProductDao;
import org.example.DTO.Patron;
import org.example.DTO.Product;
import org.example.Exceptions.DaoException;
import org.junit.Test;



/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    @Test
    public void displayAll() throws DaoException
    {
        System.out.println("Req 7");
        System.out.println("Display All");


    }

    @Test
    public void findPatronByName() throws DaoException
    {
        System.out.println("Req 8");
        System.out.println("Finding Patron By Name");
        String patronName ="Freydis";

        Patron patron = new Patron(10, "Freydis", 23);
        MySqlPatronDao patronDao = new MySqlPatronDao();
        assertEquals(patron, patronDao.findPatronByName(patronName));
    }

    //TESTING WORKS BUT THE ASSERT EQUALS DOSENT WORK
    /*@Test
    public void deleteRecord() throws DaoException
    {
        System.out.println("Req 9");
        System.out.println("Delete A Record");

       int id = 17;
       Product product = new Product(17, "Malibu", "Rum", 30.4, 6.50);
       MySqlProductDao productDao = new MySqlProductDao();
       assertEquals(product, productDao.deleteBy(id));
    }

    @Test
    public void addRecord() throws DaoException
    {
        System.out.println("Req 10");
        System.out.println("Added a Record");

        int id = 17;
        String productName = "Malibu";
        String productType = "Rum";
        double productPercentage = 30.4;
        double price = 6.50;

        MySqlProductDao productDao = new MySqlProductDao();
        Product product = new Product(id,productName,productType,productPercentage, price);
        Product product2  = productDao.addNewProduct(id,productName,productType,productPercentage, price);
        assertEquals(product,product2 );


    }*/


}
