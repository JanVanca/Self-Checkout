package language.impl;

import language.Language;

public class SlovakLanguage implements Language {

    @Override
    public String getAdminOptions() {
        return "---ADMIN MENU---\n" +
                "1. Pridat produkt\n" +
                "2. Vymazat produkt\n" +
                "3. Zobrazit vsetky produkty v sklade\n" +
                "4. Editovat produkt\n" +
                "5. Koniec";
    }

    @Override
    public String getConsoleMenu() {
        return "1. Pokracovat \n" +
                "2. Zaplatit \n" +
                "3. Vymazat produkt \n" +
                "4. Zmenit pocet produktov na sklade\n" +
                "5. Koniec \n";
    }

    @Override
    public String enterProduct() {
        return "Zadaj produkt: ";
    }

    @Override
    public String enterCountOfProduct() {
        return "Zadaj pocet produktov: ";
    }

    @Override
    public String shoppingCart() {
        return "Produkty v nakupnom kosiku: ";
    }

    @Override
    public String lackOfProducts() {
        return "Produkt nie je dostatocne naskladneny, maximalny pocet stale dostupnych produktov je: ";
    }

    @Override
    public String soldOut() {
        return "Produkt nie je na sklade";
    }

    @Override
    public String wrongProduct() {
        return "Pri hladani produktu sa vyskytla chyba. Produkt sa nenasiel";
    }

    @Override
    public String enterDeleteProduct() {
        return "Zadany produkt, ktory ma byt vymazany sa nenachadza v nakupnom kosiku: ";
    }

    @Override
    public String soldOutBalance() {
        return "Produkt nie je dostatocne naskladovany, maximalny pocet produktov na sklade je: ";
    }

    @Override
    public String removedProduct() {
        return "Vymazany produkt: ";
    }

    @Override
    public String failedToRemove() {
        return "Produkt nebol odstraneny z nakupneho kosika";
    }

    @Override
    public String successfullyRemoved() {
        return "Produkt bol uspesne odstraneny z nakupneho kosika";
    }

    @Override
    public String productsFailedToLoad() {
        return "Produkty sa nepodarilo nacitat";
    }

    @Override
    public String allProductsInStorage() {
        return "Vsetky produkty na sklade: ";
    }

    @Override
    public String enterNewEngProduct() {
        return "Zadaj nazov noveho produktu v anglickom jazyku: ";
    }

    @Override
    public String enterNewSkProduct() {
        return "Zadaj nazov produktu v slovenskom jazyku: ";
    }

    @Override
    public String enterPriceOfProduct() {
        return "Zadaj cenu produktu";
    }

    @Override
    public String enterNumberOfProduct() {
        return "Zadaj pocet produktov";
    }

    @Override
    public String successfullyAddedProduct() {
        return "Produkt bol uspesne pridany";
    }

    @Override
    public String failedToAddProduct() {
        return "Produkt sa nepodarilo pridat";
    }

    @Override
    public String successfullyDeletedProduct() {
        return "Produkt bol uspesne vymazany zo skladu";
    }

    @Override
    public String successfullyLoggedOut() {
        return "Admin bol uspesne odhlaseny";
    }

    @Override
    public String newEnName() {
        return "Zadaj novy nazov produktu v anglickom jazyku: ";
    }

    @Override
    public String newSkName() {
        return "Zadaj novy nazov produktu v slovenskom jazyku: ";
    }

    @Override
    public String newCount() {
        return "Zadaj novu cenu produktu: ";
    }

    @Override
    public String newPrice() {
        return "Zadaj pocet produktov: ";
    }

    @Override
    public String getPriceInShoppingCart() {
        return "Cena v nakupnom kosiku: ";
    }

}
