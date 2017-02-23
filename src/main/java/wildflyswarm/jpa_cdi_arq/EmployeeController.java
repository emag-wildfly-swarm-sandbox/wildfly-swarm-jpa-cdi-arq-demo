package wildflyswarm.jpa_cdi_arq;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@ApplicationScoped
@Path("/")
public class EmployeeController {

  @Inject
  private EmployeeRepository repository;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<Employee> get() {
    return repository.findAll();
  }

}
