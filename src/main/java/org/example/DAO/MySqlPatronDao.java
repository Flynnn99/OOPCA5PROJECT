package org.example.DAO;



import org.example.DTO.Patron;
import org.example.Exceptions.DaoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;


    public class MySqlPatronDao extends MySqlDao implements PatronDaoInterface
    {

        @Override
        public List<Patron> findAllPatrons() throws DaoException
        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            List<Patron> patronList = new ArrayList<>();

            try
            {
                //Get connection object using the methods in the super class (MySqlDao.java)...
                connection = this.getConnection();

                String query = "SELECT * FROM PATRONS";
                ps = connection.prepareStatement(query);

                //Using a PreparedStatement to execute SQL...
                resultSet = ps.executeQuery();
                while (resultSet.next())
                {
                    int patronId = resultSet.getInt("PATRON_ID");
                    String patronName = resultSet.getString("PATRON_NAME");
                    int patronAge = resultSet.getInt("PATRON_AGE");

                    Patron p = new Patron(patronId, patronName, patronAge);
                    patronList.add(p);
                }


            } catch (SQLException e)
            {
                throw new DaoException("findAllPatronsResultSet() " + e.getMessage());
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
            return patronList;     // may be empty
        }

        @Override
        public Patron findPatronByName(String patron_Name) throws DaoException
        {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            Patron patron = null;
            try
            {
                connection = this.getConnection();

                String query = "SELECT * FROM PATRONS WHERE PATRON_NAME = ? ";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, patron_Name);


                resultSet = preparedStatement.executeQuery();
                if (resultSet.next())
                {
                    int patronId = resultSet.getInt("PATRON_ID");
                    String patronName = resultSet.getString("PATRON_NAME");
                    int patronAge = resultSet.getInt("PATRON_AGE");


                    patron = new Patron(patronId, patronName, patronAge);
                }
            } catch (SQLException e)
            {
                throw new DaoException("findPatronByName() " + e.getMessage());
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
                    throw new DaoException("findPatronByName() " + e.getMessage());
                }
            }
            return patron;     // reference to User object, or null value
        }

        @Override
        public String findAllPatronsJSON() throws DaoException
        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            List<Patron> patronList = new ArrayList<>();
            Gson gsonParser = new Gson();

            try
            {
                //Get connection object using the methods in the super class (MySqlDao.java)...
                connection = this.getConnection();

                String query = "SELECT * FROM PATRONS";
                ps = connection.prepareStatement(query);

                //Using a PreparedStatement to execute SQL...
                resultSet = ps.executeQuery();
                while (resultSet.next())
                {
                    int patronId = resultSet.getInt("PATRON_ID");
                    String patronName = resultSet.getString("PATRON_NAME");
                    int patronAge = resultSet.getInt("PATRON_AGE");

                    Patron p = new Patron(patronId, patronName, patronAge);
                    patronList.add(p);
                }


            } catch (SQLException e)
            {
                throw new DaoException("findAllPatronsResultSet() " + e.getMessage());
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
            String patrons = gsonParser.toJson(patronList);
            return patrons;
        }

        @Override
        public String findAllPatronsByAge(int age) throws DaoException
        {
            Connection connection = null;
            PreparedStatement ps = null;
            ResultSet resultSet = null;
            List<Patron> patronList = new ArrayList<>();
            Gson gsonParser = new Gson();

            try
            {
                //Get connection object using the methods in the super class (MySqlDao.java)...
                connection = this.getConnection();

                String query = "SELECT * FROM PATRONS WHERE PATRON_AGE = ? ";
                ps = connection.prepareStatement(query);
                ps.setInt(1, age);

                //Using a PreparedStatement to execute SQL...
                resultSet = ps.executeQuery();
                while (resultSet.next())
                {
                    int patronId = resultSet.getInt("PATRON_ID");
                    String patronName = resultSet.getString("PATRON_NAME");
                    int patronAge = resultSet.getInt("PATRON_AGE");

                    Patron p = new Patron(patronId, patronName, patronAge);
                    patronList.add(p);
                }


            } catch (SQLException e)
            {
                throw new DaoException("findAllPatronsResultSet() " + e.getMessage());
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

            String patrons = gsonParser.toJson(patronList);
            return patrons;
        }
    }


