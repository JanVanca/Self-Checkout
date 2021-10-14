package database.service;

import database.entity.Product;
import database.entity.Products;
import database.exception.ProductException;
import database.service.impl.Login;

import java.util.List;


public interface ProductService {
    /**
     * Connects to the database and returns a list of products according to the entered product name.
     *
     * @param name  Entered product name which should be compared with the products in the database.
     * @param login Current connection to the database.
     * @return If entered product is in database returns List of product.
     * @throws ProductException Own product exception.
     */
    List<Products> getProduct(String name, Login login) throws ProductException;

    /**
     * Connects to database and returns all list of products in database.
     *
     * @return List of products which are in database.
     * @throws ProductException Own product exception.
     */
    List<Products> getAllProducts(Login login) throws ProductException;

    /**
     * Adds product to database.
     *
     * @param login   Current connection to the database.
     * @param product Product which should be added to the database.
     * @throws ProductException Own product exception.
     */
    void addProduct(Login login, Product product) throws ProductException;

    /**
     * Deletes product from the database.
     *
     * @param login   Current connection to the database.
     * @param product Product which should be removed from the database.
     * @throws ProductException Own product exception.
     */
    void deleteProduct(Login login, Product product) throws ProductException;

    /**
     * Edit product in database.
     *
     * @param login         Current connection to the database.
     * @param product       New edited product.
     * @param nameOfProduct Name of product should be edited.
     * @throws ProductException Own product exception.
     */
    void editProduct(Login login, Product product, String nameOfProduct) throws ProductException;

    void getId(Login login, String name);

}
