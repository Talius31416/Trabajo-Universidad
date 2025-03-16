package Java.Principiantes;

public class Estudiante {
    private String nombre;
    private String identificacion;
    private Nota[] notas = new Nota[5];

    public Estudiante(String nombre, String identificacion, Nota[] notas) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.notas = notas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdentificacion() {
        return identificacion;
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
    public Nota[] getNotas() {
        return notas;
    }
    public void setNotas(Nota notas, int indice) {
        this.notas[indice] = notas;
    }
    private String notasToString() {
        String texto = "";
        for (int i = 0; i < notas.length; i++) {
            texto += "Nombre: "+ notas[i].getNombre() + "\nNota: "+ notas[i].getNota() + "\n";
        }
        return texto;
    }
    public String estudiantesToString() {
        return "Nombre: "+nombre+"\nIdentificacion: "+identificacion+"\nNotas:\n"+notasToString();
    }

}
