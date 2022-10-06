package edu.epidata.empresa.controllers;

import edu.epidata.empresa.entities.Departamento;
import edu.epidata.empresa.service.DepartamentoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;

    public DepartamentoController(DepartamentoService departamentoService) {
        this.departamentoService = departamentoService;
    }

    @GetMapping
    public List<Departamento> getDepartamentos() {
        return departamentoService.findAll();
    }
    @PostMapping("/{id}")
    public ResponseEntity<Departamento> createDepartamento(@PathVariable(value="id")Integer id) {
        Optional<Departamento> departamento = departamentoService.findById(id);
        if (departamento.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departamento.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Departamento> createDepartamento(@RequestBody Departamento departamento) {
        return new ResponseEntity<>(departamentoService.save(departamento), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Departamento> updateDepartamento(@PathVariable(value="id")Integer id, @RequestBody Departamento departamento) {
        Optional<Departamento> departamentoOptional = departamentoService.findById(id);
        if (departamentoOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(departamentoService.update(id, departamento), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Departamento> deleteDepartamento(@PathVariable(value="id")Integer id) {
        try {
            departamentoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
