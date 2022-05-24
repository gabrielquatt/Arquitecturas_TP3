package factory;

import repository.CarreraRepository;
import repository.EstadoRepository;
import repository.EstudianteRepository;
import repositoryImp.CarreraRepositoryImp;
import repositoryImp.EstadoRepositoryImp;
import repositoryImp.EstudianteRepositoryImp;

public class FactoryImp {

    private static FactoryImp miConector;
    private static CarreraRepository cr;
    private static EstadoRepository er;
    private static EstudianteRepository esr;

    private FactoryImp() {
    }

    public static FactoryImp GetFactory() {
        if(miConector == null) {
            miConector = new FactoryImp();
        }
        return miConector;
    }

    public CarreraRepository GetCarreraRepository() {
        if(cr == null) {
            cr = new CarreraRepositoryImp();
        }
        return cr;
    }

    public EstadoRepository GetEstadoRepository() {
        if(er == null) {
            er = new EstadoRepositoryImp();
        }
        return er;
    }

    public EstudianteRepository GetEstudianteRepository() {
        if(esr == null) {
            esr = new EstudianteRepositoryImp();
        }
        return esr;
    }

}