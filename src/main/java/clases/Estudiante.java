package clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Estudiante {

    @Id
    private int num_Libreta;

    @Column (nullable = false)
    private int num_doc;

    @Column
    private String name;

    @Column
    private String apellido;

    @Column
    private int edad;

    @Column (name = "genere")
    private String genero;

    @Column
    private String residencia;

    public Estudiante() {
        super();
    }

    public Estudiante(int num_Libreta, int num_doc, String nombres, String apellido, int edad, String genero,
                      String residencia) {
        super();
        this.num_Libreta = num_Libreta;
        this.num_doc = num_doc;
        this.name = nombres;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.residencia = residencia;
    }

    public int getNum_Libreta() {
        return num_Libreta;
    }

    public void setNum_Libreta(int num_Libreta) {
        this.num_Libreta = num_Libreta;
    }

    public int getNum_doc() {
        return num_doc;
    }

    public void setNum_doc(int num_doc) {
        this.num_doc = num_doc;
    }

    public String getNombres() {
        return name;
    }

    public void setNombres(String nombres) {
        this.name = nombres;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getResidencia() {
        return residencia;
    }

    public void setResidencia(String residencia) {
        this.residencia = residencia;
    }

    @Override
    public String toString() {
        return "Estudiante [num_Libreta=" + num_Libreta + ", num_doc=" + num_doc + ", nombres=" + name
                + ", apellido=" + apellido + ", edad=" + edad + ", genero=" + genero + ", residencia=" + residencia
                + "]";
    }
}