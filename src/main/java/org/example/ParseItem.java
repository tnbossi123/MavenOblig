package org.example;

public class ParseItem {

    public static Item parseItem(String line) throws InvalidItemFormatException{
        // split line string into three using the DELIMITTER created earlier ";"

        String[] strings = line.split(ItemFormatter.DELIMITTER);

        if (strings.length != 2){
            throw new InvalidItemFormatException("Wrong use of speciall mark");
        }

        //Extracting all datafiles from the string
        String pName = strings[0];
        int pPrice = parsePrice(strings[1], "Price needs to be a number");

        //Create bew item object, if data is valid
        try{
            return new Item(pName, pPrice);
        } catch (IllegalArgumentException e){
            throw new InvalidItemFormatException(e.getMessage());
        }
    }

    // Parses the price
    private static int parsePrice(String str, String errorMessage) throws IllegalArgumentException{
        int number;
        try {
            number= Integer.parseInt(str);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(errorMessage);
        }

        return number;
    }
}
