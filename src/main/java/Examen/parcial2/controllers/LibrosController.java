package Examen.parcial2.controllers;

import org.springframework.web.bind.annotation.RestController;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import Examen.parcial2.models.Libros;
import Examen.parcial2.services.LibroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.HashMap;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/libros")
public class LibrosController {

    @Autowired
    private LibroService libroService;

    @GetMapping("/Listar")
    public Iterable<Libros> listarLibros(){
        return libroService.listarLibros();
    }
       

    @GetMapping("/buscar")
    public Libros buscarLibro(@RequestParam Long id){
        return libroService.buscarLibro(id);
    }


    @PostMapping("/guardar_Libro")
    public Map<String, String> guardarLibro(@RequestBody Libros libro){
        
        Libros libros = libroService.buscarLibro(libro.getId());
        Map<String, String> response = new HashMap<>();
        
        //revisar si el libro seleccionado no existe
        if(libros == null){

            libroService.guardarLibro(libro);
            response.put("message", "Libro guardado con exito");
            return response;
        }else{    
            response.put("message", "El libro ya existe");
            return response;
        }
    }

    @PostMapping("/actualizar_Libro")
    public Map<String, String> actualizarLibro(@RequestBody Libros libro){
        
        Libros libros = libroService.buscarLibro(libro.getId());
        Map<String, String> response = new HashMap<>();
        
        //revisar si el libro seleccionado existe
        if(libros != null){

            libroService.actualizarLibro(libro);
            response.put("message", "Libro actualizado con exito");
            return response;
        }else{    
            response.put("message", "El libro no existe");
            return response;
        }
    }

    //put para actualizar un libro
    @PutMapping("actualizar_libro/{id}")
    public Map<String, String> actualizarLibro(@PathVariable Long id, @RequestBody Libros libro){
        
        Libros libros = libroService.buscarLibro(id);
        Map<String, String> response = new HashMap<>();
        
        //revisar si el libro seleccionado existe
        if(libros != null){

            libroService.actualizarLibro(libro);
            response.put("message", "Libro actualizado con exito");
            return response;
        }else{    
            response.put("message", "El libro no existe");
            return response;
        }
    }



    //eliminar un libro
    @DeleteMapping("/eliminar_libro/{id}")
    public Map<String, String> eliminarLibro(@PathVariable Long id){
        
        Libros libros = libroService.buscarLibro(id);
        Map<String, String> response = new HashMap<>();
        
        //revisar si el libro seleccionado existe
        if(libros != null){

            libroService.eliminarLibro(id);
            response.put("message", "Libro eliminado con exito");
            return response;
        }else{    
            response.put("message", "El libro no existe");
            return response;
        }
    }
    
    
    
}
