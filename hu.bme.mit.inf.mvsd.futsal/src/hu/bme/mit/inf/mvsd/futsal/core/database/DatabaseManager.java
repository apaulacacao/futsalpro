package hu.bme.mit.inf.mvsd.futsal.core.database;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

public class DatabaseManager {

	EntityManagerFactory emf;
	private EntityManager entityManager;
	
	public DatabaseManager()
	{
		emf = Persistence.createEntityManagerFactory("futsal");
		entityManager = emf.createEntityManager();
	}

	public Collection<Team> getTeams() {
		try{
			return entityManager.createQuery("FROM Team").getResultList();
		} catch (PersistenceException ex) {
			return new ArrayList<Team>();
		}
	}
	
	public Collection<Referee> getReferees()
	{
		try {
			return entityManager.createQuery("FROM Referee").getResultList();
		} catch (PersistenceException ex) {
			return new ArrayList<Referee>();
		}
	}
	
	public Collection<Supervisor> getSupervisors()
	{
		try{
			return entityManager.createQuery("FROM Supervisor").getResultList();
		} catch (PersistenceException ex) {
			return new ArrayList<Supervisor>();
		}
	}
	
	public Collection<Pitch> getPitches() {
		try{
			return entityManager.createQuery("FROM Pitch").getResultList();
		} catch (PersistenceException ex) {
			return new ArrayList<Pitch>();
		}
	}
	
	public Collection<Player> getPlayers(int teamId) {
		try{
			return entityManager.createQuery("FROM Player WHERE TeamId=" + teamId).getResultList();
		} catch (PersistenceException ex) {
			return new ArrayList<Player>();
		}
	}
	
	public Collection<GoalKeeper> getGoalkeepers(int teamId) {
		try{
			return entityManager.createQuery("FROM GoalKeeper WHERE TeamId=" + teamId).getResultList();
		} catch (PersistenceException ex) {
			return new ArrayList<GoalKeeper>();
		}
	}
	
	public Collection<Crew> getCrew(int TeamId) {
		try{
			return entityManager.createQuery("FROM Crew WHERE TeamId=" + TeamId).getResultList();
		} catch (PersistenceException ex) {
			return new ArrayList<Crew>();
		}
	}
}
