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
public class MapNode {
    //Attribute
    private int row;
    private int col;
    private int land;

    //Constructor
    public MapNode(int row, int col, int land) {
        this.row = row;
        this.col = col;
        this.land = land;
    }

    //methods
    public void setCol(int col) {
        this.col = col;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getRow() {
        return row;
    }

    public void setLand(int land) {
        this.land = land;
    }

    public int getLand() {
        return land;
    }
}
