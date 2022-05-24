package repositoryImp;

import clases.Estado;
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
		// Estado s = null;//this.em.find(Estado.class, e.getId());
		// buscar que exista carrera, que exista estudiante y que no exista ese estado
		// previamente
		//        if(s != null){
		//            return false;
		//        }else {
		this.em.getTransaction().begin();
		this.em.persist(e);
		this.em.getTransaction().commit();
		this.em.close();
		this.emf.close();
		return true;
		// }
	}

    @Override
    public List<Estado> GetEstados() {
        CreateEntityManager();
        this.emf  = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
        this.em.getTransaction().begin();
        List<Estado> list = em.createQuery("SELECT e FROM Estado e ").getResultList();
        this.em.close();
        return list;
    }

}
