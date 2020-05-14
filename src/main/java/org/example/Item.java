package org.example;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.*;

public class Item implements Serializable {

    private transient SimpleStringProperty itemName;
    private transient SimpleIntegerProperty itemPrice;

    // Constructer
    public Item(String itemName, int itemPrice){

        if (!ItemValidator.itemNameValidator(itemName)){
            throw new IllegalArgumentException("Unvalid car brand chosen");
        }

        if (!ItemValidator.itemPriceValidator(itemPrice)){
            throw new IllegalArgumentException("Unvalid price is chosen");
        }

        this.itemName = new SimpleStringProperty(itemName);
        this.itemPrice = new SimpleIntegerProperty(itemPrice);

    }


    // Getters
    public String getItemName() {
        return itemName.get();
    }

    public int getItemPrice() {
        return itemPrice.get();
    }

    // Setter

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice.set(itemPrice);
    }

    // Serializing write items
    private void writeItems(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeUTF(getItemName());
        s.writeInt(getItemPrice());
    }

    // Serializing read items
    private void raedItems(ObjectInputStream s) throws IOException, ClassNotFoundException{

        String itemName = s.readUTF();
        int itemPrice = s.readInt();

        this.itemName = new SimpleStringProperty(itemName);
        this.itemPrice = new SimpleIntegerProperty(itemPrice);

        setItemName(itemName);
        setItemPrice(itemPrice);
    }

}