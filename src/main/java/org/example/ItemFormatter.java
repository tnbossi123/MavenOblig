package org.example;

import java.util.List;

public class ItemFormatter {

    public static String DELIMITTER = ";";

    public static String formatItem(Item i){
        return i.getItemName() + DELIMITTER + i.getItemPrice();
    }

    public static String formatItems(List<Item> iList){
        StringBuffer str = new StringBuffer();

        for (Item t : iList){
            str.append(formatItem(t));
            str.append("\n");
        }

        return str.toString();

    }

}
