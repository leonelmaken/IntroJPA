package fr.koor.webstore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.koor.webstore.business.Role;
import fr.koor.webstore.business.User;

public class ConsoleManyToMany {

	public static void main(String[] args) throws Exception {
		
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println( "-------------------------------------------------" );

            User user = entityManager.find( User.class, 1 );
            System.out.println( user );
            for( Role role : user.getRoles() ) {
            	System.out.println( role );
            }
            
            System.out.println( "-------------------------------------------------" );

            Role role = entityManager.find( Role.class, 1 );
            for( User user2 : role.getUsers() ) {
            	System.out.println( user2 );
            }

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
		
	}

}
