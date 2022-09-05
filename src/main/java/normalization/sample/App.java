package normalization.sample;

import normalization.sample.model.Doctor;
import normalization.sample.util.HibernateUtil;
import org.hibernate.Session;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		for (int i = 0; i < 5; i++) {
			saveStudentRecord(session);
		}

		HibernateUtil.shutdown();
	}

	private static void saveStudentRecord(Session session) {
		Doctor newDoctor = new Doctor();
		newDoctor.setDoctorName("Ricky Lo");
		session.beginTransaction();
		session.save(newDoctor);
		session.getTransaction().commit();
		System.out.println("Record saved successfully...");
	}
}
