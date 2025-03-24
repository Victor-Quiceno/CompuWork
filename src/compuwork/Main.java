package compuwork;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //PRUEBAS DE USO PARA EL PROYECTO
        // Crear departamentos
        Departamento departamentoTI = new Departamento("Tecnología", new ArrayList<>());
        Departamento departamentoRH = new Departamento("Recursos Humanos", new ArrayList<>());
        Departamento departamentoVentas = new Departamento("Ventas", new ArrayList<>());

        // Crear empleados permanentes
        Permanente empleado1 = new Permanente(3000, "01/02/2020", "Ingeniero de Software", 1, "Carlos Pérez", "carlos@compuwork.com");
        Permanente empleado2 = new Permanente(2800, "15/06/2019", "Analista de Datos", 2, "Ana Torres", "ana@compuwork.com");
        Permanente empleado3 = new Permanente(3500, "23/09/2021", "Gerente de Proyecto", 3, "Javier Gómez", "javier@compuwork.com");

        // Crear empleados temporales
        Temporal empleado4 = new Temporal(40, "Obra Labor", "01/03/2025", "30/06/2025", "María López", 4, "Laura Gómez", "laura@compuwork.com");
        Temporal empleado5 = new Temporal(30, "Prestación de servicios", "05/04/2025", "05/10/2025", "Carlos Ramírez", 5, "Sofía Herrera", "sofia@compuwork.com");
        Temporal empleado6 = new Temporal(35, "Prestación de servicios", "10/05/2025", "10/11/2025", "Elena Castro", 6, "David Ríos", "david@compuwork.com");

        // Asignar empleados a departamentos
        departamentoTI.agregarEmpleado(empleado1);
        departamentoTI.agregarEmpleado(empleado2);
        departamentoRH.agregarEmpleado(empleado3);
        departamentoRH.agregarEmpleado(empleado4);
        departamentoVentas.agregarEmpleado(empleado5);
        departamentoVentas.agregarEmpleado(empleado6);

        // Mostrar empleados de cada departamento
        System.out.println("\n--- LISTADO DE EMPLEADOS POR DEPARTAMENTO ---");
        departamentoTI.listarEmpleados();
        departamentoRH.listarEmpleados();
        departamentoVentas.listarEmpleados();

        // Mostrar departamento de un empleado
        System.out.println("\n--- DEPARTAMENTO DE UN EMPLEADO ---");
        departamentoTI.mostrarDepartamentoEmpleado(empleado1);
        departamentoRH.mostrarDepartamentoEmpleado(empleado4);
        departamentoVentas.mostrarDepartamentoEmpleado(empleado5);

        // Modificar nombre del departamento
        System.out.println("\n--- ACTUALIZAR NOMBRE DEL DEPARTAMENTO ---");
        departamentoTI.actualizarDepartamento("Departamento de TI");

        // Eliminar un empleado
        System.out.println("\n--- ELIMINACIÓN DE EMPLEADO ---");
        departamentoVentas.eliminarEmpleado(5);
        departamentoVentas.listarEmpleados();

        // Generar reportes de desempeño
        System.out.println("\n--- GENERACIÓN DE REPORTES DE DESEMPEÑO ---");
        ReporteDesempeno reporte = new ReporteDesempeno();
        reporte.generarReporteEmpleado(empleado1);
        reporte.generarReporteEmpleado(empleado3);
        reporte.generarReporteDepartamento(departamentoTI);
    }
}
