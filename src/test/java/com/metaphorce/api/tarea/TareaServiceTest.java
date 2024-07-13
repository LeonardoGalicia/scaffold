package com.metaphorce.api.tarea;

import com.metaphorce.api.tarea.repository.TareaRepository;
import com.metaphorce.api.tarea.service.TareaService;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class TareaServiceTest {

    @InjectMocks
    TareaService tareaService;

    @Mock
    TareaRepository tareaRepository;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    
}
