package wildflyswarm.jpa_cdi_arq;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
//@DefaultDeployment
public class EmployeeRepositoryIT {

  @Deployment
  public static Archive createDeployment() {
    return ShrinkWrap.create(WebArchive.class)
      .addPackage(Employee.class.getPackage())
      .addAsResource("project-it.yml", "project-defaults.yml")
      .addAsResource("META-INF/test-persistence.xml",  "META-INF/persistence.xml")
      .addAsResource("META-INF/test-load.sql",  "META-INF/test-load.sql");
  }

  @Inject
  private EmployeeRepository sut;

  @Test
  public void test() throws Exception {
    assertThat(sut, is(notNullValue()));
    assertThat(sut.findAll().size(), is(5));
  }

}
