/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package department;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Department;
import model.Employee;
import model.EmployeeTable;

/**
 *
 * @author jakso
 */
public class DepartmentReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         List<Employee> empList = EmployeeTable.findAllEmployee();
       printAllEmployee(empList);
    }
    
    public static Department findDepName(String name){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MultiplicityDemoPU");
        EntityManager em = emf.createEntityManager();
        Department dep = em.find(Department.class , name);
        em.close();
        return dep;
    }
    
    public static Department findDepID(int id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MultiplicityDemoPU");
        EntityManager em = emf.createEntityManager();
        Department dep = em.find(Department.class , id);
        em.close();
        return dep;
    }
    
  
     public static void printAllEmployee(List<Employee> employeeList) {
        System.out.println("All employee (by ID)");
        System.out.println("---------------------------");
        for(Employee emp : employeeList) {
           System.out.println("ID: " + emp.getEmployeeid());
           System.out.println("Name: "+ emp.getName());
           System.out.println("Job: "+ emp.getJob());
           System.out.println("Salary: "+emp.getSalary());
           System.out.println("Department: "+emp.getDepartmentid().getName());
           System.out.println("---------------------------");
       }
    }
}
