package com.examenfin.demo.repositories;

import com.examenfin.demo.entities.Tareas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareasRepository extends JpaRepository<Tareas, Long> {


    List<Tareas> findByEstado(String estado);
}
