package edu.epidata.empresa.controllers;

import edu.epidata.empresa.entities.Empleado;
import edu.epidata.empresa.service.EmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService) {
        this.empleadoService = empleadoService;
    }

    @GetMapping
    public List<Empleado> getEmpleados() {
        return empleadoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Empleado> getEmpleado(@PathVariable(value="id")Integer id) {
        Optional<Empleado> empleado = empleadoService.findById(id);
        if (empleado.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(empleado.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Empleado> createEmpleado(@RequestBody Empleado empleado) {
        return new ResponseEntity<>(empleadoService.save(empleado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Empleado> updateEmpleado(@PathVariable(value="id")Integer id, @RequestBody Empleado empleado) {
        Optional<Empleado> empleadoOptional = empleadoService.findById(id);
        if (empleadoOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(empleadoService.update(id, empleado), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Empleado> deleteEmpleado(@PathVariable(value="id")Integer id) {
        try {
            empleadoService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}
