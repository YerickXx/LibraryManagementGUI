/*
    In this file is all the logic for "libro" Object (CRUD), 
    also the the instance for that object.
     
    The main idea here is take values from the GUI already validated 
    and create the object with these values
 */

package Logic;
// Important packages for the correct function of this class
import java.util.ArrayList;
import Entities.Libro;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;

public class LibroLogic 
{
    // Declaration of the ArrayList and a global variable for date parsing
    public static ArrayList <Libro> lib = new ArrayList();
    LocalDate libroDate;
    
    /*
      This method is in charge to create the object taking the values from the frontEnd, 
      then add these values to the ArrayList, id is created auto in class Libro
    */
    public void crearObjeto(ArrayList arr)
    {
        String libroName = arr.get(0).toString();
        String autorName = arr.get(1).toString();
        String notFormattedDate = arr.get(2).toString();
        String libroBiblioteca = arr.get(3).toString(); 
        
        try{ // try...catch for parse the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        libroDate = LocalDate.parse(notFormattedDate , formatter);
        }catch(DateTimeParseException e)
        {
            System.out.println("Error de parseo de fecha!");
        }
        Libro L  = new Libro(libroName,autorName,libroDate,libroBiblioteca); // creating the object
        lib.add(L); // adding to ArrayList 
    }
    
    public DefaultTableModel creatingJtableModel()
    {
        String[] columnas = {"ID", "Titulo", "Autor", "Fecha", "Biblioteca"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
         Iterator <Libro> itr = lib.iterator();
         while(itr.hasNext()){
          Libro el = itr.next();
          
          Object[] info = 
          {
              el.getId(),
              el.getNombreLibro(),
              el.getNombreAutor(),
              el.getFecha(),
              el.getNombreBiblioteca()
          };
          modelo.addRow(info);
        }
         return modelo;
    }
}
