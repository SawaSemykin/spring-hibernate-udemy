import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ru.sawasemykin.entity.Employee;

public class CrudOperationsDemo {

	public static void main(String[] args) {
						
		// create session factory object based on config file
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		// create session object
		Session session = factory.getCurrentSession();
		
		List<Employee> stuff = new ArrayList<>();
		stuff.add(new Employee("John", "Doe", "IBM"));
		stuff.add(new Employee("Mary", "Public", "Apple"));
		stuff.add(new Employee("James", "Bond", "MI6"));
		stuff.add(new Employee("Ivanov", "Ivan", "IBM"));		

		try {
			// start transaction
			session.beginTransaction();
			
			// perform CRUD operations
			
			// add stuff to db
			System.out.println("Start saving...");
			for(Employee tempEmployee : stuff) {
				session.save(tempEmployee);
				System.out.println("Saving the employee: " + tempEmployee);
			}			
			
			// retrieve employee by id
			System.out.println("\n\nStart retrieving the last employee...");
			Employee theLastEmployee = session.get(Employee.class, stuff.size());
			System.out.println("The last employee is: " + theLastEmployee);
			
			// retrieve employees for a given company
			System.out.println("\n\nStart retrieving employees for a given company...");
			List<Employee>  ibmStuff = session.createQuery("from Employee e where e.company='IBM'").getResultList();			
			for(Employee emp : ibmStuff)
				System.out.println(emp);
			
			// delete employee by id
			Employee theFirstEmployee = stuff.get(0);
			System.out.println("\n\nStart deleting an employee by id...");
			System.out.println("It is: " + theFirstEmployee);
			session.delete(theFirstEmployee);
			
			// commit change
			session.getTransaction().commit();
			System.out.println("Done");
			
		} finally {
			// clean up memory
			factory.close();
		}
		
	}

}
