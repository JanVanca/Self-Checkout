package console;

import core.Settings;
import core.ShoppingCart;
import database.entity.Product;
import database.entity.Products;
import database.exception.ProductException;
import database.service.ProductService;
import database.service.impl.Login;
import database.service.impl.ProductServiceJDBC;
import language.Language;
import language.impl.EnglishLanguage;
import language.impl.Languages;
import language.impl.SlovakLanguage;

import java.util.List;
import java.util.Scanner;

public class Console {

    private Language language;
    private final ProductService productServiceJDBC = new ProductServiceJDBC();
    private final ShoppingCart shoppingCart = new ShoppingCart();

    /**
     * Launches the console with basic data.
     *
     * @param login Current connection to the database.
     */
    public void start(Login login, Settings settings) {
        Scanner input = new Scanner(System.in);
        if (settings.getLanguage() == Languages.SLOVAK) {
            language = new SlovakLanguage();
        } else {
            language = new EnglishLanguage();
        }
        if (login.isAdminLogged()) {
            int choice = 0;
            while (choice != 5) {
                System.out.println(language.getAdminOptions());
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        addProductToStorage(login);
                        break;
                    case 2:
                        deleteProductFromStorage(login);
                        break;
                    case 3:
                        getAllProductsFromStorage(login);
                        break;
                    case 4:
                        editProduct(login);
                        break;
                    case 5:
                        logoutAdmin(login);
                        break;
                }
            }
        } else {
            insertProductToShoppingCart(login);
            int choice = 0;
            while (choice != 4) {
                System.out.println(language.getConsoleMenu());
                choice = input.nextInt();
                switch (choice) {
                    case 1:
                        insertProductToShoppingCart(login);
                        break;
                    case 2:
                        payForProducts();
                        break;
                    case 3:
                        deleteProduct();
                        break;
                    case 4:
                        shoppingCart.removeShoppingCart();
                        return;
                }
            }
        }
    }

    /**
     * Adds the product to the database.
     *
     * @param login Current login.
     */
    public void addProductToStorage(Login login) {
        Scanner input = new Scanner(System.in);
        System.out.println(language.enterNewEngProduct());
        String enName = input.nextLine();
        System.out.println(language.enterNewSkProduct());
        String skName = input.nextLine();
        System.out.println(language.enterNumberOfProduct());
        int count = input.nextInt();
        System.out.println(language.enterPriceOfProduct());
        double price = input.nextDouble();
        Product product = new Product(enName, skName, price, count);
        try {
            productServiceJDBC.addProduct(login, product);
            System.out.println(language.successfullyAddedProduct());
        } catch (ProductException e) {
            System.out.println(language.failedToAddProduct());
            e.printStackTrace();
        }
    }

    /**
     * Deletes the product from the database.
     *
     * @param login Current login.
     */
    public void deleteProductFromStorage(Login login) {
        Scanner input = new Scanner(System.in);
        System.out.println(language.enterProduct());
        String nameOfProduct = input.nextLine();
        try {

            List<Products> products = productServiceJDBC.getProduct(nameOfProduct, login);
            Product product = new Product(products.get(0).getEnName(), products.get(0).getSkName(), products.get(0).getPrice(), products.get(0).getCount());
            try {
                productServiceJDBC.deleteProduct(login, product);
                System.out.println(language.successfullyDeletedProduct());
            } catch (ProductException e) {
                e.printStackTrace();
            }
        } catch (ProductException e) {
            System.out.println(language.wrongProduct());
            e.printStackTrace();
        }
    }

    /**
     * Prints all products from the database.
     *
     * @param login Current login.
     */
    public void getAllProductsFromStorage(Login login) {
        try {
            List<Products> products = productServiceJDBC.getAllProducts(login);
            System.out.println(language.allProductsInStorage() + products);
        } catch (ProductException e) {
            System.out.println(language.productsFailedToLoad());
            e.printStackTrace();
        }
    }

    /**
     * Edits the selected product according to the specified name.
     *
     * @param login Current login.
     */
    public void editProduct(Login login) {
        Scanner input = new Scanner(System.in);
        System.out.println(language.enterProduct());
        String nameOfProduct = input.nextLine();
        System.out.println(language.newEnName());
        String enName = input.nextLine();
        System.out.println(language.newSkName());
        String skName = input.nextLine();
        System.out.println(language.newPrice());
        //toto nemusi to byt Double, staci double
        Double price = input.nextDouble();
        System.out.println(language.newCount());
        int count = input.nextInt();
        Product product = new Product(enName, skName, price, count);
        try {
            productServiceJDBC.editProduct(login, product, nameOfProduct);
        } catch (ProductException e) {

        }

    }

    /**
     * Call the payment method.
     */
    public void payForProducts() {
        Scanner input = new Scanner(System.in);
        while (shoppingCart.getAmountPaid() > 0) {
            System.out.println("Suma k zaplateniu: " + shoppingCart.getAmountPaid());
            System.out.println("zadaj sumu ktorou platis: ");
            double price = input.nextDouble();
            shoppingCart.pay(price);
        }
    }

    /**
     * Logout admin user.
     *
     * @param login Current connection to thte database.
     */
    public void logoutAdmin(Login login) {
        login.setAdminLogged(false);
        System.out.println(language.successfullyLoggedOut());
    }

    /**
     * Launches the console to add the product to the shopping cart
     *
     * @param login Current connection to the database.
     */
    private void insertProductToShoppingCart(Login login) {
        Scanner input = new Scanner(System.in);
        Product product;
        System.out.println(language.enterProduct());
        String nameOfProduct = input.nextLine();
        System.out.println(language.enterCountOfProduct());
        int countOfProduct = input.nextInt();
        try {
            List<Products> products = productServiceJDBC.getProduct(nameOfProduct, login);
            if (products.size() == 0) {
                System.out.println(language.soldOut());
                return;
            }
            product = new Product(nameOfProduct, countOfProduct, products.get(0).getPrice());
            for (Products p : products) {
                if (product.getCount() <= p.getCount()) {
                    if (shoppingCart.countOfProductByName(nameOfProduct) + countOfProduct <= p.getCount()) {
                        shoppingCart.addProductToShoppingCart(product);
                        System.out.println(language.shoppingCart() + shoppingCart.getProducts());
                    } else {
                        System.out.println(language.lackOfProducts() + (p.getCount() - shoppingCart.countOfProductByName(nameOfProduct)));
                    }
                } else {
                    System.out.println(language.soldOutBalance() + p.getCount());
                }
            }
            System.out.println(language.getPriceInShoppingCart() + shoppingCart.getPrice());
        } catch (ProductException e) {
            System.out.println(language.wrongProduct());
            e.printStackTrace();
        }
    }

    /**
     * Remove the product from the shopping cart.
     */
    private void deleteProduct() {
        Scanner input = new Scanner(System.in);
        String product;
        System.out.println(language.enterDeleteProduct());
        product = input.nextLine();
        if (shoppingCart.isProductInCart(product)) {
            if (shoppingCart.removeProductFromShoppingCart(product)) {
                System.out.println(language.removedProduct());
            } else {
                System.out.println(language.failedToRemove());
            }
        } else {
            System.out.println(language.successfullyRemoved());
        }
    }
}