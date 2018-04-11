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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author amitsen
 */
public class FileOperation {
    private ArrayList<DinosaurBone> bones;
    private Formatter screen;

    public FileOperation(Formatter screen) {
        this.screen = screen;
    }

    public void setBones(ArrayList<DinosaurBone> bones) {
        this.bones = bones;
    }

    public ArrayList<DinosaurBone> getBones() {
        return bones;
    }

    public void writeOnFile() {
        File dbstFile = new File(AppConstants.getInstance().DINOSAUR_BONE_FILE_NAME);
       
        
        try {
            Formatter fileWriter=new Formatter(dbstFile);
            
            fileWriter.format("Dinosaur Bone List\n");
                fileWriter.format("------------------\n");
            
            for(int i = 0; i < bones.size(); i++) {
                int id = bones.get(i).getId();
                int longitude = bones.get(i).getLocation().getLongitude();
                int latitude = bones.get(i).getLocation().getLatitude();
                double price = bones.get(i).getPrice();
                boolean sold = bones.get(i).isSold();
                
                
                if(sold) 
                    fileWriter.format("ID: %d, Location: (%d, %d), Price: %.2f, Status: Sold\n", id, longitude, latitude, price); 
                else 
                    fileWriter.format("ID: %d, Location: (%d, %d), Price: %.2f, Status: Unsold\n", id, longitude, latitude, price);
            }
            
            fileWriter.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FileOperation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void loadFromFile() {
        File dbstFile = new File(AppConstants.getInstance().DINOSAUR_BONE_FILE_NAME);
        String line;
        
           
        try {
            Scanner fileReader=new Scanner(dbstFile);
            
            while (fileReader.hasNextLine()) {
                line = fileReader.nextLine();
                screen.format("%s\n", line);
            }
            
            fileReader.close();
            
        }
        catch (FileNotFoundException fnfe){
            fnfe.printStackTrace();
                
        }
    }
}
