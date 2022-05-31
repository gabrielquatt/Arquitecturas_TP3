package clases;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Estado {

    @EmbeddedId
    private EstudianteCarreraPK id;

    @ManyToOne
    private Carrera carrera;//FK

    @ManyToOne
    private Estudiante estudiante;//FK

    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate anioIngreso;

    @Column
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate anioEgreso;

    public Estado() {
        super();
    }

    public Estado( Carrera c, Estudiante e, LocalDate anios) {
        this.id = new EstudianteCarreraPK(c.getId(), e.getNum_Libreta());
        //this.pk = new EstudianteCarreraPK(e, c);
        this.carrera = c;
        this.estudiante = e;
        this.anioIngreso = anios;
        this.anioEgreso = null;
    }

    public Estado( Carrera c, Estudiante e, LocalDate anios, LocalDate anioEgreso) {
        this.id = new EstudianteCarreraPK(c.getId(), e.getNum_Libreta());
        //this.pk = new EstudianteCarreraPK(e, c);
        this.carrera = c;
        this.estudiante = e;
        this.anioIngreso = anios;
        this.anioEgreso = anioEgreso;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getAnioIngreso() {
        return anioIngreso;
    }

    public void setAnios(LocalDate anios) {
        this.anioIngreso = anios;
    }

    public LocalDate anioEgreso() {
        return anioEgreso;
    }

    public void setanioEgreso(LocalDate recibido) {
        this.anioEgreso = recibido;
    }
    
    public EstudianteCarreraPK getId() {
		return id;
	}

	@Override
    public String toString() {
        return "Estado [carrera=" + carrera + ", estudiante=" + estudiante + ", año de ingreso=" + anioIngreso + ", anio que se recibio="
                + anioEgreso + "]";
    }

}