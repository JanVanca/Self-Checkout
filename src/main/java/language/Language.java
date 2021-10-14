package language;

public interface Language {

    /**
     * @return Prints admin options menu.
     */
    String getAdminOptions();

    /**
     * @return Prints console options menu.
     */
    String getConsoleMenu();

    String enterProduct();

    String enterCountOfProduct();

    String shoppingCart();

    String lackOfProducts();

    String soldOut();

    String wrongProduct();

    String enterDeleteProduct();

    String soldOutBalance();

    String removedProduct();

    String failedToRemove();

    String successfullyRemoved();

    String productsFailedToLoad();

    String allProductsInStorage();

    String enterNewEngProduct();

    String enterNewSkProduct();

    String enterPriceOfProduct();

    String enterNumberOfProduct();

    String successfullyAddedProduct();

    String failedToAddProduct();

    String successfullyDeletedProduct();

    String successfullyLoggedOut();

    String newEnName();

    String newSkName();

    String newCount();

    String newPrice();

    String getPriceInShoppingCart();

}
