package compuwork;

public class Permanente extends Empleado {

    private double sueldo;
    private String fechaIngreso;
    private String cargo;

    // Constructor
    public Permanente(double sueldo, String fechaIngreso, String cargo, int id, String nombre, String correoElectronico) {
        super(id, nombre, correoElectronico);
        this.sueldo = sueldo;
        this.fechaIngreso = fechaIngreso;
        this.cargo = cargo;
    }
    
    

    //getters y setters
    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        if (sueldo > 0) {
            this.sueldo = sueldo;
        } else {
            System.out.println("ERROR: El sueldo debe ser mayor a 0.");
        }
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    //Validamos que cuando se ingrese la fecha de ingreso siga el formato dd/mm/yyyy
    public void setFechaIngreso(String fechaIngreso) {
        if (fechaIngreso.matches("\\d{2}/\\d{2}/\\d{4}")) {
            this.fechaIngreso = fechaIngreso;
        } else {
            System.out.println("ERROR: La fecha debe estar en formato dd/mm/yyyy.");
        }
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if (cargo != null && !cargo.trim().isEmpty()) {
            this.cargo = cargo;
        } else {
            System.out.println("ERROR: El cargo no puede estar vacío.");
        }
    }

    // Método para actualizar el sueldo
    public void actualizarSueldo(double nuevoSueldo) {

        setSueldo(nuevoSueldo);
        System.out.println("El nuevo sueldo del empleado " + getNombre().toUpperCase() + " es: " + nuevoSueldo);

    }

    // Método para asignar un nuevo cargo
    public void asignarCargo(String nuevoCargo) {
        if (nuevoCargo != null && !nuevoCargo.trim().isEmpty()) {
            this.cargo = nuevoCargo;
            System.out.println("Empleado: " + getNombre() + " ha sido asignado al cargo de: " + nuevoCargo);
        } else {
            System.out.println("ERROR: El cargo no puede estar vacío.");
        }
    }

    //Sobreeescritura de toString de permanente para visualizar sus datos
    @Override
    public String toString() {
        return super.toString()
                + "TIPO: Permanente\n"
                + "Sueldo: " + sueldo + "\n"
                + "Fecha de ingreso: " + fechaIngreso + "\n"
                + "Cargo: " + cargo + "\n";
    }

}
