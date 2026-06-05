/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Entities.Libro;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yeric
 */
public class BiliotecaLogic {
    static LibroLogic lib;
    public static boolean state = false;
        
   // Pass the search string into the table model method
static public DefaultTableModel Bibliotecas(String word) 
{
    String[] columnas = {"ID", "Biblioteca"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
    
    Iterator<Libro> itr = lib.lib.iterator();
    while(itr.hasNext()) {
        Libro el = itr.next();
        
        String nombreBiblioteca = el.getNombreBiblioteca().toLowerCase();
        String searchWord = word.toLowerCase();
        
        if (nombreBiblioteca.contains(searchWord)) 
        {
            Object[] info = {
                el.getId(),
                el.getNombreBiblioteca()
            };
            modelo.addRow(info);
            state = true;
        }
    }
    return modelo;
}
}
