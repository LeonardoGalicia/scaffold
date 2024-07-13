package com.metaphorce.api.tarea;

import com.metaphorce.api.tarea.model.Tarea;
import com.metaphorce.api.tarea.repository.TareaRepository;
import com.metaphorce.api.tarea.service.TareaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

public class TareaServiceTest {

    @InjectMocks
    TareaService tareaService;

    @Mock
    TareaRepository tareaRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testListarTareas(){
        List<Tarea> listaEsperada = new ArrayList<>();
        listaEsperada.add(new Tarea(1L, "Tarea1", true));
        listaEsperada.add(new Tarea(2L, "Tarea2", false));

        when(tareaRepository.findAll()).thenReturn(listaEsperada);
        List<Tarea> listaActual = tareaService.listarTareas();

        Assertions.assertEquals(listaEsperada.get(0).getTitle(), listaActual.get(0).getTitle());
        Assertions.assertEquals(listaEsperada.size(), listaActual.size());
    }

    @Test
    public void buscarTarea(){
        Tarea tareaEsperada = new Tarea(1L, "Tarea1", true);

        when(tareaRepository.findById(1L)).thenReturn(Optional.of(tareaEsperada));

        Tarea tareaActual = tareaService.buscarPorId(1L);

        Assertions.assertEquals(tareaEsperada, tareaEsperada);
    }
}
