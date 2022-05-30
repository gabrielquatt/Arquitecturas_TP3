package controller;

import clases.Estudiante;
import factory.FactoryImp;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/estudiantes")
public class EstudianteRest {

    private FactoryImp imp;

    public EstudianteRest() {
        imp = FactoryImp.GetFactory();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> getEstudiantes(){
        return imp.GetEstudianteRepository().GetEstudiantes();
    }

    /**
     * 2) c)
     * recuperar todos los estudiantes, y especificar algún criterio de ordenamiento simple.
     * Ordenamiento DESC
     * */
    @GET
    @Path("/orderByNumLibreta")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> getEstudiantesOrderByNumLibreta(){
        return imp.GetEstudianteRepository().GetEstudiantesOrderByNumLibretaDESC();
    }
    
    /**
     * 2) d)
     * recuperar un estudiante, en base a su número de libreta universitaria.
     * */
    @GET
    @Path("/LU/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> getEstudiantesByID(@PathParam("id") int id){
        return imp.GetEstudianteRepository().GetEstudianteById(id);
    }
    
    /**
     * 2) e)
     * recuperar los estudiantes en base a su género
     * */
    @GET
    @Path("/{gender}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> getEstudiantesGenere(@PathParam("gender") String gender){
        return imp.GetEstudianteRepository().GetEstudiantesByGenero(gender);
    }

    /**
     * 2) g)
     * recuperar los estudiantes de una determinada carrera, filtrado por ciudad de residencia.
     * */
    @GET
    @Path("/{ciudad}/{carrera}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estudiante> getEstudiantesByCiudadAndCarrera(@PathParam("ciudad") String ciudad, @PathParam("carrera") int idarrera){
        return imp.GetEstudianteRepository().GetEstudiantesByCiudad(ciudad, idarrera);
    }

    /**
     * 2) a) dar de alta un estudiante
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addEstudiante(Estudiante e){
        boolean insert = imp.GetEstudianteRepository().InsertarEstudiante(e);
        if(insert)
            return "Estudiante Agregado Con Exito";
        else
            return "Error. No se pudo Agregar el Estudiante";
    }
}
