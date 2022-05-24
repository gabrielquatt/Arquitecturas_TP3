package repositoryImp;
import clases.Carrera;
import dto.ReporteCarreraDTO;
import repository.CarreraRepository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CarreraRepositoryImp implements CarreraRepository {

    private EntityManagerFactory emf;
    private EntityManager em;

    public CarreraRepositoryImp() {
    }
    /**
     * Crea un entity manager factory y un entity manager
     */
    private void CreateEntityManager() {
        this.emf  = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
    }
    /**
     * Inserta una carrera
     *
     * @param c {@link clases.Carrera}
     */
    @Override
    public void InsertarCarrera(Carrera c) {
        CreateEntityManager();
        this.em.getTransaction().begin();
        this.em.persist(c);
        this.em.getTransaction().commit();
        this.em.close();
        this.emf.close();
    }
    /**
     * Devuelve una lista de carreras ordenadas por cantidad de inscriptos
     *
     * @return lista de carreras
     */
    @Override
    public List<Carrera> GetCarrerasOrderByInscriptos() {
        CreateEntityManager();
        this.emf  = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
        this.em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Carrera> list = em.createQuery("SELECT c FROM Carrera c JOIN Estado e ON c.id = e.carrera.id GROUP BY c.id ORDER BY COUNT(*)").getResultList();
        this.em.close();
        return list;
    }

    @Override
    public List<Carrera> GetCarreras() {
        CreateEntityManager();
        this.emf  = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
        this.em.getTransaction().begin();
        List<Carrera> list = em.createQuery("SELECT c FROM Carrera c ").getResultList();
        this.em.close();
        return list;
    }

    /**
     * Devuelve una lista de de cantidad de inscriptos y egresados por año por carrera
     *
     * @return lista de ReporteCarreraDTO {@link dto.ReporteCarreraDTO}
     */
    @Override
    public List<ReporteCarreraDTO> ReporteCarrera() {
        CreateEntityManager();
        this.em.getTransaction().begin();
        List<ReporteCarreraDTO> list = em.createQuery("SELECT new dto.ReporteCarreraDTO( c.nombre, YEAR(e.anioIngreso), COUNT(e.anioIngreso), COUNT(e.anioEgreso) ) FROM Carrera c JOIN Estado e ON c.id = e.carrera.id GROUP BY EXTRACT(YEAR FROM e.anioIngreso), c.nombre ORDER BY 1 ASC, 2 DESC", ReporteCarreraDTO.class).getResultList();
        this.em.close();
        return list;
    }
}
