package br.edu.unifei.ecoe18.got.modelo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class FonteDados {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("gotPU");
	
	public static EntityManager createEntityManager(){
		return emf.createEntityManager(); 
	}

}
