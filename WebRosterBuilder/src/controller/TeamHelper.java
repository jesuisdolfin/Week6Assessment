package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Team;

public class TeamHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebRosterBuilder");
	
	public void insertTeam(Team given) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(given);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Team> showAllTeams() {
		EntityManager em = emfactory.createEntityManager();
		List<Team> allTeams = em.createQuery("SELECT given FROM Team given").getResultList();
		return allTeams;
	}
	
	public Team findTeam(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Team> typedQuery = em.createQuery("SELECT t FROM Team t WHERE t.teamName = :selectedName", Team.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		
		Team foundTeam;
		try {
			foundTeam = typedQuery.getSingleResult();
		}
		catch(NoResultException e) {
			foundTeam = new Team(nameToLookUp);
		}
		em.close();
		
		return foundTeam;
	}
	
}
