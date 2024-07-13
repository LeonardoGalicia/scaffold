package com.metaphorce.api.tarea.service;

import com.metaphorce.api.tarea.model.Tarea;
import com.metaphorce.api.tarea.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService implements ITareaService {
    @Autowired
    private TareaRepository tareaRepository;

    @Override
    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    @Override
    public Tarea buscarPorId(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    @Override
    public Tarea crearTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public Tarea actualizarTarea(Long id, Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @Override
    public void eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
    }

    // TODO: Implement methods for CRUD operations
}
