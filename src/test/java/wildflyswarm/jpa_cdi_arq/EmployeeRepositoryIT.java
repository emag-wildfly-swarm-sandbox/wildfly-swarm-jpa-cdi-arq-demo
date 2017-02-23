package wildflyswarm.jpa_cdi_arq;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import javax.inject.Inject;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
@DefaultDeployment
public class EmployeeRepositoryIT {

  @Inject
  private EmployeeRepository sut;

  @Test
  public void test() throws Exception {
    assertThat(sut, is(notNullValue()));
    assertThat(sut.findAll().size(), is(5));
  }

}
