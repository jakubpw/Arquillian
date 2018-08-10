

import domain.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {
    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    public static void main(String[] args){
        addEmployees();
        Query query=entityManager.createQuery("select from Employee e where e.i");
        Object[] result=(Object[])query.getSingleResult();
        System.out.println("Srednia:"+result[0]);
        System.out.println("Min:"+result[1]);
        System.out.println("Max:"+result[2]);
        System.out.println("Suma:"+result[3]);
        System.out.println("Ilosc:"+result[4]);
        Query query1=entityManager.createQuery("select substring(e.firstName, 1,3), trim(e.lastName), lower(e.firstName), upper(e.lastName), length(e.firstName) from Employee e where e.firstName='Karol'");
        Object[] result2=(Object[])query1.getSingleResult();
        System.out.println(result2[0]+" "+result2[1]+" "+result2[2]+" "+result2[3]+" "+result2[4]);
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void addEmployees(){
        addEmployee("Karol", "Mateusiak", 2633);
        addEmployee("Marika", "Bednarek", 2345);
        addEmployee("Jan", "Mateusiak", 7346);
        addEmployee("Daria", "Kowalska", 2352);
        addEmployee("Monika", "Ucinska", 4263);
        addEmployee("Ernest", "Pajak", 2634);
        addEmployee("Kamil", "Stepien", 2345);
        addEmployee("Przemek", "Maciejewski", 5433);
        addEmployee("Reobert", "Wozniak", 3324);
        addEmployee("Agnieszka", "Nowak", 2000);
        addEmployee("Angelika", "Bednarska", 1000);
    }
    private static void addEmployee(String firstName, String lastName, double salary){
        Employee employee = new Employee();
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setSalary(salary);

    }
}
