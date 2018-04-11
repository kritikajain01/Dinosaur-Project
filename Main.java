/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbbt;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author amitsen
 */
public class Main {
    
    //Attribute
    private Formatter screen;
    private Scanner keyboard;
    private Map worldMap;
    private ArrayList<DinosaurBone> boneList;
    private FileOperation fileOp;
    
    //Constructor
    public Main() {
        screen = new Formatter(System.out);
        keyboard = new Scanner(System.in);
        worldMap = new Map(AppConstants.getInstance().MAP_FILE_NAME, this.screen);
        boneList = new ArrayList<>();
        fileOp = new FileOperation(screen);
        
        screen.format("DBBT: The Dinosaur Bone Buyer Tool\n");
        screen.format("----------------------------------\n");
    }
    
    private void showMenu() {
        
        screen.format("\n---------\n");
        screen.format("Main Menu\n");
        screen.format("---------\n\n");
        
        screen.format("1. Load the World Map.\n");
        screen.format("2. Show the World Map with Dinosaur Bones.\n");
        screen.format("3. Allows the user to buy a dinosaur bone.\n");
        screen.format("4. Save files.\n");
        screen.format("5. Load files.\n");
        screen.format("6. Exit.\n");
        
        screen.format("::> ");
        
        String input = keyboard.nextLine();
        
        switch(input) {
            case "1":
                loadMap();
                break;
            case "2":
                showMap();
                break;
            case "3":
                buyDinosaurBone();
                break;
            case "4":
                saveFiles();
                break;
            case "5":
                loadFiles();
                break;
            case "6":
            case "Q":
            case "q":
            case "X":
            case "x":
                quit();
                break;
            default:
                screen.format("Wrong choice! Please try again!");
                repeatMenuList();
                break;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Main dbbtMain = new Main();
        dbbtMain.showMenu();
    }
    
    private void loadMap() {
        worldMap.load();
        screen.format("Map has been loaded successfully!");
        this.repeatMenuList();
    }
    
    private void repeatMenuList() {
        screen.format("\n");
        this.showMenu();
    }
    
    private void showMap() {
        screen.format("\nJurassic Shop\n");
        screen.format("-------------\n\n");
        worldMap.show();
        this.repeatMenuList();
    }
    
    private void buyDinosaurBone() {
    
    }

    private void saveFiles() {
        fileOp.setBones(boneList);
        fileOp.writeOnFile();
        screen.format("File saved successfully!\n");
        repeatMenuList();
    }

    private void loadFiles() {
        fileOp.loadFromFile();
        repeatMenuList();
    }

    private void quit() {
        screen.format("Bye!\n\n");
    }
}
