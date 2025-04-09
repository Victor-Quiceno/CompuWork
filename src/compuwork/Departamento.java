package compuwork;

import java.util.ArrayList;

public class Departamento {

    private static int contador = 1;
    private Empresa empresa;
    private int codigo;
    private String nombre;

    //Se crea una ArrayList por la relación entre Departamento y empleado
    private ArrayList<Empleado> listaEmpleados;

    //getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

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
    public Departamento(Empresa empresa, String nombre) {
        this.codigo = contador++;
        this.empresa = empresa;
        this.nombre = nombre;
        listaEmpleados = new ArrayList<>();

    }

    //Método para agregar un empleado a un departamento
    public void agregarEmpleado(Empleado empleado) {
        if (empleado == null) {
            System.out.println("ERROR: El empleado no puede ser nulo.");
            return;
        }
        if (!listaEmpleados.contains(empleado)) {
            listaEmpleados.add(empleado);
            empleado.setDepartamento(this); // Se actualiza el departamento del empleado
            System.out.println("Empleado '" + empleado.getNombre() + "' agregado al departamento " + nombre);
        } else {
            System.out.println("ERROR: El empleado ya pertenece a este departamento.");
        }
    }

    //Método para reasignar un empleado a un departamento
    public boolean reasignarEmpleado(Empleado empleado, Departamento nuevoDepartamento) {
        if (empleado == null || nuevoDepartamento == null) {
            System.out.println("ERROR: El empleado o el departamento no pueden ser nulos.");
            return false;
        }

        if (!listaEmpleados.contains(empleado)) {
            System.out.println("ERROR: El empleado '" + empleado.getNombre() + "' no pertenece a este departamento.");
            return false;
        }

        // Remover del departamento actual
        listaEmpleados.remove(empleado);

        // Agregar al nuevo departamento
        nuevoDepartamento.agregarEmpleado(empleado);

        System.out.println("Empleado '" + empleado.getNombre() + "' fue reasignado a " + nuevoDepartamento.getNombre());
        return true;
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

    public void eliminarEmpleado(Empleado e) {
        listaEmpleados.remove(e);
    }

    @Override
    public String toString() {
        return this.nombre;
    }

}
