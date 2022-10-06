package edu.epidata.empresa.jpa;

import edu.epidata.empresa.entities.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    List<Empleado> findByDepartamentoId(Long id);
    List<Empleado> findByNombre(String nombre);
    List<Empleado> findByApellido(String apellido);
    List<Empleado> findByDni(String dni);
    List<Empleado> findByGenero(String genero);
    List<Empleado> findByDepartamentoIdAndNombre(Long id, String nombre);
    List<Empleado> findByDepartamentoIdAndApellido(Long id, String apellido);

}
