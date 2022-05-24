package repository;

import clases.Estudiante;

import java.util.List;

public interface EstudianteRepository {

    void InsertarEstudiante(Estudiante e);

    List<Estudiante> GetEstudiantes();

    Estudiante GetEstudianteById(int id);

    List<Estudiante> GetEstudiantesByGenero(String genero);

    List<Estudiante> GetEstudiantesByCiudad(String ciudad, int idCarrera);

}
