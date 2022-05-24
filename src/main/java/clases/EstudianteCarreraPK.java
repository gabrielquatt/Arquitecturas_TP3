package clases;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EstudianteCarreraPK implements Serializable{

    @Column
    private int c;
    @Column
    private int e;

    public EstudianteCarreraPK(int i, int j) {
        super();
        // INTERCAMBIADO ASIGNACIONES PORQUE SE ESTABAN ASOCIANDO CRUZADOS CON LOS id's DE ESTUDIANTE Y CARRERA
        this.c = i;
        this.e = j;
    }

    public EstudianteCarreraPK() {
    }

    public int getE() {
        return e;
    }

    public void setE(int e) {
        this.e = e;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

	@Override
	public int hashCode() {
		return Objects.hash(c, e);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstudianteCarreraPK other = (EstudianteCarreraPK) obj;
		return c == other.c && e == other.e;
	}
    
}
