/* Main class, here is the enter "door" of the app*/
package Main;

import GUI.MainMenu;

public class YerickAbarca_Proyecto1 {

    public static void main(String[] args) {
        /*display the form (Main menu)*/
        java.awt.EventQueue.invokeLater(() -> new MainMenu().setVisible(true));
    }
    
}
