package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

import domain.RateDomainModel;
import domain.StudentDomainModel;
import util.HibernateUtil;

import ch.makery.address.model.*;

public class RateDAL {


	public static double getRate(int GivenCreditScore) {
			SessionFactory factory; 
		
		factory = new AnnotationConfiguration(). 
				configure().
				addAnnotatedClass(Rate.class).
				buildSessionFactory();
		
			Session session = factory.openSession();
			Transaction ts = null;
			double rate = null;		
			
			Transaction tx;
			try {
				tx = session.beginTransaction();	
										
				Query query = session.createQuery("from RateDal where mincreditscore <= givenCreditScore :id ");
				
				
				List<Double> rates = query.list();
				rates = (List<Double>) query.list();
				
				tx.commit();
				
			} catch (HibernateException e) {
				if (tx != null)
					tx.rollback();
				e.printStackTrace();
			} finally {
				session.close();
			}
			return rate;
		}		
		
		
		//FinalExam - please implement		
		// Figure out which row makes sense- return back the 
		// right interest rate from the table based on the given credit score
		
		//FinalExam - obviously change the return value
	}

}