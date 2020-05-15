package org.example;

public class ItemValidator {

    // Items name
    static boolean itemNameValidator(String iName){
        return !iName.isEmpty() && iName.matches("^(^\\?)?(16|17|18|19|20|21)|^(^\\?)?([A-Z]?[a-z]{1,10}[-]?[A-Z]?[a-z]{1,10})");
    }

    // iTems price

    public static final int MAX_PRICE = 100_000;
    public static final int MIN_PRICE = 2000;

    static boolean itemPriceValidator(int iPrice){
        return iPrice >= MIN_PRICE && iPrice <= MAX_PRICE;
    }
}
