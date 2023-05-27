package fr.koor.webstore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.koor.webstore.business.Command;

public class ConsoleManyToOne {

	public static void main(String[] args) throws Exception {
		
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println( "-------------------------------------------------" );

            Command command = entityManager.find( Command.class, 2 );
            System.out.println( command );
            System.out.println( command.getUser() );
            
        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
		
	}

}
