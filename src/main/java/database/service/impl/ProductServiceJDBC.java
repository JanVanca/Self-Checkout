package database.service.impl;

import database.entity.Product;
import database.entity.Products;
import database.exception.ProductException;
import database.service.ProductService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductServiceJDBC implements ProductService {

    private static final String SELECT_PRODUCT = "SELECT en_name, sk_name, price, count FROM storage WHERE en_name = ? OR sk_name = ?;";
    private static final String SELECT_PRODUCTS = "SELECT en_name, sk_name, price, count FROM storage";
    private static final String INSERT_PRODUCT = "INSERT INTO storage (en_name, sk_name, price, count) VALUE (?, ?, ?, ?)";
    private static final String DELETE_PRODUCT = "DELETE FROM storage WHERE en_name = ? OR sk_name = ?;";
    private static final String SELECT_ID = "SELECT id FROM storage WHERE en_name = ? OR sk_name = ?;";
    private static final String UPDATE_PRODUCT = "UPDATE storage SET en_name = ?, sk_name = ?, price = ?, count = ? WHERE en_name = ? OR sk_name = ?;";


    @Override
    public List<Products> getProduct(String name, Login login) throws ProductException {
        List<Products> products = new ArrayList<Products>();
        try (PreparedStatement ps = login.getConnection().prepareStatement(SELECT_PRODUCT)) {
            ps.setString(1, name);
            ps.setString(2, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Products product = new Products(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getDouble(3),
                            rs.getInt(4)
                    );
                    products.add(product);
                }
            }
        } catch (SQLException e) {
            throw new ProductException("Error to loading product", e);
        }
        return products;
    }

    @Override
    public List<Products> getAllProducts(Login login) throws ProductException {
        List<Products> products = new ArrayList<Products>();
        try {
            Statement stm = login.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(SELECT_PRODUCTS);
            while (rs.next()) {
                Products product = new Products(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getInt(4)
                );
                products.add(product);
            }

        } catch (SQLException e) {
            throw new ProductException("Error to loading products", e);
        }
        return products;
    }

    @Override
    public void addProduct(Login login, Product product) throws ProductException {
        try (PreparedStatement ps = login.getConnection().prepareStatement(INSERT_PRODUCT)) {
            ps.setString(1, product.getEnName());
            ps.setString(2, product.getSkName());
            ps.setInt(3, product.getCount());
            ps.setDouble(4, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ProductException("Error to adding product", e);
        }
    }

    @Override
    public void deleteProduct(Login login, Product product) throws ProductException {
        try (PreparedStatement ps = login.getConnection().prepareStatement(DELETE_PRODUCT)) {
            ps.setString(1, product.getEnName());
            ps.setString(2, product.getSkName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ProductException("Error to deleting product", e);
        }
    }

    @Override
    public void editProduct(Login login, Product product, String nameOfProduct) throws ProductException {
        try (PreparedStatement ps = login.getConnection().prepareStatement(UPDATE_PRODUCT)) {
            ps.setString(1, product.getEnName());
            ps.setString(2, product.getSkName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getCount());
            ps.setString(5, nameOfProduct);
            ps.setString(6, nameOfProduct);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ProductException("Error to deleting product", e);
        }
    }

    @Override
    public void getId(Login login, String name) {
        List<Products> products = new ArrayList<Products>();
        try (PreparedStatement ps = login.getConnection().prepareStatement(SELECT_ID)) {
            ps.setString(1, name);
            ps.setString(2, name);
            ResultSet rs = ps.executeQuery();
            int i = rs.getInt(1);
            System.out.println(i);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
