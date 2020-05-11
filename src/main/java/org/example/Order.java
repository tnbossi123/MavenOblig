package org.example;

public class Order {
    private int type;
    private int color;
    private double price;
    private int rim;


    public int getQuantity() {
        return rim;
    }


    public void setQuantity(int quantity) {
        this.rim = quantity;
    }


    public double getPrice() {
        return price;
    }


    public void setPrice(double price) {
        this.price = price;

    }


    public int getColor() {
        return color;
    }


    public void setColor(int size) {
        this.color = color;
    }


    public int getType() {
        return type;
    }


    public void setType(int type) {
        this.type = type;
    }

}


