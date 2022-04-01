package org.example.DAO;

import org.example.DTO.Product;
import org.example.Exceptions.DaoException;

import java.sql.*;
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
    public Product findProductByTypeAndPrice(String product_Type, double prices) throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try
        {
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCTS WHERE PRODUCT_TYPE = ? AND PRICE = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product_Type);
            preparedStatement.setDouble(2, prices);

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

    @Override
    public Product deleteBy(int id) throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try
        {
            connection = this.getConnection();

            String query = "DELETE FROM PRODUCTS WHERE PRODUCT_ID = ? ";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            Statement statement = connection.createStatement();


            resultSet = statement.executeQuery("select * from PRODUCTS");

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
            throw new DaoException("Delete " + e.getMessage());
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
                throw new DaoException("deleteBy() " + e.getMessage());
            }
        }
        return product;     // reference to User object, or null value
    }

    @Override
    public Product addNewProduct(int product_id, String product_name, String product_type, double product_percentage, double product_price ) throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Product product = null;
        try
        {
            connection = this.getConnection();

            String query = "INSERT INTO PRODUCTS VALUES (?,?,?,?,?) ";
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setInt(1, product_id);
            preparedStatement.setString(2, product_name);
            preparedStatement.setString(3, product_type);
            preparedStatement.setDouble(4, product_percentage);
            preparedStatement.setDouble(5, product_price);

            preparedStatement.executeUpdate();

            Statement statement = connection.createStatement();


            resultSet = statement.executeQuery("select * from PRODUCTS");

            if (resultSet.next())
            {
                int productId = resultSet.getInt("PRODUCT_ID");
                String productName = resultSet.getString("PRODUCT_NAME");
                String productType = resultSet.getString("PRODUCT_TYPE");
                double drinkPercentage = resultSet.getDouble("DRINK_PERCENTAGE");
                double price = resultSet.getDouble("PRICE");

                product = new Product(productId, productName, productType, drinkPercentage, price);


            }

        }catch (SQLException e)
        {
            throw new DaoException("Add " + e.getMessage());
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
                throw new DaoException("AddNew() " + e.getMessage());
            }
        }

        return product;
    }

    @Override
    public List<Product>findProductByType(String product_type) throws DaoException
    {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();

        try
        {
            //Get connection object using the methods in the super class (MySqlDao.java)...
            connection = this.getConnection();

            String query = "SELECT * FROM PRODUCTS WHERE PRODUCT_TYPE = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, product_type);

            //Using a PreparedStatement to execute SQL...
            resultSet = preparedStatement.executeQuery();
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
                throw new DaoException("findAllProducts() " + e.getMessage());
            }
        }
        return productList;     // may be empty
    }



}
