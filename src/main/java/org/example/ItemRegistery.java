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

    public List<Item> getItemRegister(){
        return itemRegister;
    }

    public void addItem(Item t){
        itemRegister.add(t);
    }

    public void removeAll(){
        itemRegister.clear();
    }

    public void attachTableView(TableView tv){
        tv.setItems(itemRegister);
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

    // Serializing
    private void writeitems(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeObject(new ArrayList<>(itemRegister));
    }

    private void readItems(ObjectInputStream s) throws IOException, ClassNotFoundException{
    List<Item> list = (List<Item>) s.readObject();
    itemRegister = FXCollections.observableArrayList();
    itemRegister.addAll(list);
    }




}
