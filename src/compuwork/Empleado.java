package compuwork;

public class Empleado {

    private int id;
    private String nombre;
    private String correoElectronico;
    private String departamento;

    public Empleado(int id, String nombre, String correoElectronico) {
        this.id = id;
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }

    //getters y setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    //Método para actualizar los datos de empleado
    public void actualizarEmpleado(int id, String nombre, String correoElectronico) {

        try {

            this.id = id;

            if (!nombre.isEmpty() && !correoElectronico.isEmpty()) {
                this.nombre = nombre;
                this.correoElectronico = correoElectronico;
            }
            System.out.println("Empleado actualizado con éxito.");
        } catch (Exception e) {
            System.out.println("ERROR: Revise que los datos ingresados para actualizar el empleado sean válidos.");
        }

    }

    //Método para  calcular el desempeño de un empleado con una simulación
    public void generarReporteDesempeno() {

        int productividad = (int) (Math.random() * 100);
        int asistencia = (int) (Math.random() * 100);

        System.out.println("REPORTE DE DESEMPEÑO DE " + this.nombre.toUpperCase());
        System.out.println("- Productividad: " + productividad + "%");
        System.out.println("- Asistencia: " + asistencia + "%");
        System.out.println("- Evaluación general: " + ((productividad + asistencia) / 2) + "%");
    }

    //método toString para mostrar la información del empleado
    @Override
    public String toString() {
        return "EMPLEADO[ " + "\n"
                + "Id: " + id + "\n"
                + "Nombre: " + nombre + "\n"
                + "Correo electrónico: " + correoElectronico + "\n"
                + "Departamento: " + departamento + "\n";
    }

}
