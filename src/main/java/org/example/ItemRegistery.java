package org.example;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemRegistery {


    private transient ObservableList<Item> itemRegister = FXCollections.observableArrayList();

    public void attachTableView(TableView tv){
        tv.setItems(itemRegister);
    }

    public void setItemRegister(ArrayList<Item> itemRegister) {
        this.itemRegister.clear();
        this.itemRegister.addAll(itemRegister);

    }

    public void ItemRegistery(String lblItemName, int lblItemPrice){


        Item newItem = new Item(lblItemName, lblItemPrice);
        itemRegister.add(newItem);

    }


    //Filtering by Name/Price
    public void filterItemRegister(String key, String input, TableView tv){

        // Checks if anything is searched
        if (input == null || input.trim().isEmpty()){
            tv.setItems(itemRegister);
        }else{
            // Cheks which filterkye is chone, then checks what has been written
            if (key.equals("Product")){
                tv.setItems(itemRegister.stream().filter(item -> item.getItemName().toUpperCase().contains(input.toUpperCase())).collect(Collectors.toCollection(FXCollections::observableArrayList)));
            }
            if (key.equals("Price")){
                tv.setItems(itemRegister.stream().filter(item -> Integer.toString(item.getItemPrice()).equals(input)).collect(Collectors.toCollection(FXCollections::observableArrayList)));
            }
        }
    }

    public List<Item> getItemRegister(){
        return itemRegister;
    }






}
