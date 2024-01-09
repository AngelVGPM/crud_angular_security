package com.gestion.empleados.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gestion.empleados.modelo.Empleado;
//Esta interfaz extiende JpaRepository, proporcionando operaciones CRUD 
@Repository
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Long>{

/* El primer parámetro (Empleado) es el tipo de entidad con la que trabajará el repositorio.
    El segundo parámetro (Long) es el tipo del identificador único de la entidad Empleado.*/

}
