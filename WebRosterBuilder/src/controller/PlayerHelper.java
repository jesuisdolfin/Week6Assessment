package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Player;

public class PlayerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("WebRosterBuilder");
	
	public void insertPlayer(Player given) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(given);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Player> showAllPlayers() {
		EntityManager em = emfactory.createEntityManager();
		List<Player> allPlayers = em.createQuery("SELECT i FROM Player i").getResultList();
		return allPlayers;
	}
	
	public void deletePlayer(Player toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player>typedQuery = em.createQuery("select given from Player given where given.name = :selectedName and given.number = :selectedNumber and given.position = :selectedPosition", Player.class);
		
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedNumber", toDelete.getNumber());
		typedQuery.setParameter("selectedPosition", toDelete.getPosition());
		
		typedQuery.setMaxResults(1);
		
		Player result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}

	public Player searchForPlayerById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Player found = em.find(Player.class, idToEdit);
		em.close();
		return found;
	}

	public void updatePlayer(Player toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Player> searchForPlayerByName(String playerName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select given from Player given where given.name = :selectedName", Player.class);
		typedQuery.setParameter("selectedName", playerName);
		
		List<Player> foundPlayers = typedQuery.getResultList();
		em.close();
		
		return foundPlayers;
	}

	public List<Player> searchForPlayerByNumber(String playerNumber) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select given from Player given where given.number = :selectedNumber", Player.class);
		typedQuery.setParameter("selectedNumber", playerNumber);
		
		List<Player> foundPlayers = typedQuery.getResultList();
		em.close();
		
		return foundPlayers;
	}
	
	public List<Player> searchForPlayerByPosition(String playerPosition) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Player> typedQuery = em.createQuery("select given from Player given where given.position = :selectedPosition", Player.class);
		typedQuery.setParameter("selectedPosition", playerPosition);
		
		List<Player> foundPlayers = typedQuery.getResultList();
		em.close();
		
		return foundPlayers;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
}
