package language.impl;

import language.Language;

public class EnglishLanguage implements Language {

    @Override
    public String getAdminOptions() {
        return "---ADMIN MENU---\n" +
                "1. Add product\n" +
                "2. Delete product\n" +
                "3. Show all products in storage\n" +
                "4. Edit product\n" +
                "5. Exit";
    }

    @Override
    public String getConsoleMenu() {
        return "1. Continue \n" +
                "2. Pay \n" +
                "3. Remove product \n" +
                "4. Exit \n";
    }

    @Override
    public String enterProduct() {
        return "Enter product: ";
    }

    @Override
    public String enterCountOfProduct() {
        return "Enter the count of product: ";
    }

    @Override
    public String shoppingCart() {
        return "Products in shopping cart: ";
    }

    @Override
    public String lackOfProducts() {
        return "The product is not sufficiently in storage, the maximum number of still available products is: ";
    }

    @Override
    public String soldOut() {
        return "Product is not in storage.";
    }

    @Override
    public String wrongProduct() {
        return "Error finding product. The product was not found";
    }

    @Override
    public String enterDeleteProduct() {
        return "Enter the product you want to remove from shopping cart: ";
    }

    @Override
    public String soldOutBalance() {
        return "The product is not sufficiently in storage, the maximum number of products in storage is: ";
    }

    @Override
    public String removedProduct() {
        return "Removed product: ";
    }

    @Override
    public String failedToRemove() {
        return "Product was not remove from cart";
    }

    @Override
    public String successfullyRemoved() {
        return "Product was removed from cart ";
    }

    @Override
    public String productsFailedToLoad() {
        return "Products failed to load";
    }

    @Override
    public String allProductsInStorage() {
        return "All products in storage: ";
    }

    @Override
    public String enterNewEngProduct() {
        return "Enter the name of new product in english language: ";
    }

    @Override
    public String enterNewSkProduct() {
        return "Enter the name of new product in slovak language: ";
    }

    @Override
    public String enterPriceOfProduct() {
        return "Enter the price of product";
    }

    @Override
    public String enterNumberOfProduct() {
        return "Enter the number of products";
    }

    @Override
    public String successfullyAddedProduct() {
        return "Product was successfully added";
    }

    @Override
    public String failedToAddProduct() {
        return "Failed to add product";
    }

    @Override
    public String successfullyDeletedProduct() {
        return "Product was successfully deleted from storage";
    }

    @Override
    public String successfullyLoggedOut() {
        return "Admin was successfully logged out";
    }

    @Override
    public String newEnName() {
        return "Enter new en name of product: ";
    }

    @Override
    public String newSkName() {
        return "Enter new sk name of product: ";
    }

    @Override
    public String newCount() {
        return "Enter new price: ";
    }

    @Override
    public String newPrice() {
        return "Enter count of product: ";
    }

    @Override
    public String getPriceInShoppingCart() {
        return "Price in shopping cart: ";
    }


}
