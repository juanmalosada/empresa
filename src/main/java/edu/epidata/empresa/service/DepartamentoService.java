package edu.epidata.empresa.service;

import edu.epidata.empresa.entities.Departamento;
import edu.epidata.empresa.jpa.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public List<Departamento> findAll() {
        return departamentoRepository.findAll();
    }

    public Optional<Departamento> findById(Integer id) {
        return departamentoRepository.findById(id);
    }

    public Departamento save(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public void deleteById(Integer id) {
        departamentoRepository.deleteById(id);
    }

    public List<Departamento> findByNombre(String nombre) {
        return departamentoRepository.findByNombre(nombre);
    }

    public void deleteAll() {
        departamentoRepository.deleteAll();
    }

    public void delete(Departamento departamento) {
        departamentoRepository.delete(departamento);
    }

    public Departamento update(Integer id, Departamento departamento) {
        Departamento departamentoActual = findById(id).get();
        departamentoActual.setNombre(departamento.getNombre());
        departamentoActual.setEmpleados(departamento.getEmpleados());
        departamentoActual.setJefe(departamento.getJefe());
        departamentoActual.setDepartamentoPadre(departamento.getDepartamentoPadre());
        departamentoActual.setSubDepartamentos(departamento.getSubDepartamentos());
        return departamentoRepository.save(departamentoActual);
    }



}
