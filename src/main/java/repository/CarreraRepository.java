package repository;

import clases.Carrera;
import dto.ReporteCarreraDTO;

import java.util.List;


public interface CarreraRepository {

    void InsertarCarrera(Carrera c);

    List<Carrera> GetCarrerasOrderByInscriptos();


    List<Carrera> GetCarreras();

    List<ReporteCarreraDTO> ReporteCarrera();
}
