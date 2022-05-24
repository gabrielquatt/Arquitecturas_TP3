package controller;


import clases.Carrera;
import clases.Estudiante;
import factory.FactoryImp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/carreras")
public class CarreraRest {

    private FactoryImp imp;

    public CarreraRest() {
        imp = FactoryImp.GetFactory();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carrera> getStudentsOrderedBy(){
        return imp.GetCarreraRepository().GetCarreras();
    }
}
