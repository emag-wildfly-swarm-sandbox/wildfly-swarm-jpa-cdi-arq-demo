package wildflyswarm.jpa_cdi_arq;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@ApplicationScoped
public class EmployeeRepository {

  @PersistenceContext
  private EntityManager em;

  public List<Employee> findAll() {
    return em.createNamedQuery("Employee.findAll", Employee.class).getResultList();
  }

}
