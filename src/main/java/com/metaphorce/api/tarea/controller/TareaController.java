package com.metaphorce.api.tarea.controller;


import com.metaphorce.api.tarea.model.Tarea;
import com.metaphorce.api.tarea.service.ITareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api-tareas")
public class TareaController {
    @Autowired
    ITareaService serviceTarea;
    // TODO: Implement REST endpoints for CRUD operations

    @GetMapping("/tarea")
    public List<Tarea> listarTareas(){
        return serviceTarea.listarTareas();
    }

    @GetMapping("/tarea/{id}")
    public ResponseEntity<Tarea> buscarTarea(@PathVariable Long id){
        Tarea tarea = serviceTarea.buscarPorId(id);
        return ResponseEntity.ok(tarea);
    }

    @PostMapping("/tarea")
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea){
        Tarea tareaCreada = serviceTarea.crearTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(tareaCreada);
    }

    @PutMapping("/tarea/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea){
        Tarea tareaAActualizar = serviceTarea.buscarPorId(id);
        if (tareaAActualizar == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        tareaAActualizar.setTitle(tarea.getTitle());
        tareaAActualizar.setCompleted(tarea.isCompleted());

        Tarea tareaActualizada = serviceTarea.actualizarTarea(id, tareaAActualizar);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/tarea/{id}")
    public ResponseEntity<Tarea> eliminarTarea(@PathVariable Long id){
        serviceTarea.eliminarTarea(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
