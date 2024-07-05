package com.sp.main.JPQLprogramselect;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.sp.entity.Employee;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        EntityManagerFactory entitymanagerfact=Persistence.createEntityManagerFactory("main-persistence");
         EntityManager em= entitymanagerfact.createEntityManager();
         
        //select employee id form the 
         try {
         String jql_query="Select e from Employee e where e.employee_id=:emp_id";
       TypedQuery<Employee> query= em.createQuery(jql_query,Employee.class);
       
       query.setParameter("emp_id", 1);
        
         Employee emp_rec= query.getSingleResult();
         
         
         if(emp_rec!=null)
         {
        	 System.out.println("ID  "+ emp_rec.getEmployee_id());
        	 System.out.println("Firstname  "+ emp_rec.getEmployee_firstname());
        	 System.out.println("Last Name  "+ emp_rec.getLast_firstname());
        	 System.out.println("Address "+ emp_rec.getAdress());
        	 System.out.println("Pincode "+ emp_rec.getPincode());
        	 System.out.println("------------------------------------------");
         }
        
         
        		 
         }
         catch(Exception e)
         {
        	 e.printStackTrace();
         }
         finally {
        	 em.close();
         }
    }
}
