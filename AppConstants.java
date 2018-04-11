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
public class AppConstants {
    
    public final String MAP_FILE_NAME = "Map.txt";
    public final String DINOSAUR_BONE_FILE_NAME = "dinosaur_bones.txt";
    
    // Singleton thingy
    private static AppConstants instance = null;
 
    protected AppConstants() {
    }
 
    // Lazy Initialization (If required then only)
    public static AppConstants getInstance() {
	if (instance == null) {
            // Thread Safe. Might be costly operation in some case
            synchronized (AppConstants.class) {
                if (instance == null) {
                    instance = new AppConstants();
		}
            }
	}
	return instance;
    }
}
