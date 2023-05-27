package fr.koor.webstore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import fr.koor.webstore.business.Article;

public class Console {

	public static void main(String[] args) throws Exception {
		
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("WebStore");
            entityManager = entityManagerFactory.createEntityManager();

            System.out.println( "-------------------------------------------------" );
            
            Article art = entityManager.find( Article.class, 5 );
            System.out.println( art );
            
            /*List<Article> articles = entityManager.createQuery( "from Article", Article.class ).getResultList();
            for (Article article : articles) {
				System.out.println( article );
			}*/
           
            
//            EntityTransaction trans = entityManager.getTransaction();
//            trans.begin();
//          
//            Article newArt = new Article( "Truc", "Bidon", 100 );
//            entityManager.persist( newArt );
//            
//            art.setPrice( 9 );
//            entityManager.persist( art );
//          
//            entityManager.remove( newArt );
//            
//            trans.commit();
            
            
        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }
		
	}

}
