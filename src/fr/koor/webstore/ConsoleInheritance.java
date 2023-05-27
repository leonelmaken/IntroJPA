package fr.koor.webstore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.koor.webstore.business.Payment;

public class ConsoleInheritance {

	public static void main(String[] args) throws Exception {
		
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            TypedQuery<Payment> query = entityManager.createQuery( "from Payment", Payment.class );
            List<Payment> payments = query.getResultList();
            for (Payment payment : payments) {
                System.out.println( payment.getClass().getName() );
                System.out.println( "\t" + payment );
            }

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
		
	}

}
