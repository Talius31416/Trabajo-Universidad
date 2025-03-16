package Java.Principiantes;

import javax.swing.*;
import java.awt.*;

public class Universidad {
    private Estudiante[] estudiantes = new Estudiante[50];
    private int contador = 0;
    public void agregarEstudiante() {
        String nombre = ingresarTexto("Ingrese el nombre del estudiante: ");
        String identificacion = ingresarTexto("Ingrese la identificacion del estudiante: ");
        Nota[] notas = new Nota[5];
        for (int i = 0; i < 5; i++) {
            notas[i] = new Nota();
            notas[i].setNombre(ingresarTexto("Ingese el nombre de la nota: "));
            notas[i].setNota(ingresarFloat("Ingrese el nota del estudiante: "));
        }
        estudiantes[contador] = new Estudiante(nombre, identificacion, notas);
        contador++;
    }
    public void mostrarEstudiantes() {
        if(estudiantes[0] == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
            return;
        }
        Estudiante[] estudiantesMostrar = new Estudiante[estudiantes.length];
        for(int i = 0; i < estudiantes.length; i++) {
            if(estudiantes[i] != null) {
                estudiantesMostrar[i] = estudiantes[i];
            }
        }
        String mensajeAMostrar = "";
        for (int i = 0; i < estudiantesMostrar.length; i++) {
            if(estudiantes[i] != null) {
                mensajeAMostrar += estudiantesMostrar[i].estudiantesToString() + "\n" + "Promedio: " + calcularmedia(estudiantesMostrar[i]);
            }
        }
        JTextArea textArea = new JTextArea(mensajeAMostrar);
        textArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(300, 200));

        JOptionPane.showMessageDialog(null, scrollPane, "Lista de Estudiantes", JOptionPane.INFORMATION_MESSAGE);
    }
    public void editarNotasEstudiante() {
        if(estudiantes[0] == null){
            JOptionPane.showMessageDialog(null, "La lista esta vacia");
            return;
        }
        String identificacion = ingresarTexto("Ingrese la identificacion del estudiante: ");
        Estudiante aux = null;
        for(Estudiante estudiante : estudiantes) {
            if(estudiante.getIdentificacion().equals(identificacion)) {
                aux = estudiante;
                int numero = ingresarInt("Ingrese el numero de la nota que quiere ingresar: ");
                Nota notaAux = aux.getNotas()[numero];
                notaAux.setNombre(ingresarTexto("Ingrese el nombre de la nota: "));
                notaAux.setNota(ingresarFloat("ingrese la nota: "));

            }
        }
        if(aux == null){
            JOptionPane.showMessageDialog(null, "no se encontro al estudiante");
        }
    }

    private String ingresarTexto(String texto) {
        String mensaje = "";
        boolean salida = false;
        while (!salida) {
            mensaje = JOptionPane.showInputDialog(texto);
            if (mensaje.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese un texto");
            }else{
                salida = true;
            }
        }
        return mensaje;
    }
    private float ingresarFloat(String texto) {
        float numero = 0;
        boolean salida = false;
        while (!salida) {
            try {
                numero = Float.parseFloat(JOptionPane.showInputDialog(texto));
                salida = true;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un numero");
            }
        }
        return numero;
    }
    private int ingresarInt(String texto) {
        int numero = 0;
        boolean salida = false;
        while (!salida) {
            try {
                numero = Integer.parseInt(JOptionPane.showInputDialog(texto));
                salida = true;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Ingrese un numero");
            }
        }
        return numero;
    }
    private float calcularmedia(Estudiante estudiante) {
        Nota[] notas = estudiante.getNotas();
        float media = 0;
        for (int i = 0; i < notas.length; i++) {
            media += notas[i].getNota();
        }
        media = media/notas.length;
        return media;
    }
}
