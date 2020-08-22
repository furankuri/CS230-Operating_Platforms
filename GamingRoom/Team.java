package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	
	// A list of players on the team.
	private static List<Player> players = new ArrayList<Player>();
	
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		
		// We call super keyword here in order to overide the default constructor and call the public constructor using the id and name.
		super(id, name);
	}

	
	//This method adds a player to the team. It first searches the list to make sure that a player does not exist with the same name. If no results are found then the player is added
	//to the list.
	public Player addPlayer(String name) {
		
		// local player instance
		Player player = null;
		
		// create the iterator for the players list.
		Iterator <Player> myIterator = players.iterator();
		
		GameService service = GameService.getInstance(); // gets a game service instance, this is required in order to get the next player ID
		
		while(myIterator.hasNext()) {  // this loop uses the iterator pattern to check for matching names.
			
			Player playerObject = myIterator.next();
			
			if(playerObject.getName().equals(name)) {
				player = playerObject;
			}
		}
		
		//if not found add to player list.
		 if (player == null) {
			player = new Player(service.getNextPlayerId(), name);
			players.add(player);
		 }
		
		
		return player;
	}

	@Override
	public String toString() {
		
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
