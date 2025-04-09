package compuwork;

import compuwork.CapaPresentacion.VentanaPrincipal;
import compuwork.CapaPresentacion.iniciarSesion;
import java.util.ArrayList;

public class Empresa {

    private String nombre;
    private Administrador admin;
    //private ArrayList<Departamento> Departamentos;
    public static ArrayList<Departamento> Departamentos = new ArrayList<>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAdmin(Administrador admin) {
        this.admin = admin;
    }

    public static ArrayList<Departamento> getDepartamentos() {
        return Departamentos;
    }

    //Constructor
    public Empresa(String nombre) {
        this.nombre = nombre;
        this.Departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Departamento departamento) {
        Departamentos.add(departamento);
    }

    public void eliminarDepartamento(String nombreDepartamento) {
        Departamentos.removeIf(depto -> depto.getNombre().equals(nombreDepartamento));
    }

    public void mostrarDepartamentos() {
        System.out.println("DEPARTAMENTOS EN " + nombre.toUpperCase() + ": ");
        for (Departamento depto : Departamentos) {
            System.out.println("- " + depto.getNombre());
            depto.listarEmpleados();
        }
    }

    // Modificar el nombre del departamento
    public boolean modificarNombreDepartamento(String nombreActual, String nuevoNombre) {
        if (nuevoNombre == null || nuevoNombre.trim().isEmpty()) {
            System.out.println("ERROR: El nuevo nombre del departamento no puede estar vacío o nulo.");
            return false;
        }

        for (Departamento depto : Departamentos) {
            if (depto.getNombre().equals(nombreActual)) {
                depto.setNombre(nuevoNombre);
                System.out.println("Departamento '" + nombreActual + "' actualizado a '" + nuevoNombre + "'.");
                return true;
            }
        }

        System.out.println("ERROR: No se encontró un departamento con el nombre '" + nombreActual + "'.");
        return false;
    }

    //Método para iniciar sesión
    public boolean iniciarSesion(String user, String password) {
        return user.equals(this.admin.getUsername()) && password.equals(this.admin.getPassword());
    }

    public static void main(String[] args) {

        Empresa empresa = new Empresa("CompuWork");
        Administrador admin = new Administrador("admin123", "123");
        empresa.setAdmin(admin);
        VentanaPrincipal ventana = new VentanaPrincipal(empresa);
        iniciarSesion sesion = new iniciarSesion(ventana, true, empresa, ventana);
        sesion.setVisible(true);
    }

    public ArrayList<Empleado> getTodosLosEmpleados() {
        ArrayList<Empleado> todos = new ArrayList<>();
        for (Departamento d : Departamentos) {
            todos.addAll(d.getListaEmpleados()); // esto depende de que Departamento tenga getListaEmpleados()
        }
        return todos;
    }

    public Departamento buscarDepartamentoPorNombre(String nombre) {
        for (Departamento dep : Departamentos) {
            if (dep.getNombre().equals(nombre)) {
                return dep;
            }
        }
        return null;
    }

    public Empleado buscarEmpleadoPorId(int id) {
        for (Departamento d : Departamentos) {
            for (Empleado e : d.getListaEmpleados()) {
                if (e.getId() == id) {
                    return e;
                }
            }
        }
        return null;
    }

}
