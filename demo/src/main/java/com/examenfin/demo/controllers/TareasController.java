package com.examenfin.demo.controllers;

import com.examenfin.demo.entities.Tareas;
import com.examenfin.demo.services.TareasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
public class TareasController {

    private final TareasService tareasService;

    public TareasController(TareasService tareasService) {
        this.tareasService = tareasService;
    }

    /**
     * Obtener todas las tareas.
     * @return Lista de todas las tareas.
     */
    @GetMapping
    public ResponseEntity<List<Tareas>> getAll() {
        List<Tareas> tareasList = tareasService.findAll();
        return new ResponseEntity<>(tareasList, HttpStatus.OK);
    }

    /**
     * Obtener una tarea por su ID.
     * @param id ID de la tarea.
     * @return Tarea con el ID especificado.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Tareas> getById(@PathVariable Long id) {
        Tareas tarea = tareasService.findById(id);
        if (tarea != null) {
            return new ResponseEntity<>(tarea, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Actualizar una tarea existente.
     * @param id ID de la tarea a actualizar.
     * @param tareas Datos actualizados de la tarea.
     * @return Respuesta HTTP.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody Tareas tareas) {
        if (tareasService.findById(id) != null) {
            tareasService.update(id, tareas);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Eliminar una tarea por su ID.
     * @param id ID de la tarea a eliminar.
     * @return Respuesta HTTP.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (tareasService.findById(id) != null) {
            tareasService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}


