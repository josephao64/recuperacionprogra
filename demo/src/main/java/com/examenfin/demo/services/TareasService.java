package com.examenfin.demo.services;

import com.examenfin.demo.entities.Tareas;

import java.util.List;

public interface TareasService {
    public List<Tareas> findAll();
    public Tareas findById(Long id);
    public void create(Tareas tareas);
    public void update(Long id, Tareas tareas);
    public void delete(Long id);
}
