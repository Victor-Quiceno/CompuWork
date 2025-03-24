package compuwork;

import java.util.ArrayList;

public class Departamento {

    private String nombre;

    //Se crea una ArrayList por la relación entre Departamento y empleado
    private ArrayList<Empleado> listaEmpleados;

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getListaEmpleados() {
        return listaEmpleados;
    }

    //Constructor
    public Departamento(String nombre, ArrayList<Empleado> listaEmpleados) {
        this.nombre = nombre;
        this.listaEmpleados = (listaEmpleados != null) ? listaEmpleados : new ArrayList<>();
    }

    //Método para agregar un empleado a un departamento
    public void agregarEmpleado(Empleado empleado) {
        try {
            if (empleado == null) {
                throw new IllegalArgumentException("El empleado no puede ser nulo.");
            }

            listaEmpleados.add(empleado);
            empleado.setDepartamento(this.nombre);
            System.out.println("Empleado: " + empleado.getNombre() + "\nAgregado a: " + this.nombre);

        } catch (IllegalArgumentException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    //Método para eliminar un empleado mediante el id
    public void eliminarEmpleado(int id) {

        Empleado empleadoEliminar = null;
        for (Empleado e : listaEmpleados) {

            if (e.getId() == id) {
                empleadoEliminar = e;
                break;
            }
        }

        if (empleadoEliminar != null) {

            listaEmpleados.remove(empleadoEliminar);
            System.out.println("Empleado eliminado: " + empleadoEliminar.getNombre());
        } else {
            System.out.println("ERROR: Empleado con id: " + id + " no encontrado. ");
        }

    }

    //Mostrar a qué departamento está asignado un empleado
    public void mostrarDepartamentoEmpleado(Empleado empleado) {
        if (empleado == null) {
            System.out.println("ERROR: El empleado no puede ser nulo.");
            return;
        }

        if (!listaEmpleados.contains(empleado)) {
            System.out.println("ERROR: " + empleado.getNombre() + " no pertenece a este departamento.");
            return;
        }

        System.out.println("El empleado " + empleado.getNombre().toUpperCase() + " está en el departamento "
                + this.nombre.toUpperCase());
    }

    // Modificar el nombre del departamento
    public void actualizarDepartamento(String nuevoNombre) {
        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
            System.out.println("ERROR: El nombre del departamento no puede estar vacío o nulo.");
            return;
        }
        this.nombre = nuevoNombre;
        System.out.println("Nombre del departamento actualizado a " + nuevoNombre);
    }

    // Mostrar todos los empleados del departamento
    public void listarEmpleados() {
        System.out.println("Empleados en el departamento " + nombre + ":");
        if (listaEmpleados.isEmpty()) {
            System.out.println("(No hay empleados en este departamento)");
        } else {
            for (Empleado emp : listaEmpleados) {
                System.out.println(emp);
            }
        }
    }

}
