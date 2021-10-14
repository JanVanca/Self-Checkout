package core;

import database.entity.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingCart {

    private final List<Product> products = new ArrayList<Product>();
    private double price;

    /**
     * Adds the product to the shopping cart.
     *
     * @param product Entered product to be added to shopping cart.
     */
    public void addProductToShoppingCart(Product product) {
        products.add(product);
    }

    /**
     * Removes all product from shopping cart.
     */
    public void removeShoppingCart() {
        products.clear();
    }

    /**
     * Removes entered product from shopping cart.
     *
     * @param product Product to be removed.
     */
    public boolean removeProductFromShoppingCart(String product) {
        if (product != null) {
            products.remove(product);
            return true;
        } else {
            return false;
        }
    }

    public List<Product> getProducts() {
        return new ArrayList<Product>(products);
    }

    /**
     * Number of same products in the shopping cart.
     *
     * @param product Entered product.
     * @return Number of specific products.
     */
    public int countOfProductByName(String product) {
        return products.stream().filter(s -> s.getEnName().equals(product)).mapToInt(s -> s.getCount()).sum();
    }

    /**
     * Find out if the entered product is in the shopping cart.
     *
     * @param product Searched product
     * @return True if product is in shopping cart. If not return false.
     */
    public boolean isProductInCart(String product) {
        return products.stream().anyMatch(s -> s.equals(product));

//        Alternative two
//        for (String p : products) {
//            if (p.equals(product)) {
//                return true;
//            }
//        }
//        return false;
    }

    /**
     * @return Price in shopping cart.
     */
    public double getPrice() {
        return products.stream().mapToDouble(value -> value.getPrice() * value.getCount()).sum();

//        alternative two
//        int i = 0;
//        price = 0;
//        while (i < products.size()) {
//            price = price + products.get(i).getPrice() * products.get(i).getCount();
//            price = Math.round(price * 100.00) / 100.00;
//            i++;
//        }
//        return price;

    }

    /**
     * @param paid The amount that has been paid.
     */
    public void pay(double paid) {
        price = price - paid;
        price = Math.round(price * 100.00) / 100.00;
        if (price < 0) {
            forReturn(price);
        }

    }

    /**
     * @return The balance of the amount to be paid.
     */
    public double getAmountPaid() {
        return price;
    }

    /**
     * Calculates how much and which banknotes should be returned.
     *
     * @param price The amount to be refunded.
     */
    private void forReturn(double price) {
        price = price * (-1);
        final double sum = price;
        List<Banknotes> banknotes;
       banknotes = Arrays.asList(Banknotes.values());

       // banknotes.stream().filter(banknote -> banknote.getValue() > sum).findFirst().;
        Arrays.stream(Banknotes.values()).filter(banknote -> banknote.getValue() > sum).findFirst();

    }
}