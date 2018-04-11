/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author amitsen
 */
public class Map {
    
    private String fileName;
    private ArrayList<MapNode> mapNodeList;
    private Formatter screen;
    
    //Constructor
    public Map(String fileName, Formatter screen) {
        this.fileName = fileName;
        mapNodeList = new ArrayList<>();
        this.screen = screen;
    }
    
    //Methods
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
    
    public void load() {
        File mapFile = new File(this.fileName);
        String line = null;
        String dataset[];
        MapNode tempNode;
        
        try
        {
            Scanner mapReader = new Scanner(mapFile);
        
        
            while (mapReader.hasNextLine())
            {
                line = mapReader.nextLine();
                dataset = line.split(",");
                tempNode = new MapNode(Integer.parseInt(dataset[0]), Integer.parseInt(dataset[1]), Integer.parseInt(dataset[2]));
                mapNodeList.add(tempNode);
            }
            mapReader.close();
        }
        catch (FileNotFoundException fnfE)
        {
            fnfE.printStackTrace();
        }
    }

    public ArrayList<MapNode> getMapNodeList() {
        return mapNodeList;
    }
    
    public void show() {
        
        char mapDisplayArray[][];
        
        mapDisplayArray = new char[60][20];//Columnn by Row
        
        //Translate Array List to 2D Array
        mapNodeListToMapArray(mapDisplayArray);
        
        //Show the 2D array
        
        for (int rowLoop=0;rowLoop<20;rowLoop++)
        {
            for(int colLoop=0;colLoop<60;colLoop++)
            {
                screen.format("%c",mapDisplayArray[colLoop][rowLoop]);
                
            }
            screen.format("\n");
        }
    }

    // private methods
    private void mapNodeListToMapArray(char[][] mapDisplayArray) {
        MapNode tempNode;
        
        for (int mapLoop = 0; mapLoop < mapNodeList.size() ; mapLoop++)
        {
            tempNode = this.mapNodeList.get(mapLoop);
            //screen.format("%d,%d,%d",tempNode.col,tempNode.row,tempNode.land);
        
            switch(tempNode.getLand())
            {
                case 0:
                    mapDisplayArray[tempNode.getRow()][tempNode.getCol()]='.';
                    break;
                case 1:
                    mapDisplayArray[tempNode.getRow()][tempNode.getCol()]='*';
                    break;
            }
        }
    }
}
