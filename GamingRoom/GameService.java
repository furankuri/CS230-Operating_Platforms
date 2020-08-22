package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;



/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;
	private static long nextPlayerId = 1;
	private static long nextTeamId = 1;
	
	// Create a new game service object
	private static GameService service = new GameService();
	
	// Making the constructor private so that it cannot be instantiated and only one instance can be used at a time.
	private GameService() {}
	
	//This returns the instance object
	public static GameService getInstance() {
		return service;
	}


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	
	/*
	 * In the following methods iterators were used to find instances with the same name and id. It would then either return the instance that was being used 
	 * or set the local variable equal to the instance found. This uses the iteration pattern to cycle through list and compares names and IDs.
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;
		Iterator <Game> myIterator = games.iterator();

		// Use iterator to look for existing game with same name
		while(myIterator.hasNext()) { // create an iterator named gameObject to iterate through games
		// if found, simply return the existing instance

		Game  gameObject =  myIterator.next();
		   
		   if(gameObject.getName().equals(name)) {   //this conditional statement checks the names of the game instances and then
				 game = gameObject;             // sets game equal to that value if a match is found else it remains null.
			} 
		}
		
		// if not found, make a new game instance and add to list of games
		 if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		   }
		 

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;
		Iterator <Game> myIterator = games.iterator();
		
		while(myIterator.hasNext()) {
			Game gameObject = myIterator.next();
			
			if (gameObject.getId() == id) {
				game = gameObject;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		Iterator <Game>  myIterator = games.iterator();

		
		// if found, simply assign that instance to the local variable
		while(myIterator.hasNext()) {
			Game gameObject = myIterator.next();
			
			if (gameObject.getName().equals(name)) {
				game = gameObject;
			}
		}
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
	
	// Method to return the next player id and increments itself.
	public long getNextPlayerId() {
		
		return nextPlayerId++;
		
	}
	
	// Method to return the next player id and increments itself.
	public long getNextTeamId() {
		
		return nextTeamId++;
	}
}
