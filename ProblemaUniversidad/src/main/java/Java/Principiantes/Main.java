package Java.Principiantes;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Universidad universidad = new Universidad();
        String opciones[] = {"Agregar estudiante", "Mostrar estudiantes", "Editar notas del estudiante", "Salir"};
        boolean salida = false;
        while(!salida){
            int seleccion = JOptionPane.showOptionDialog(
                    null,
                    "Selecciona una opción:",
                    "Menú de Opciones",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0] // Opción predeterminada
            );
            switch(seleccion){
                case 0:
                    universidad.agregarEstudiante();
                    break;
                case 1:
                    universidad.mostrarEstudiantes();
                    break;
                case 2:
                    universidad.editarNotasEstudiante();
                    break;
                case 3:
                    salida = true;
                    break;
            }
        }
    }
}