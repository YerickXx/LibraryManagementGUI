/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;

import Entities.Libro;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import java.util.List;

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
// Ahora recibe por parámetro la lógica compartida que viene del front
public static DefaultTableModel obtenerBibliotecasInvertidas(LibroLogic sharedLogic) {
    String[] columnas = {"ID", "Biblioteca"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    // Validamos usando la instancia que nos pasa el front
    if (sharedLogic == null || sharedLogic.lib == null || sharedLogic.lib.isEmpty()) {
        return modelo;
    }

    // Le pasamos la lista de la instancia al método recursivo
    llenarTablaRecursivo(0, sharedLogic.lib, modelo);
    return modelo;
}

// Recibe la lista explícitamente para trabajar sobre ella
private static void llenarTablaRecursivo(int indice, List<Libro> lista, DefaultTableModel modelo) {
    if (indice >= lista.size()) {
        return;
    }

    Libro el = lista.get(indice);
    String nombreInvertido = invertirTexto(el.getNombreBiblioteca());

    Object[] info = {
        el.getId(),
        nombreInvertido
    };
    modelo.addRow(info);
    state = true;

    llenarTablaRecursivo(indice + 1, lista, modelo);
}
private static String invertirTexto(String texto) {
    if (texto == null || texto.length() <= 1) {
        return texto;
    }
    return texto.charAt(texto.length() - 1) + invertirTexto(texto.substring(0, texto.length() - 1));
}

}
