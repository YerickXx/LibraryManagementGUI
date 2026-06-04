/* Main class, here is the enter "door" of the app*/
package Main;

import GUI.MainMenu;
import Logic.LibroLogic;

public class YerickAbarca_Proyecto1 {
    public static void main(String[] args) {
        LibroLogic L = new LibroLogic();
        /*display the form (Main menu)*/
        new MainMenu(L).setVisible(true);
    }
    
}
