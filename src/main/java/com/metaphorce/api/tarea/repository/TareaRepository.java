package com.metaphorce.api.tarea.repository;

import com.metaphorce.api.tarea.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea,Long> {


}
