package edu.epidata.empresa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String dni;

    private String genero;

    @ManyToOne
    @JoinColumn(name = "departamento_id")
    @JsonIgnoreProperties("empleados")
    private Departamento departamento;

    @OneToMany(mappedBy = "jefe")
    private List<Departamento> departamentosACargo;

    public Empleado() {
        super();
    }

    public Empleado(String nombre, String apellido, String dni, String genero, Departamento departamento, List<Departamento> departamentosACargo) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.genero = genero;
        this.departamento = departamento;
        this.departamentosACargo = departamentosACargo;
    }

    public Empleado(String nombre, String apellido, String dni, String genero, Departamento departamento) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.genero = genero;
        this.departamento = departamento;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getDepartamentosACargo() {
        return departamentosACargo;
    }

    public void setDepartamentosACargo(List<Departamento> departamentosACargo) {
        this.departamentosACargo = departamentosACargo;
    }

}
