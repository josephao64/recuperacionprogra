package com.examenfin.demo.services;

import com.examenfin.demo.entities.Tareas;
import com.examenfin.demo.repositories.TareasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareasServiceImpl implements TareasService {

    private final TareasRepository repository;

    @Autowired
    public TareasServiceImpl(TareasRepository repository) {
        this.repository = repository;
    }

    /**
     * Obtener todas las tareas.
     * @return Lista de todas las tareas.
     */
    @Override
    public List<Tareas> findAll() {
        return repository.findAll();
    }

    /**
     * Obtener una tarea por su ID.
     * @param id ID de la tarea.
     * @return Tarea con el ID especificado o null si no existe.
     */
    @Override
    public Tareas findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    /**
     * Crear una nueva tarea.
     * @param tareas Datos de la nueva tarea.
     */
    @Override
    public void create(Tareas tareas) {
        repository.save(tareas);
    }

    /**
     * Actualizar una tarea existente.
     * @param id ID de la tarea a actualizar.
     * @param tareas Datos actualizados de la tarea.
     */
    @Override
    public void update(Long id, Tareas tareas) {
        if (repository.existsById(id)) {
            tareas.setId(id);
            repository.save(tareas);
        } else {

            throw new RuntimeException("Tarea no encontrada con ID: " + id);
        }
    }

    /**
     * Eliminar una tarea por su ID.
     * @param id ID de la tarea a eliminar.
     */
    @Override
    public void delete(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {

            throw new RuntimeException("Tarea no encontrada con ID: " + id);
        }
    }
}