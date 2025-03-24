package compuwork;

public class Temporal extends Empleado {

    private double horasTrabajo;
    private String modalidadContrato;
    private String fechaInicio;
    private String fechaFin;
    private String supervisor;

    public Temporal(double horasTrabajo, String modalidadContrato, String fechaInicio, String fechaFin, String supervisor, int id, String nombre, String correoElectronico) {
        super(id, nombre, correoElectronico);
        this.horasTrabajo = horasTrabajo;
        this.modalidadContrato = modalidadContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.supervisor = supervisor;
    }

    public double getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(double horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public String getModalidadContrato() {
        return modalidadContrato;
    }

    public void setModalidadContrato(String modalidadContrato) {
        this.modalidadContrato = modalidadContrato;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    //Método para agregar nuevas horas a Temporal
    public void agregarHoras(double nuevasHoras) {

        if (nuevasHoras > 0) {
            horasTrabajo += nuevasHoras;

            System.out.println("Se han agregado " + nuevasHoras + " al empleado temporal " + getNombre().toUpperCase() + ".");

        } else {
            System.out.println("ERROR: Las horas ingresadas tienen que ser mayor a 0. ");
        }

    }

    //Sobreescribir el toString de Temporal para agregar sus atributos propios
    @Override
    public String toString() {
        return super.toString()
                + "TIPO: Temporal\n"
                + "Horas de trabajo: " + horasTrabajo + "\n"
                + "Modalidad de contrato: " + modalidadContrato + "\n"
                + "Fecha de inicio: " + fechaInicio + "\n"
                + "Fecha de fin: " + fechaFin + "\n"
                + "Supervisor: " + supervisor + "\n";
    }

}
