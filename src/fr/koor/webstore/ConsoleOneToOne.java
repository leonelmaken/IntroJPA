package fr.koor.webstore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.koor.webstore.business.User;

public class ConsoleOneToOne {

	public static void main(String[] args) throws Exception {
		
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println( "-------------------------------------------------" );

//            UserInformations userInfos = entityManager.find( UserInformations.class, 1 );
//            System.out.println( userInfos );
//            System.out.println( userInfos.getUser() );
            
            User user = entityManager.find( User.class, 1 );
            System.out.println( user );
            System.out.println( user.getUserInformations() );
            
            System.out.println( user == user.getUserInformations().getUser() );
            
        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
		
	}

}
