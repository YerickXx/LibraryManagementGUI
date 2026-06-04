/* in this class is the site where all validations work, 
   the main idea is take the values from the Frontend and validate that here 
   if the values pass the validations going to Logic layer
 */
package Validations;

// Important packages for the correct functionally of this class
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class ValidacionesGenerales 
{
    public boolean validacionTexto(ArrayList text) 
    {
        for(var v : text) // iterate the ArrayList for check the values 
        {
            if(v != null && !v.toString().trim().isEmpty() 
                    && v.toString().matches("^[a-zA-Z]+"))// this is the validation 
            {                                             //for text input (String) checking if not "blank"
              return true;                                // null and if are just letters
            }
        }   
        return false;
    }
    
    /*Function for validate date and format it*/
    public boolean validacionFechas(String date) 
    {
        try
        {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy"); // format pattern day-month-year
        LocalDate d = LocalDate.parse(date, formatter);
        return true;
        }catch(DateTimeParseException e)
        {
            return false;
        }
    }
}
