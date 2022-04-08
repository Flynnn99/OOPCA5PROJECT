package org.example.DAO;

/** OOP Feb 2022
 * UserDaoInterface
 *
 * Declares the methods that all UserDAO types must implement,
 * be they MySql User DAOs or Oracle User DAOs etc...
 *
 * Classes from the Business Layer (users of this DAO interface)
 * should use reference variables of this interface type to avoid
 * dependencies on the underlying concrete classes (e.g. MySqlUserDao).
 *
 * More sophisticated implementations will use a factory
 * method to instantiate the appropriate DAO concrete classes
 * by reading database configuration information from a
 * configuration file (that can be changed without altering source code)
 *
 * Interfaces are also useful when testing, as concrete classes
 * can be replaced by mock DAO objects.
 */

import org.example.DTO.Product;
import org.example.Exceptions.DaoException;

import java.util.List;

public interface ProductDaoInterface
{
    public List<Product> findAllProducts() throws DaoException;
    public Product findProductByTypeAndPrice(String productType, double price) throws DaoException;
    public Product deleteBy(int id) throws DaoException;
    public Product addNewProduct(int product_id, String product_name, String product_type, double percentage, double price ) throws DaoException;
    public List<Product>findProductByType(String productType) throws DaoException;
    public Product displayByID(int id) throws DaoException;
    public String findAllProductsJSON() throws DaoException;

}

