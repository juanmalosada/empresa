package edu.epidata.empresa.jpa;

import edu.epidata.empresa.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

    List<Departamento> findByNombre(String nombre);
    List<Departamento> findByJefeId(Long id);
    List<Departamento> findByJefeNombre(String nombre);
    List<Departamento> findByJefeApellido(String apellido);

}
