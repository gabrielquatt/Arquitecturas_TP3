package controller;


import clases.Carrera;
import clases.Estudiante;
import dto.ReporteCarreraDTO;
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
    public List<Carrera> getAllCarreras(){
        return imp.GetCarreraRepository().GetCarreras();
    }
    
    @GET
    @Path("/OrdyByInscriptos")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Carrera> getCarrerasByInscriptos(){
        return imp.GetCarreraRepository().GetCarrerasOrderByInscriptos();
    }
    
    @GET
    @Path("/reporte-carreras")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReporteCarreraDTO> reporteCarreras(){
        return imp.GetCarreraRepository().ReporteCarrera();
    }
    
}
