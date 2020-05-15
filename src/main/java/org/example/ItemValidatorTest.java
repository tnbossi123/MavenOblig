package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemValidatorTest {

    @Test
    void testValidNames() {
        // For brands
        assertTrue(ItemValidator.itemNameValidator("Mercedes-Benz"));
        assertTrue(ItemValidator.itemNameValidator("Bmw"));
        assertTrue(ItemValidator.itemNameValidator("Volkswagen"));

        //For Colors
        assertTrue(ItemValidator.itemNameValidator("Red"));
        assertTrue(ItemValidator.itemNameValidator("Blue"));
        assertTrue(ItemValidator.itemNameValidator("Yellow"));

        // For Fuel
        assertTrue(ItemValidator.itemNameValidator("Electric"));
        assertTrue(ItemValidator.itemNameValidator("Petrol"));

        // For Wheel size
        assertTrue(ItemValidator.itemNameValidator("16"));
        assertTrue(ItemValidator.itemNameValidator("17"));
        assertTrue(ItemValidator.itemNameValidator("21"));

    }

    @Test
    void testInvalidNames(){
        assertFalse(ItemValidator.itemNameValidator(""));
        assertFalse(ItemValidator.itemNameValidator(" "));
        assertFalse(ItemValidator.itemNameValidator("  "));
        assertFalse(ItemValidator.itemNameValidator("1"));
        assertFalse(ItemValidator.itemNameValidator("123"));
        assertFalse(ItemValidator.itemNameValidator("1Brand"));
        assertFalse(ItemValidator.itemNameValidator("Brand1"));

    }

    @Test
    void testValidPrice() {
        assertTrue(ItemValidator.itemPriceValidator(ItemValidator.MIN_PRICE));
        assertTrue(ItemValidator.itemPriceValidator(ItemValidator.MAX_PRICE));

    }

    @Test
    void testInvalidPrice(){
        assertFalse(ItemValidator.itemPriceValidator(-1));
        assertFalse(ItemValidator.itemPriceValidator(0));
        assertFalse(ItemValidator.itemPriceValidator(ItemValidator.MAX_PRICE+1));
        assertFalse(ItemValidator.itemPriceValidator(ItemValidator.MIN_PRICE-1));

    }

}