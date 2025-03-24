package compuwork;

import java.util.ArrayList;

public class ReporteDesempeno {

    // Método para generar un reporte de desempeño individual de un único empleado
    public void generarReporteEmpleado(Empleado empleado) {
        if (empleado == null) {
            System.out.println("ERROR: El empleado no puede ser nulo.");
            return;
        }

        // Simulación de métricas de desempeño con valores aleatorios entre 0 y 100
        int productividad = (int) (Math.random() * 100);
        int asistencia = (int) (Math.random() * 100);
        int evaluacionGeneral = (productividad + asistencia) / 2; // Promedio de métricas

        // Moatramos la información de forma estructurada
        System.out.println("===== REPORTE DE DESEMPEÑO =====");
        System.out.println("ID: " + empleado.getId());
        System.out.println("Empleado: " + empleado.getNombre().toUpperCase());
        System.out.println("Departamento: " + empleado.getDepartamento());
        System.out.println("- Productividad: " + productividad + "%");
        System.out.println("- Asistencia: " + asistencia + "%");
        System.out.println("- Evaluación General: " + evaluacionGeneral + "%");
        System.out.println("================================");
    }

    // Método para generar un reporte de desempeño de todos los empleados de un departamento
    public void generarReporteDepartamento(Departamento departamento) {
        if (departamento == null) {
            System.out.println("ERROR: El departamento no puede ser nulo.");
            return;
        }

        // Se obtiene la lista de empleados del departamento
        ArrayList<Empleado> empleados = departamento.getListaEmpleados();
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados en el departamento de " + departamento.getNombre());
            return;
        }

        // Variables para almacenar las sumas de productividad y asistencia de todos los empleados
        int sumaProductividad = 0;
        int sumaAsistencia = 0;
        int totalEmpleados = empleados.size(); // Número total de empleados en el departamento

        System.out.println("===== REPORTE DE DESEMPEÑO DEL DEPARTAMENTO =====");
        System.out.println("Departamento: " + departamento.getNombre());
        System.out.println("Número de empleados: " + totalEmpleados);
        System.out.println("------------------------------------------------");

        // Se recorre la lista de empleados para calcular su desempeño individual
        for (Empleado e : empleados) {
            int productividad = (int) (Math.random() * 100); // Simulación de productividad
            int asistencia = (int) (Math.random() * 100); // Simulación de asistencia
            int evaluacionGeneral = (productividad + asistencia) / 2; // Promedio individual

            // Mostramos el reporte de cada empleado dentro del departamento
            System.out.println("ID: " + e.getId() + " | Empleado: " + e.getNombre().toUpperCase());
            System.out.println("- Productividad: " + productividad + "%");
            System.out.println("- Asistencia: " + asistencia + "%");
            System.out.println("- Evaluación General: " + evaluacionGeneral + "%");
            System.out.println("------------------------------------------------");

            // Se suman las métricas para calcular los promedios del departamento
            sumaProductividad += productividad;
            sumaAsistencia += asistencia;
        }

        // Cálculo de los promedios de desempeño del departamento
        int promedioProductividad = sumaProductividad / totalEmpleados;
        int promedioAsistencia = sumaAsistencia / totalEmpleados;
        int promedioGeneral = (promedioProductividad + promedioAsistencia) / 2;

        // Se muestran los resultados finales del departamento seleccionado
        System.out.println("PROMEDIOS DEL DEPARTAMENTO:");
        System.out.println("- Productividad: " + promedioProductividad + "%");
        System.out.println("- Asistencia: " + promedioAsistencia + "%");
        System.out.println("- Evaluación General: " + promedioGeneral + "%");
        System.out.println("=================================================");
    }
}
