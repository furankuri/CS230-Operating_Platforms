package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	
	/**
	 * Hide the default constructor to prevent creating empty instances.
	 */
	private static List<Team> teams = new ArrayList<Team>(); // A list of Teams in the game.

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		
		// We call super keyword here in order to override the default constructor and call the public constructor using the id and name.
		super(id, name);
		
	}

	/**
	 * @return add the team
	 */
	
	//This method adds a team to the game. It first searches the list to make sure that a team does not exist with the same name. If no results are found then the team is added
		//to the list.
	public Team addTeam(String name) {
		
		// local team instance
		Team team = null;
		
		//create the iterator for the teams list
		Iterator <Team> myIterator = teams.iterator();
		
		
		GameService service = GameService.getInstance();  // gets a game service instance, this is required in order to get the next teamID
		
		long teamId = service.getNextTeamId(); // this assigns the next team id to the variable and increments each time the method is called.
		
		
		while(myIterator.hasNext()) {  // this loop uses the iterator pattern to check for matching names.
			
			Team teamObject = myIterator.next();
			if(teamObject.getName().equals(name)) {
				team = teamObject;
			}
			
		}
			
		//if not found add team to list.
		if (team == null) {
			team = new Team(teamId, name);
			teams.add(team);
		}
		
		
	   return team;
	}

	/**
	 * @return the name
	 */
	

	@Override
	public String toString() {
		
		
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
