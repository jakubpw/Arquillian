package example;

import domain.Employee;
import domain.EmployeeService;
import domain.OuterService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class EmployeeServiceTest {
    private static final String expectedFirstName = "test1";
    @PersistenceContext
    private EntityManager entityManager;

    @Inject
    private EmployeeService employeeService;

    @Mock
    private OuterService outerService;

    @Before
    public void setUp(){
        employeeService.setOuterService(outerService);
        when(pobierzZSerwisy).then(zwrocDaneZserwisu);
    }


    @Test
    public void testSave(){
        employeeService.saveNewEmployee();
        Employee found = employeeService.findOne(expectedFirstName);
        assertThat(found != null && found.getFirstName().isEqual(expectedFirstName));
    }

    @Test
    public void testFInd(){
        entityManager.persist(new Employee());
        //znajdz i stworz konfig na tego podstawie

    }

}
