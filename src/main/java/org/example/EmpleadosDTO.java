package org.example;

import java.util.ArrayList;

public class EmpleadosDTO {

    private int id;

    private String nombre;

    private int edad;

    private int id_departamento;

    public EmpleadosDTO() {}

    public EmpleadosDTO(int id, String nombre, int edad, int id_departamento) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.id_departamento = id_departamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    @Override
    public String toString() {
        return "EmpleadosDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", id_departamento=" + id_departamento +
                '}';
    }
}
