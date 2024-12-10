package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmpleadosDAO {
    Connection conexion;
    EmpleadosDTO empleados;
    ArrayList<EmpleadosDTO> listaEmpleados;

    public EmpleadosDAO() throws SQLException {
        conexion = Conexion.getConexion();
    }

    public ArrayList<EmpleadosDTO> getListaEmpleados() throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM empleados");

        ResultSet resultado = sentencia.executeQuery();
        listaEmpleados = new ArrayList<>();
        while (resultado.next()) {
            int id = resultado.getInt(1);
            String nombre = resultado.getString(2);
            int edad = resultado.getInt(3);
            int id_departamento = resultado.getInt(4);
            empleados = new EmpleadosDTO(id, nombre, edad, id_departamento);
            listaEmpleados.add(empleados);
        }
        return listaEmpleados;
    }

    public ArrayList<EmpleadosDTO> getListaEmpleadosByDepartamento(int id) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM empleados where id_departamento=?");
        sentencia.setInt(1, id);

        ResultSet resultado = sentencia.executeQuery();
        listaEmpleados = new ArrayList<>();
        while (resultado.next()) {
            int id1 = resultado.getInt(1);
            String nombre = resultado.getString(2);
            int edad = resultado.getInt(3);
            int id_departamento = resultado.getInt(4);
            empleados = new EmpleadosDTO(id1, nombre, edad, id_departamento);
            listaEmpleados.add(empleados);
        }
        return listaEmpleados;
    }

    public EmpleadosDTO getEmpleadosById(int id) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM empleados WHERE id = ?");
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        String nombre = resultado.getString(2);
        int edad = resultado.getInt(3);
        int id_departamento = resultado.getInt(4);
        if (resultado.next()) {
            empleados = new EmpleadosDTO(id, nombre, edad, id_departamento);
            return empleados;
        } else {
            return null;
        }
    }

    public int addEmpleados(EmpleadosDTO empleadosDTO) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("insert into empleados(id, nombre, edad, id_departamento) values (?, ?, ?, ?)");
        sentencia.setInt(1, empleadosDTO.getId());
        sentencia.setString(2, empleadosDTO.getNombre());
        sentencia.setInt(3, empleadosDTO.getEdad());
        sentencia.setInt(4, empleadosDTO.getId_departamento());
        return sentencia.executeUpdate();
    }

    public int updateEmpleados(EmpleadosDTO empleadosDTO) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("update into empleados set nombre = ?, edad = ?, id_departamento = ? where id = ?");
        sentencia.setInt(4, empleadosDTO.getId());
        sentencia.setString(1, empleadosDTO.getNombre());
        sentencia.setInt(2, empleadosDTO.getEdad());
        sentencia.setInt(3, empleadosDTO.getId_departamento());
        return sentencia.executeUpdate();
    }

    public int deleteEmpleados(int id) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("delete from empleados where id = ?");
        sentencia.setInt(1, id);
        return sentencia.executeUpdate();
    }

    public int deleteAll() throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("delete from empleados");
        return sentencia.executeUpdate();
    }
}
