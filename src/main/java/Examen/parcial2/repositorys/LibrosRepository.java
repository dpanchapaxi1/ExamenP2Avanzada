package Examen.parcial2.repositorys;


import org.springframework.data.jpa.repository.JpaRepository;
import Examen.parcial2.models.Libros;

import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface LibrosRepository extends JpaRepository<Libros, Long> {

    Optional<Libros> findById(Long id);

} 