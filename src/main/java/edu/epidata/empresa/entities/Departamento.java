package edu.epidata.empresa.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @OneToMany(mappedBy = "departamento")
    private List<Empleado> empleados;

    @ManyToOne
    @JoinColumn(name = "empleado_id")
    @JsonIgnoreProperties("departamentosACargo")
    private Empleado jefe;

    @ManyToOne
    @JoinColumn(name = "departamento_padre_id")
    private Departamento departamentoPadre;

    @OneToMany(mappedBy = "departamentoPadre")
    private List<Departamento> subDepartamentos;

    public Departamento() {
        super();
    }
    public Departamento(String nombre, List<Empleado> empleados, Empleado jefe, Departamento departamentoPadre, List<Departamento> subDepartamentos) {
        super();
        this.nombre = nombre;
        this.empleados = empleados;
        this.jefe = jefe;
        this.departamentoPadre = departamentoPadre;
        this.subDepartamentos = subDepartamentos;
    }

    public Departamento(String nombre, List<Empleado> empleados, Empleado jefe) {
        super();
        this.nombre = nombre;
        this.empleados = empleados;
        this.jefe = jefe;
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

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public Empleado getJefe() {
        return jefe;
    }

    public void setJefe(Empleado jefe) {
        this.jefe = jefe;
    }

    public Departamento getDepartamentoPadre() {
        return departamentoPadre;
    }

    public void setDepartamentoPadre(Departamento departamentoPadre) {
        this.departamentoPadre = departamentoPadre;
    }

    public List<Departamento> getSubDepartamentos() {
        return subDepartamentos;
    }

    public void setSubDepartamentos(List<Departamento> subDepartamentos) {
        this.subDepartamentos = subDepartamentos;
    }

}
