package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class Consola {

    static Scanner teclado= new Scanner(System.in);
    static EmpleadosDAO empleadosDAO;
    static DepartamentoDAO departamentoDAO;
    public static void main(String[] args) throws SQLException {
        teclado= new Scanner(System.in);

        int p;
        String nombre;
        System.out.println("menu");
        System.out.println("1 empleados");
        System.out.println("2 departamentos");
        p = teclado.nextInt();

        switch (p) {
            case 1:
                empleados();
                break;
            case 2:
                departamentos();
                break;
        }
    }

    public static void empleados() throws SQLException {
        int p, id, edad, id_departamento;
        String nombre;

        empleadosDAO = new EmpleadosDAO();

        System.out.println("menu");
        System.out.println("1 Select All");
        System.out.println("2 Select By Id");
        System.out.println("3 Insert");
        System.out.println("4 Update");
        System.out.println("5 Delete");
        System.out.println("6 Delete All");
        p = teclado.nextInt();

        switch (p) {
            case 1:
                System.out.println(empleadosDAO.getListaEmpleados());
                break;
            case 2:
                System.out.println("Indique el id");
                id = teclado.nextInt();
                System.out.println(empleadosDAO.getEmpleadosById(id));
                break;
            case 3:
                System.out.println("indique el id:");
                id = teclado.nextInt();
                System.out.println("indique el nombre:");
                nombre = teclado.next();
                System.out.println("Indique la edad:");
                edad = teclado.nextInt();
                System.out.println("Indique el departamento:");
                id_departamento = teclado.nextInt();
                EmpleadosDTO empleado = new EmpleadosDTO(id, nombre, edad, id_departamento);
                System.out.println(empleadosDAO.addEmpleados(empleado));
                break;
            case 4:
                System.out.println("indique el id:");
                id = teclado.nextInt();
                System.out.println("indique el nombre:");
                nombre = teclado.next();
                System.out.println("Indique la edad:");
                edad = teclado.nextInt();
                System.out.println("Indique el departamento:");
                id_departamento = teclado.nextInt();
                EmpleadosDTO empleado1 = new EmpleadosDTO(id, nombre, edad, id_departamento);
                System.out.println(empleadosDAO.updateEmpleados(empleado1));
                break;
            case 5:
                System.out.println("Indique el id");
                id = teclado.nextInt();
                System.out.println(empleadosDAO.deleteEmpleados(id));
                break;
            case 6:
                System.out.println(empleadosDAO.deleteAll());
                break;
        }
    }

    public static void departamentos() throws SQLException {
        int p, id;
        String nombre;

        departamentoDAO = new DepartamentoDAO();

        System.out.println("menu");
        System.out.println("1 Select All");
        System.out.println("2 Select By Id");
        System.out.println("3 Insert");
        System.out.println("4 Update");
        System.out.println("5 Delete");
        System.out.println("6 Delete All");
        p = teclado.nextInt();

        switch (p) {
            case 1:
                System.out.println(departamentoDAO.getListaDepartamentos());
                break;
            case 2:
                System.out.println("Indique el id");
                id = teclado.nextInt();
                System.out.println(departamentoDAO.getDepartamentoById(id));
                break;
            case 3:
                System.out.println("indique el id:");
                id = teclado.nextInt();
                System.out.println("indique el nombre:");
                nombre = teclado.next();
                DepartamentoDTO departamento = new DepartamentoDTO(id, nombre);
                System.out.println(departamentoDAO.addDepartamento(departamento));
                break;
            case 4:
                System.out.println("indique el id:");
                id = teclado.nextInt();
                System.out.println("indique el nombre:");
                nombre = teclado.next();
                DepartamentoDTO departamento1 = new DepartamentoDTO(id, nombre);
                System.out.println(departamentoDAO.updateDepartamento(departamento1));
                break;
            case 5:
                System.out.println("Indique el id");
                id = teclado.nextInt();
                System.out.println(departamentoDAO.deleteDepartamento(id));
                break;
            case 6:
                System.out.println(departamentoDAO.deleteAll());
                break;
        }
    }
}

