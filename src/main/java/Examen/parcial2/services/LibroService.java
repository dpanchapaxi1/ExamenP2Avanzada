package Examen.parcial2.services;

import org.springframework.stereotype.Service;


import Examen.parcial2.repositorys.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import Examen.parcial2.models.Libros;

@Service
public class LibroService {

    @Autowired
    private LibrosRepository librosRepository;

    //Guardar un libro
    public Libros guardarLibro(Libros libro) {
        return librosRepository.save(libro);
    }

    //Buscar un libro por id
    public Libros buscarLibro(Long id) {
        return librosRepository.findById(id).orElse(null);
    }

    //Eliminar un libro
    public void eliminarLibro(Long id) {
        librosRepository.deleteById(id);
    }

    //Actualizar un libro
    public Libros actualizarLibro(Libros libro) {
        return librosRepository.save(libro);
    }

    //Listar todos los libros
    public Iterable<Libros> listarLibros() {
        return librosRepository.findAll();
    }
      


    
}
