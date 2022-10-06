package edu.epidata.empresa.jpa;

import edu.epidata.empresa.entities.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {

    List<Departamento> findByNombre(String nombre);

}
