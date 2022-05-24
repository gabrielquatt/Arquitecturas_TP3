package repositoryImp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import clases.Carrera;
import clases.Estudiante;
import repository.EstudianteRepository;

public class EstudianteRepositoryImp implements EstudianteRepository {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EstudianteRepositoryImp() {
        this.emf  = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
    }

    /**
     * Crea un entity manager factory y un entity manager
     */
    private void CreateEntityManager() {
        this.emf  = Persistence.createEntityManagerFactory("Example");
        this.em = emf.createEntityManager();
    }
    /**
     * Inserta un estudiante
     *
     * @param e estudiante {@link clases.Estudiante}
     *
     */
    @Override
    public void InsertarEstudiante(Estudiante e) {
        CreateEntityManager();
        this.em.getTransaction().begin();
        this.em.persist(e);
        this.em.getTransaction().commit();
        this.em.close();
        this.emf.close();
    }
    /**
     * Devuelve la lista de estudiantes ordenados por nro de libreta
     */
    @Override
    public List<Estudiante> GetEstudiantes() {
        CreateEntityManager();
        this.em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Estudiante> list = em.createQuery("SELECT e FROM Estudiante e ORDER BY e.num_Libreta DESC").getResultList();
        this.em.close();
        this.emf.close();
        return list;
    }
    /**
     * Devuelve un estudiante por id (numero de libreta)
     *
     * @return estudiante
     */
    @Override
    public Estudiante GetEstudianteById(int id) {
        CreateEntityManager();
        this.em.getTransaction().begin();
        Estudiante e =	em.find(Estudiante.class, id);;
        this.em.close();
        this.emf.close();
        return e;
    }
    /**
     * Devuelve una lista de estudiantes filtrada por genero
     *
     * @param genero genero de la persona (male/female/agender/bigender)
     * @return lista de estudiantes
     */
    @Override
    public List<Estudiante> GetEstudiantesByGenero(String genero) {
        CreateEntityManager();
        this.em.getTransaction().begin();
        @SuppressWarnings("unchecked")
        List<Estudiante> list = em.createQuery("SELECT e FROM Estudiante e WHERE e.genero = ?1").setParameter(1, genero).getResultList();
        this.em.close();
        this.emf.close();
        return list;
    }
    /**
     * Devuelve una lista de estudiantes filtrados por ciudad y carrera
     *
     * @param ciudad ciudad de un estudiante
     * @param idCarrera carrera {@link Carrera}
     *
     * @return lista de estudiantes
     */
    @Override
    public List<Estudiante> GetEstudiantesByCiudad(String ciudad, int idCarrera) {
        CreateEntityManager();
        this.em.getTransaction().begin();
        Query query = em.createQuery("SELECT e FROM Estudiante e WHERE e.residencia LIKE ?1 AND e.num_Libreta IN (SELECT es.estudiante FROM Estado es WHERE (es.carrera.id = ?2))");
        query.setParameter(1, ciudad);
        query.setParameter(2, idCarrera);
        @SuppressWarnings("unchecked")
        List<Estudiante> list = query.getResultList();
        this.em.close();
        this.emf.close();
        return list;
    }

}
