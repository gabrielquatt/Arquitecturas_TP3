package repositoryImp;

import clases.Carrera;
import clases.Estado;
import clases.Estudiante;
import repository.EstadoRepository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EstadoRepositoryImp implements EstadoRepository {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EstadoRepositoryImp() {
    }
    /**
     * Crea un entity manager factory y un entity manager
     */
    private void CreateEntityManager() {
        this.emf  = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
    }
    /**
     * Inserta una inscripcion de un estudiante a una carrera
     *
     * @param e {@link clases.Estado}
     */
	@Override
    public boolean InsertEstado(Estado e) {
		CreateEntityManager();
		Estado s = this.em.find(Estado.class, e.getId());
		
		if(s != null){
	        return false;
		}
		Estudiante es = this.em.find(Estudiante.class,e.getEstudiante().getNum_Libreta());
		if(es == null) {
			return false;
		}
		Carrera c = this.em.find(Carrera.class, e.getCarrera().getId());
		if (c == null) {
			return false;
		}
		this.em.getTransaction().begin();
		this.em.persist(e);
		this.em.getTransaction().commit();
		this.em.close();
		this.emf.close();
		return true;
		
	}

    @Override
    public List<Estado> GetEstados() {
        CreateEntityManager();
        // this.emf  = Persistence.createEntityManagerFactory("Example");
        // this.em = emf.createEntityManager();
        this.em.getTransaction().begin();
        List<Estado> list = em.createQuery("SELECT e FROM Estado e ").getResultList();
        this.em.close();
        return list;
    }

}
