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
public class Location {
    private int longitude;
    private int latitude;
    
    //Constructor
    public Location(int longitude, int latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLatitude() {
        return latitude;
    }
}
