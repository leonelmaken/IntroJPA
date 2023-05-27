package fr.koor.webstore;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.koor.webstore.business.Command;
import fr.koor.webstore.business.User;

public class ConsoleOneToMany {

	public static void main(String[] args) throws Exception {
		
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println( "-------------------------------------------------" );

            User user = entityManager.find( User.class, 2 );
            System.out.println( user );
            List<Command> commands = user.getCommands();
            for (Command command : commands) {
				System.out.println( command );
			}
            
        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
		
	}

}
