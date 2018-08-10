package domain;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class EmployeeService {
    @PersistenceContext
    private EntityManager entityManager;

    public void setOuterService(OuterService outerService) {
        this.outerService = outerService;
    }

    @Inject
    private OuterService outerService;

    public void saveNewEmployee(){
        Employee employee = new Employee();
        String outerData = outerService.GetDataFrom3RdService();
        employee.setFirstName("test1");
        employee.setLastName(outerData);
        entityManager.persist(employee);
    }

    public Employee findOne(String firstName){
        return entityManager.createQuery("SELECT e FROM Employee WHERE e.fristName LIKE :firstName", Employee.class)
                .setParameter("firstName", firstName)
                .getSingleResult();
    }
}
