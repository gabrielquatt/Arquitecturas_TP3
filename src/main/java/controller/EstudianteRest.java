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
    public List<Estudiante> getStudentsOrderedBy(){
        return imp.GetEstudianteRepository().GetEstudiantes();
    }

    /**
     * 2) dar de alta un estudiante
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
