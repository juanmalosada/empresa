package edu.epidata.empresa.service;

import edu.epidata.empresa.entities.Empleado;
import edu.epidata.empresa.jpa.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    public Optional<Empleado> findById(Long id) {
        return empleadoRepository.findById(id);
    }

    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public void deleteById(Long id) {
        empleadoRepository.deleteById(id);
    }

    public List<Empleado> findByNombre(String nombre) {
        return empleadoRepository.findByNombre(nombre);
    }

    public void deleteAll() {
        empleadoRepository.deleteAll();
    }

    public void delete(Empleado empleado) {
        empleadoRepository.delete(empleado);
    }

    public Empleado update(Long id, Empleado empleado) {
        Empleado empleadoActual = findById(id).get();
        empleadoActual.setNombre(empleado.getNombre());
        empleadoActual.setApellido(empleado.getApellido());
        empleadoActual.setDni(empleado.getDni());
        empleadoActual.setGenero(empleado.getGenero());
        empleadoActual.setDepartamento(empleado.getDepartamento());
        empleadoActual.setDepartamentosACargo(empleado.getDepartamentosACargo());
        return empleadoRepository.save(empleadoActual);
    }


}
