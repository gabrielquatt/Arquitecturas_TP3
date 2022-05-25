package controller;


import clases.Carrera;
import clases.Estado;
import clases.Estudiante;
import factory.FactoryImp;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.time.LocalDate;
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
    
//    /**
//     * 2) matricular un estudiante en una carrera
//     */
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.TEXT_PLAIN)
//    public String addEstado(Estado e){
//        boolean insert = imp.GetEstadoRepository().InsertEstado(e);
//        if(insert)
//            return "Estudiante Agregado Con Exito A la Carrera";
//        else
//            return "Error. No se pudo Agregar el Estudiante a La Carrera";
//    }
}
