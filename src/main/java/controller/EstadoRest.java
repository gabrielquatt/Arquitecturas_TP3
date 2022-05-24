package controller;


import clases.Estado;
import clases.Estudiante;
import factory.FactoryImp;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/estados")
public class EstadoRest {

    private FactoryImp imp;

    public EstadoRest() {
        imp = FactoryImp.GetFactory();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Estado> GetAll(){
        return imp.GetEstadoRepository().GetEstados();
    }
}
