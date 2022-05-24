package dto;

public class ReporteCarreraDTO {

    private String nombre_Carrera;
    private int anio;
    private Long incriptos;
    private Long egresados;

    public ReporteCarreraDTO() {
        super();
    }

    public ReporteCarreraDTO(String nombre_Carrera, int anio, Long incriptos, Long egresados) {
        this.nombre_Carrera = nombre_Carrera;
        this.anio = anio;
        this.incriptos = incriptos;
        this.egresados = egresados;
    }

    public String getNombre_Carrera() {
        return nombre_Carrera;
    }
    public void setNombre_Carrera(String nombre_Carrera) {
        this.nombre_Carrera = nombre_Carrera;
    }
    public int getAnio() {
        return anio;
    }
    public void setAnio(int anio) {
        this.anio = anio;
    }
    public Long getIncriptos() {
        return incriptos;
    }
    public void setIncriptos(Long incriptos) {
        this.incriptos = incriptos;
    }
    public Long getEgresados() {
        return egresados;
    }
    public void setEgresados(Long egresados) {
        this.egresados = egresados;
    }

    @Override
    public String toString() {
        return "Carrera= " + nombre_Carrera + ", anio=" + anio + ", incriptos=" + incriptos
                + ", egresados=" + egresados + "]";
    }
}
