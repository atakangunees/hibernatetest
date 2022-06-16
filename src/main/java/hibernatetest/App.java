package hibernatetest;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		Student s1 = new Student();
		Student s2 = new Student();
		Instructor i1 = new Instructor();
		Instructor i2 = new Instructor();

		s1.setName("Atakan");
		s1.setOrt(3.50);
		s2.setName("Kerem");
		s2.setOrt(3.90);
		i1.setbDay(LocalDate.of(1997, 9, 4));
		i1.setName("Meral");
		i2.setbDay(LocalDate.of(1995, 10, 20));
		i2.setName("Buðra");

		Configuration config = new Configuration();

		config.configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).addAnnotatedClass(Instructor.class);

		SessionFactory sessionFactory = config.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction trs = session.beginTransaction();

		session.save(s1);
		session.save(i1);
		session.save(s2);
		session.save(i2);

		trs.commit();

	}

}
