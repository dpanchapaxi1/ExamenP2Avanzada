package Examen.parcial2.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;   
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Libros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Nombre;

    //getters y settesrs

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public Libros() {
    }

    public Libros(Long id, String nombre) {
        this.id = id;
        Nombre = nombre;
    }    

    
}
