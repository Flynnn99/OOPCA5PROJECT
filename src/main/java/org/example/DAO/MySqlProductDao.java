package org.example.DAO;

import org.example.DTO.Product;
import org.example.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MySqlProductDao extends MySqlDao implements ProductDaoInterface
{

    @Override
    public List<Product> findAllProducts() throws DaoException
    {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCTS";
            ps = connection.prepareStatement(query);

            //Using a PreparedStatement to execute SQL...
            resultSet = ps.executeQuery();
            while (resultSet.next())
            {
                int productId = resultSet.getInt("PRODUCT_ID");
                String productName = resultSet.getString("PRODUCT_NAME");
                String productType = resultSet.getString("PRODUCT_TYPE");
                double drinkPercentage = resultSet.getDouble("DRINK_PERCENTAGE");
                double price = resultSet.getDouble("PRICE");
                Product p = new Product(productId, productName, productType, drinkPercentage, price);
                productList.add(p);
            }


        } catch (SQLException e)
        {
            throw new DaoException("findAllProductsResultSet() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (ps != null)
                {
                    ps.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findAllProducts() " + e.getMessage());
            }
        }
        return productList;     // may be empty
    }

    @Override
    public Product findProductByNameAndType(String product_Name, String product_Type) throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCTS WHERE PRODUCT_NAME = ? AND PRODUCT_TYPE = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product_Name);
            preparedStatement.setString(2, product_Type);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next())
            {
                int productId = resultSet.getInt("PRODUCT_ID");
                String productName = resultSet.getString("PRODUCT_NAME");
                String productType = resultSet.getString("PRODUCT_TYPE");
                double drinkPercentage = resultSet.getDouble("DRINK_PERCENTAGE");
                double price = resultSet.getDouble("PRICE");


                product = new Product(productId, productName, productType, drinkPercentage, price);
            }
        } catch (SQLException e)
        {
            throw new DaoException("findUserByNameAndType() " + e.getMessage());
        } finally
        {
            try
            {
                if (resultSet != null)
                {
                    resultSet.close();
                }
                if (preparedStatement != null)
                {
                    preparedStatement.close();
                }
                if (connection != null)
                {
                    freeConnection(connection);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findUserByNameAndType() " + e.getMessage());
            }
        }
        return product;     // reference to User object, or null value
    }


}
