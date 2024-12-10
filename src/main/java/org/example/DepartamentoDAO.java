package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartamentoDAO {
    Connection conexion;
    DepartamentoDTO departamentoDTO;

    ArrayList<DepartamentoDTO> listaDepartamentos;

    ArrayList<EmpleadosDTO> listaEmpleados;

    EmpleadosDAO empleadosDAO = new EmpleadosDAO();

    public DepartamentoDAO() throws SQLException {
        conexion = Conexion.getConexion();
    }

    public ArrayList<DepartamentoDTO> getListaDepartamentos() throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM departamento");

        ResultSet resultado = sentencia.executeQuery();
        listaDepartamentos = new ArrayList<>();
        while (resultado.next()) {
            listaEmpleados = new ArrayList<>();
            int id = resultado.getInt(1);
            String nombre = resultado.getString(2);
            departamentoDTO = new DepartamentoDTO(id, nombre);
            listaEmpleados = empleadosDAO.getListaEmpleadosByDepartamento(id);
            departamentoDTO.setListaEmpleados(listaEmpleados);
            listaDepartamentos.add(departamentoDTO);
        }
        return listaDepartamentos;
    }

    public DepartamentoDTO getDepartamentoById(int id) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("SELECT * FROM departamento WHERE id = ?");
        sentencia.setInt(1, id);
        ResultSet resultado = sentencia.executeQuery();
        listaDepartamentos = new ArrayList<>();
        if (resultado.next()) {
            departamentoDTO = new DepartamentoDTO(id, resultado.getString(2));
            listaEmpleados = empleadosDAO.getListaEmpleadosByDepartamento(id);
            departamentoDTO.setListaEmpleados(listaEmpleados);
            return departamentoDTO;
        } else {
            return null;
        }
    }

    public int addDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("insert into departamento(id, nombre) values (?, ?)");
        sentencia.setInt(1, departamentoDTO.getId());
        sentencia.setString(2, departamentoDTO.getNombre());
        return sentencia.executeUpdate();
    }

    public int updateDepartamento(DepartamentoDTO departamentoDTO) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("update into departamento set nombre = ? where id = ?");
        sentencia.setInt(2, departamentoDTO.getId());
        sentencia.setString(1, departamentoDTO.getNombre());
        return sentencia.executeUpdate();
    }

    public int deleteDepartamento(int id) throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("delete from departamento where id = ?");
        sentencia.setInt(1, id);
        return sentencia.executeUpdate();
    }

    public int deleteAll() throws SQLException {
        PreparedStatement sentencia = conexion.prepareStatement("delete from departamento");
        return sentencia.executeUpdate();
    }
}