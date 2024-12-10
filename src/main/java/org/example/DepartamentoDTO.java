package org.example;

import java.util.ArrayList;

public class DepartamentoDTO {

    private int id;
    private String nombre;
    private ArrayList<EmpleadosDTO> listaEmpleados;

    public DepartamentoDTO() {}
    public DepartamentoDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public ArrayList<EmpleadosDTO> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(ArrayList<EmpleadosDTO> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

    @Override
    public String toString() {
        return "DepartamentoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", listaEmpleados=" + listaEmpleados +
                '}';
    }
}
