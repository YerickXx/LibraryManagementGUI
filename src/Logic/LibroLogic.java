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

public class LibroLogic 
{
    // Declaration of the ArrayList and a global variable for date parsing
    ArrayList <Libro> lib = new ArrayList();
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
        
        try{ // try...catch for parse the date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        libroDate = LocalDate.parse(notFormattedDate , formatter);
        }catch(DateTimeParseException e)
        {
            System.out.println("Error de parseo de fecha!");
        }
        
        String libroBiblioteca = arr.get(3).toString();
        Libro L = new Libro(libroName,autorName,libroDate,libroBiblioteca); // creating the object
        lib.add(L); // adding to ArrayList 
    }
    
    public void leerLibros()
    {
        Iterator <Libro> itr = lib.iterator();
        while(itr.hasNext()){
          Libro el = itr.next();
          System.out.println(el.toString());
        }
    }
}
