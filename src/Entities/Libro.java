/*"Libro" class, here you can find all about the object "Libro*, 
   using private atributes i imported the LocalDateTime for work with "fecha" 
*/

package Entities;
import java.time.LocalDate;

public class Libro {
    
    /*Attributes declaration as private*/
    
    private int id;
    private String nombreLibro;
    private String nombreAutor;
    private LocalDate fecha;
    private String nombreBiblioteca;
    private static int idCounter = 1;
    
    /*Constructor method, without the id because it need to be auto*/
    
    public Libro(String nombreLibro, String nombreAutor, 
                     LocalDate fecha, String nombreBiblioteca)
    {
        this.id = idCounter;
        idCounter++;
        this.nombreLibro = nombreLibro;
        this.nombreAutor = nombreAutor;
        this.fecha = fecha;
        this.nombreBiblioteca = nombreBiblioteca;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
    }

    @Override
    public String toString() {
    return  " | Título: " + this.nombreLibro + 
            " | Autor: " + this.nombreAutor + " | Fecha: " + this.fecha + 
            " | Biblioteca: " + this.nombreBiblioteca;
}
}
