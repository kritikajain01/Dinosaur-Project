/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbt;

/**
 *
 * @author amitsen
 */
public class DinosaurBone {
    private Location location;
    private int id;
    private double price;
    private boolean sold;
    
    //Constructor
    public DinosaurBone(Location location, int id, double price) {
        this.sold = false;
        this.location = location;
        this.id = id;
        this.price = price;
    }

    // Methods
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public boolean isSold() {
        return sold;
    }
    
}
