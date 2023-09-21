/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;

/**
 *
 * @author 
 */
public class DepartmentMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Department dpIT = new Department();
        dpIT.setName("IT");
        Department dpHR = new Department();
        dpHR.setName("HR");
        
        persist(dpIT);
        persist(dpHR);
        
        Employee emp1 = new Employee();
        emp1.setName("John");
        emp1.setJob("Network Admin");
        emp1.setSalary(56785);
        emp1.setDepartmentid(dpIT);
        
        Employee emp2 = new Employee();
        emp2.setName("Marry");
        emp2.setJob("HR Manager");
        emp2.setSalary(54755);
        emp2.setDepartmentid(dpHR);
        
        Employee emp3 = new Employee();
        emp3.setName("Henrry");
        emp3.setJob("Programmer");
        emp3.setSalary(45274);
        emp3.setDepartmentid(dpIT);
        
        Employee emp4 = new Employee();
        emp4.setName("Clark");
        emp4.setJob("HR recuiter");
        emp4.setSalary(23585);
        emp4.setDepartmentid(dpHR);
        
        persist(emp1);
        persist(emp2);
        persist(emp3);
        persist(emp4);
 
    }

    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("departmentPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
