package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ListDetails {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	private String coachName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Team team;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Player> listOfPlayers;
	
	public ListDetails(int id, String listName, String coachName, Team team, List<Player> listOfPlayers) {
		setId(id);
		setListName(listName);
		setCoachName(coachName);
		setTeam(team);
		setListOfPlayers(listOfPlayers);
	}
	
	public ListDetails(String listName, String coachName, Team team, List<Player> listOfPlayers) {
		setListName(listName);
		setCoachName(coachName);
		setTeam(team);
		setListOfPlayers(listOfPlayers);
	}
	
	public ListDetails(String listName, String coachName, Team team) {
		setListName(listName);
		setCoachName(coachName);
		setTeam(team);
	}
	
	public ListDetails() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public String getCoachName() {
		return coachName;
	}

	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	public List<Player> getListOfPlayers() {
		return listOfPlayers;
	}

	public void setListOfPlayers(List<Player> listOfPlayers) {
		this.listOfPlayers = listOfPlayers;
	}
	
	

}
