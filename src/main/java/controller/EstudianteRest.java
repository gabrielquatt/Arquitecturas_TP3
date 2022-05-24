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

}
