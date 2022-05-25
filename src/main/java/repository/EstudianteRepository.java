package repository;

import clases.Estudiante;

import java.util.List;

public interface EstudianteRepository {

	boolean InsertarEstudiante(Estudiante e);

	List<Estudiante> GetEstudiantes();
	
	List<Estudiante> GetEstudiantesOrderByNumLibretaDESC();

	List<Estudiante> GetEstudianteById(int id);

    List<Estudiante> GetEstudiantesByGenero(String genero);

    List<Estudiante> GetEstudiantesByCiudad(String ciudad, int idCarrera);

}
