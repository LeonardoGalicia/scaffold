package com.metaphorce.api.tarea.service;

import com.metaphorce.api.tarea.model.Tarea;

import java.util.List;

public interface ITareaService {

    List<Tarea> listarTareas();

    Tarea buscarPorId(Long id);

    Tarea crearTarea(Tarea tarea);

    Tarea actualizarTarea(Long id, Tarea tarea);

    void eliminarTarea(Long id);
}
